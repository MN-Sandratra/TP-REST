package com.example.Hotel.controller;


import com.example.Hotel.DTO.ReservationDTO;
import com.example.Hotel.exception.NotPartnerExceptions;
import com.example.Hotel.exception.OffreNotFoundExceptions;
import com.example.Hotel.service.ReservationServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/reservation")
@RestController
public class ReservationControllerImp{

    private final ReservationServiceImp reservationRepositoryImp;


    public ReservationControllerImp(ReservationServiceImp reservationRepositoryImp) {
        this.reservationRepositoryImp = reservationRepositoryImp;
    }


    @PostMapping
    public String Reservation(@RequestBody ReservationDTO reservationDTO) throws NotPartnerExceptions, OffreNotFoundExceptions, OffreNotFoundExceptions, NotPartnerExceptions {
        return reservationRepositoryImp.Reservation(reservationDTO.getId(),reservationDTO.getLogin(),reservationDTO.getPassword(),reservationDTO.getOffre(), reservationDTO.getNom(), reservationDTO.getPrenom(), reservationDTO.getCartecredit());
    }
}
