package com.example.Agence.repository;

import com.example.Agence.DTO.ComparateurDTO;
import com.example.Agence.DTO.OffreComparateurDTO;
import com.example.Agence.DTO.OffreDTO;
import com.example.Agence.Data.AgenceData;
import com.example.Agence.models.Hotel;
import com.example.Agence.models.Offre;
import com.example.Agence.models.Webservice;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class OffreRepository {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RestTemplate hotelproxy;

    public List<OffreComparateurDTO> getOffre(ComparateurDTO comparateur){
        List<OffreComparateurDTO> offres = new ArrayList<>();
        for (Hotel h :hotelRepository.findAll()
        ) {
            System.out.println("eto :"+h.getVille() +" Hotel: "+h.getNbrEtoile()+" Etoiles");
            System.out.println(" tadiaviko  die ao :"+comparateur.getVille() +" Hotel: "+comparateur.getNbrEtoile()+" Etoiles");
            Webservice ws= h.getWebservice();
            if(h.getVille().equals(comparateur.getVille()) && h.getNbrEtoile()>=comparateur.getNbrEtoile()){
                OffreDTO offreDTO=new OffreDTO(AgenceData.getAgence().getId(),AgenceData.getAgence().getPassword(),comparateur.getDateDebut(),comparateur.getDateFin(),comparateur.getNbrPerson());
                Offre[] currentOffre = hotelproxy.postForObject(ws.getOffre(),offreDTO, Offre[].class);
                //modif result
                for (Offre of: Arrays.asList(currentOffre)
                ) {
                    offres.add(new OffreComparateurDTO(h.getNom(),h.getPays(),h.getVille(),of.getNbrLits(),of.getNbrLits(),of.getPrix()));
                }
            }
        }
        return offres;
    }
}
