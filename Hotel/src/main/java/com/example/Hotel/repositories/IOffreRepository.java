package com.example.Hotel.repositories;


import com.example.Hotel.exception.NotPartnerExceptions;
import com.example.Hotel.exception.OffreNotFoundExceptions;
import com.example.Hotel.model.Offre;

import java.util.List;

public interface IOffreRepository {
    List<Offre> getOffres(int id, String password, String dateDebut, String dateFin, int nbrPersonne) throws NotPartnerExceptions, OffreNotFoundExceptions, NotPartnerExceptions;
}
