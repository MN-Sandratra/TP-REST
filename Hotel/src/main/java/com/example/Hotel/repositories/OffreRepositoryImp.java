package com.example.Hotel.repositories;

import com.example.Hotel.data.HotelData;
import com.example.Hotel.exception.NotPartnerExceptions;
import com.example.Hotel.model.Offre;
import com.example.Hotel.model.Partenariat;
import com.example.Hotel.model.Reservation;
import com.example.Hotel.model.hotel.Chambre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@Repository
public class OffreRepositoryImp implements IOffreRepository {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    private final HotelData hotelData;
    public OffreRepositoryImp(HotelData hotelData) {
        this.hotelData = hotelData;
    }

    @Override
    public List<Offre> getOffres(int id, String password, String dateDebut, String dateFin, int nbrPersonne) throws NotPartnerExceptions {
        List<Offre> listOffres=new ArrayList<>();
        int index=1;
        Optional<Partenariat> target = HotelData.getHotel().getPartenariats().stream()
                .filter(e -> e.getAgence() == id && e.getPassword().equals(password))
                .findFirst();
        if (!target.isPresent())
            throw new NotPartnerExceptions(
                    "Incorrect id or password");

        LocalDate DateFin;
        LocalDate DateDebut;

        try {
            DateFin=LocalDate.parse(dateFin, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            DateDebut=LocalDate.parse(dateDebut, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //Recherche des chambres disponibles
        for (Chambre chambre : chambreRepository.findAll()) {
            boolean testeur=true;
            //update get date libre
            for (Reservation res:reservationRepository.findAll()) {
                if(res.getChambre()==chambre && res.getDateDebut().isBefore(DateFin) && res.getDateFin().isAfter(DateFin)){
                    testeur=false;
                }
                if(res.getChambre()==chambre && (res.getDateDebut().isBefore(DateDebut)) && res.getDateFin().isAfter(DateDebut)){
                    testeur=false;
                }
                if(res.getChambre()==chambre && (res.getDateDebut().isEqual(DateDebut) || res.getDateFin().isEqual(DateFin))){
                    testeur=false;
                }
            }
            if(testeur) {
                double prixTotal = chambre.getPrix(DateDebut, DateFin);
                //Ajout du pourcentage
                prixTotal=getPrix(prixTotal,target.get().getPourcentage());

                if (chambre.getNbPlace() >= nbrPersonne) {
                    Offre res=new Offre(chambre.getNbPlace(),chambre,dateDebut,dateFin,prixTotal);
                    listOffres.add(res);
                    HotelData.AddOffre(res);
                    index++;
                }
            }
        }
        } catch (DateTimeParseException e){
            System.out.println(e.getMessage());
        }
        return listOffres;
    }

    private double getPrix(double prix,double pourcentage){
        double pourcents=(prix*pourcentage)/100;
        return prix+pourcents;
    }
}
