package com.example.comparateur.Data;

import com.example.comparateur.Model.Agence;
import com.example.comparateur.Repository.AgenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AgenceData {
    static Agence agence;
    private Logger logger= LoggerFactory.getLogger(AgenceData.class);

    @Bean
    public CommandLineRunner initDatabase(AgenceRepository agenceRepository){
        return args -> {
            logger.info("Preloading Agence Database");
            String ws="http://localhost:8090/api/comparateur";
            agenceRepository.save(new Agence( "Agence Montpellier",ws));
            logger.info("Save Agence Finished");
        };
    }
    public AgenceData(){

    }
    public static Agence getAgence(){
        return agence;
    }
}
