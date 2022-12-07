package com.example.Hotel.DTO;

import com.example.Hotel.model.Partenariat;
import com.example.Hotel.model.hotel.Adresse;

import java.util.List;

public class HotelDTO {
    private String nomHotel;
    private int nbEtoile;
    private String adresse;

    public HotelDTO(String nomHotel, int nbEtoile, String adresse) {
        this.nomHotel = nomHotel;
        this.nbEtoile = nbEtoile;
        this.adresse = adresse;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public int getNbEtoile() {
        return nbEtoile;
    }

    public void setNbEtoile(int nbEtoile) {
        this.nbEtoile = nbEtoile;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
