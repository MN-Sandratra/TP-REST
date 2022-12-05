package com.example.Hotel.controller;


import com.example.Hotel.DTO.OffreDTO;
import com.example.Hotel.exception.NotPartnerExceptions;
import com.example.Hotel.model.Offre;
import com.example.Hotel.repositories.OffreRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/offre")
@RestController
public class OffreControllerImp implements IOffreController {

    private final OffreRepositoryImp offreRepositoryImp;

    @Autowired
    public OffreControllerImp(OffreRepositoryImp offreRepositoryImp) {
        this.offreRepositoryImp = offreRepositoryImp;
    }

    @Override
    @PostMapping
    public List<Offre> getOffres(@RequestBody OffreDTO offreDTO) throws NotPartnerExceptions, NotPartnerExceptions {
        return offreRepositoryImp.getOffres(offreDTO.getId(),offreDTO.getPassword(),offreDTO.getDateDebut(),offreDTO.getDateFin(),offreDTO.getNbrPerson());
    }

    @GetMapping
    public String HelloHotel(){
        return "Hello Hotel";
    }
}
