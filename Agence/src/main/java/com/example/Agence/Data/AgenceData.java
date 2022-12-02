package com.example.Agence.Data;

import com.example.Agence.models.Agence;
import com.example.Agence.models.Hotel;
import com.example.Agence.models.Webservice;
import com.example.Agence.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AgenceData {
    static Agence agence;
    private Logger logger= LoggerFactory.getLogger(AgenceData.class);

    @Bean
    public CommandLineRunner initDatabase(HotelRepository hotelRepository){
        Webservice h1=new Webservice("http://localhost:8080/api/reservation","http://localhost:8080/api/offre");
        return args -> {
            logger.info("Preloading Hotel Database");
            hotelRepository.save(new Hotel(1, "Ibis","France", "Paris", 4, h1));
            logger.info("Save Hotel Finished");
        };
    }
    public AgenceData(){
        initialise();
    }
    public static Agence getAgence(){
        return agence;
    }

    private void initialise(){
        List<Webservice> hotelPart = new ArrayList<>();
        agence=new Agence();
        agence.setId(1);
        agence.setLogin("AgenceMontpellier");
        agence.setPassword("test123");

        Webservice h1=new Webservice("http://localhost:8080/api/reservation","http://localhost:8080/api/offre");
        hotelPart.add(h1);
    }
}
