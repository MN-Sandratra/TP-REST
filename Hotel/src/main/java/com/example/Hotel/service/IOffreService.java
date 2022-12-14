package com.example.Hotel.service;


import com.example.Hotel.exception.NotPartnerExceptions;
import com.example.Hotel.exception.OffreNotFoundExceptions;
import com.example.Hotel.model.Offre;

import java.util.List;

public interface IOffreService {
    List<Offre> getOffres(int id, String password, String dateDebut, String dateFin, int nbrPersonne) throws NotPartnerExceptions, OffreNotFoundExceptions, NotPartnerExceptions;
}
