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
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RequestMapping("api/Reservation")
@RestController
public class ReservationControllerImp{

    private final ReservationRepositoryImp reservationRepositoryImp;


    public ReservationControllerImp(ReservationRepositoryImp reservationRepositoryImp) {
        this.reservationRepositoryImp = reservationRepositoryImp;
    }


    @PostMapping
    public String Reservation(@RequestBody ReservationDTO reservationDTO) throws NotPartnerExceptions, OffreNotFoundExceptions, OffreNotFoundExceptions, NotPartnerExceptions {
        return reservationRepositoryImp.Reservation(reservationDTO.getId(),reservationDTO.getLogin(),reservationDTO.getPassword(),reservationDTO.getOffre(), reservationDTO.getNom(), reservationDTO.getPrenom(), reservationDTO.getCartecredit());
    }
}
