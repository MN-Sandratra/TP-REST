package com.example.Hotel.repositories;

import com.example.Hotel.data.HotelData;
import com.example.Hotel.exception.NotPartnerExceptions;
import com.example.Hotel.exception.OffreNotFoundExceptions;
import com.example.Hotel.model.Client;
import com.example.Hotel.model.Offre;
import com.example.Hotel.model.Partenariat;
import com.example.Hotel.model.Reservation;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ReservationRepositoryImp implements IReservationRepository{
    private final HotelData hotelData;
    public ReservationRepositoryImp(HotelData hotelData){
        this.hotelData = hotelData;
    }
    @Override
    public String Reservation(int id, String login, String password, UUID offre, String nom, String prenom, String cartecredit) throws NotPartnerExceptions, OffreNotFoundExceptions {
        Client c=new Client(nom,prenom,cartecredit);
        List<Offre> listOffres=new ArrayList<>();
        int index=1;
        Optional<Partenariat> target = HotelData.getHotel().getPartenariats().stream()
                .filter(e -> e.getAgence() == id && e.getPassword().equals(password) && e.getLogin().equals(login))
                .findFirst();
        if (!target.isPresent())
            throw new NotPartnerExceptions(
                    "Incorrect id ,login or password");

        Optional<Offre> offertarget = hotelData.getOffres().stream()
                .filter(e -> e.getId().equals(offre))
                .findFirst();
        if (!offertarget.isPresent())
            throw new OffreNotFoundExceptions(
                    "Aucune offre correspondante");
        Offre currentOffre=offertarget.get();
        LocalDate debut=LocalDate.parse(currentOffre.getDateDeDisponibiliteDeb());
        LocalDate fin=LocalDate.parse(currentOffre.getDateDeDisponibiliteFin());
        Reservation reservation=new Reservation(currentOffre.getChambre(),c,debut,fin);
        HotelData.addReservation(reservation);
        String res="Reservation reussit reference : "+reservation.getId();
        return res;
    }
}
