package com.example.Agence.repository;

import com.example.Agence.DTO.ComparateurDTO;
import com.example.Agence.DTO.OffreComparateurDTO;
import com.example.Agence.models.Hotel;
import com.example.Agence.models.Webservice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OffreRepository {
    @Autowired
    private HotelRepository hotelRepository;
    
    public List<OffreComparateurDTO> getOffre(ComparateurDTO comparateur){
        List<OffreComparateurDTO> offres = new ArrayList<>();
        for (Hotel h :hotelRepository.findAll()
                ) {
            Webservice ws= h.getWebservice();
            if(h.getVille()==comparateur.getVille() && h.getNbrEtoile()<=comparateur.getNbretoile()){

            }
        }
        return offres;
    }
}
