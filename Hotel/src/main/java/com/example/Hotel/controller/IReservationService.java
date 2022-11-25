package com.example.Hotel.controller;

import com.example.Hotel.exception.NotPartnerExceptions;
import com.example.Hotel.exception.OffreNotFoundExceptions;
import java.util.UUID;

public interface IReservationService {
    public String Reservation(int id, String login, String Password, UUID offre, String nom, String prenom, String cartecredit) throws NotPartnerExceptions, OffreNotFoundExceptions, OffreNotFoundExceptions, NotPartnerExceptions;
}
