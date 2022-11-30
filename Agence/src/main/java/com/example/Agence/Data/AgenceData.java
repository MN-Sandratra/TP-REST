package com.example.Agence.Data;

import com.example.Agence.models.Agence;
import com.example.Agence.models.Webservice;

import java.util.ArrayList;
import java.util.List;

public class AgenceData {
    static Agence agence;

    public List<Webservice> getAgenceHotel(){
        return agence.getHotelPartennaire();
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
        agence.setHotelPartennaire(hotelPart);
    }
}
