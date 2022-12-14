package com.example.Agence.Data;

import com.example.Agence.models.Agence;
import com.example.Agence.models.Webservice;;
import com.example.Agence.repository.WebserviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public CommandLineRunner initDatabase(WebserviceRepository webserviceRepository){
        return args -> {
            logger.info("Preloading Hotel Database");
            webserviceRepository.save(new Webservice("http://localhost:8080/api/"));
            webserviceRepository.save(new Webservice("http://localhost:8081/api/"));
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
        agence=new Agence();
        agence.setId(2);
        agence.setLogin("Covoyageur");
        agence.setPassword("test1234");
        agence.setNom("Les Covoyageur");
    }
}
