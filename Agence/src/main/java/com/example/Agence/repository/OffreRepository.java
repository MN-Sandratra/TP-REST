package com.example.Agence.repository;

import com.example.Agence.DTO.ComparateurDTO;
import com.example.Agence.DTO.HotelInfoDTO;
import com.example.Agence.DTO.OffreComparateurDTO;
import com.example.Agence.DTO.OffreDTO;
import com.example.Agence.Data.AgenceData;
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
    private RestTemplate hotelproxy;

    @Autowired
    private WebserviceRepository webserviceRepository;

    public List<OffreComparateurDTO> getOffre(ComparateurDTO comparateur){
        List<OffreComparateurDTO> offres = new ArrayList<>();
        for (Webservice ws :webserviceRepository.findAll()
        ) {
            HotelInfoDTO h=hotelproxy.getForObject(ws.getUri()+"hotel",HotelInfoDTO.class);
            String[] Adresse=h.getAdresse().split(",");


            if(Adresse[1].trim().equals(comparateur.getVille()) && h.getNbEtoile()>=comparateur.getNbrEtoile()){

                OffreDTO offreDTO=new OffreDTO(AgenceData.getAgence().getId(),AgenceData.getAgence().getPassword(),comparateur.getDateDebut(),comparateur.getDateFin(),comparateur.getNbrPerson());

                Offre[] currentOffre = hotelproxy.postForObject(ws.getUri()+"offre",offreDTO, Offre[].class);
                //modif result
                System.out.println(currentOffre);
                for (Offre of: Arrays.asList(currentOffre)
                ) {
                    offres.add(new OffreComparateurDTO(h.getNomHotel(),h.getAdresse().trim(),of.getImage(),of.getNbrLits(),h.getNbEtoile(),of.getPrix()));
                }
            }
        }
        return offres;
    }
}
