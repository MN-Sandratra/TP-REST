package com.example.Hotel.controller;


import com.example.Hotel.DTO.OffreDTO;
import com.example.Hotel.exception.NotPartnerExceptions;
import com.example.Hotel.model.Offre;

import java.util.List;

public interface IOffreController {

    List<Offre> getOffres(OffreDTO offreDTO) throws NotPartnerExceptions;
}
