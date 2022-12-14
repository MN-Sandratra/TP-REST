package com.example.Hotel.data;

import com.example.Hotel.model.Client;
import com.example.Hotel.model.Offre;
import com.example.Hotel.model.Partenariat;
import com.example.Hotel.model.Reservation;
import com.example.Hotel.model.hotel.*;
import com.example.Hotel.repositories.ChambreRepository;
import com.example.Hotel.repositories.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class HotelData {

    private Logger logger= LoggerFactory.getLogger(HotelData.class);

    @Bean
    public CommandLineRunner initDatabase(ChambreRepository chambreRepository, ReservationRepository reservationRepository){
        Lit litS = new LitSimple(10);
        Lit litD = new LitDouble(15);
        Chambre chambre1 = new Chambre(1, new ArrayList<Lit>() {{
            add(litS);
            add(litD);
        }}, "https://cdn.discordapp.com/attachments/630008591499132950/1040361384694784070/image.png");

        Lit litD2 = new LitDouble(15);
        Lit litD3 = new LitDouble(15);
        Chambre chambre2 = new Chambre(2, new ArrayList<Lit>() {{
            add(litD2);
            add(litD3);
        }}, "https://cdn.discordapp.com/attachments/630008591499132950/1040361507063607406/image.png");

        Lit litS2 = new LitSimple(10);
        Lit litS3 = new LitSimple(10);
        Lit litS4 = new LitSimple(10);
        Chambre chambre3 = new Chambre(3, new ArrayList<Lit>() {{
            add(litS2);
            add(litS3);
            add(litS4);
        }}, "https://cdn.discordapp.com/attachments/630008591499132950/1040613243632222248/image.png");

        Client client1 = new Client("Dupont", "Jean", "visa");
        Client client2 = new Client("Durand", "Paul", "mastercard");


        GPS gps1 = new GPS(1, 2, 3);

        Adresse adresse1 = new Adresse("France", "Paris", "rue de la paix", 1, "Tour Eiffel", gps1);

        List<Chambre> listChambre1 = new ArrayList<Chambre>() {{
            add(chambre1);
            add(chambre2);
            add(chambre3);
        }};

        h = new Hotel("Ibis", 4, adresse1, listChambre1);
        List<Partenariat> p=new ArrayList<>();
        p.addAll(Arrays.asList(
                new Partenariat(1,3, "AgenceMontpellier","test123"),
                new Partenariat(2,5,"Covoyageur","test1234")
        ));
        h.setPartenariats(p);

        return args -> {
            logger.info("Preloading Chambre Database");
            chambreRepository.save(chambre1);
            chambreRepository.save(chambre2);
            chambreRepository.save(chambre3);
            logger.info("Save Chambre Finished");

            logger.info("Preloading Reservation Database");

            reservationRepository.save(new Reservation(chambre1, client1, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 2) ));
            reservationRepository.save(new Reservation(chambre2, client1, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 4, 16)));
            reservationRepository.save(new Reservation(chambre3, client2, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 2)));
            logger.info("Save Reservation Finished");


        };
    };
    static Hotel h;
    static List<Reservation> reservations=new ArrayList<>();

    static List<Offre> offres=new ArrayList<>();

    public HotelData(){
        //initialize();
    }

    public static Hotel getHotel() {
        return h;
    }

    public static List<Offre> getOffres() {
        return offres;
    }

    public static void AddOffre(Offre o){
        offres.add(o);
    }

    public static List<Reservation> getReservations() {
        return reservations;
    }

    public static void addReservation(Reservation res){
        reservations.add(res);
    }

}
