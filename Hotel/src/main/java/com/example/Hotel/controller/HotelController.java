package com.example.Hotel.controller;

import com.example.Hotel.DTO.HotelDTO;
import com.example.Hotel.data.HotelData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/hotel")

@RestController
public class HotelController {
    @GetMapping
    public HotelDTO getHotel(){
        return new HotelDTO(HotelData.getHotel().getNomHotel(),HotelData.getHotel().getNbEtoile(),HotelData.getHotel().getAdresse().toString());
    }
}
