package com.example.Hotel.repositories;

import com.example.Hotel.exception.NotPartnerExceptions;
import com.example.Hotel.exception.OffreNotFoundExceptions;


import java.util.UUID;

public interface IReservationRepository {
    public String Reservation(int id, String login, String Password, UUID offre, String nom, String prenom, String cartecredit) throws NotPartnerExceptions, OffreNotFoundExceptions, NotPartnerExceptions, OffreNotFoundExceptions;
}
