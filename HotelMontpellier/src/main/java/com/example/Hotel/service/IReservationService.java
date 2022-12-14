package com.example.Hotel.service;

import com.example.Hotel.exception.NotPartnerExceptions;
import com.example.Hotel.exception.OffreNotFoundExceptions;
import com.example.Hotel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface IReservationService {
    public String Reservation(int id, String login, String Password, UUID offre, String nom, String prenom, String cartecredit) throws NotPartnerExceptions, OffreNotFoundExceptions, NotPartnerExceptions, OffreNotFoundExceptions;
}
