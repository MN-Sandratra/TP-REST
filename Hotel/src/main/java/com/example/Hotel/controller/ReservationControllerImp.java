package com.example.Hotel.controller;


import com.example.Hotel.DTO.ReservationDTO;
import com.example.Hotel.exception.NotPartnerExceptions;
import com.example.Hotel.exception.OffreNotFoundExceptions;
import com.example.Hotel.repositories.ReservationRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("api/Reservation")
@RestController
public class ReservationControllerImp implements IReservationService{

    private final ReservationRepositoryImp reservationRepositoryImp;

    @Autowired
    public ReservationControllerImp(ReservationRepositoryImp reservationRepositoryImp) {
        this.reservationRepositoryImp = reservationRepositoryImp;
    }

    @Override
    @PostMapping
    public String Reservation(@RequestBody int id, String login, String Password, UUID offre, String nom, String prenom, String cartecredit) throws NotPartnerExceptions, OffreNotFoundExceptions, OffreNotFoundExceptions, NotPartnerExceptions {
        return reservationRepositoryImp.Reservation(id,login,Password,offre,nom,prenom,cartecredit);
    }
}
