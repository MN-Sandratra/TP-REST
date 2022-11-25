package com.example.Hotel.model.hotel;

import com.example.Hotel.model.Partenariat;

import java.util.*;

public class Hotel {

    private List<Partenariat> partenariats;
    private String nomHotel;
    private int nbEtoile;
    private Adresse adresse;
    private List<Chambre> chambres;

    public Hotel(String nomHotel, int nbEtoile, Adresse adresse, List<Chambre> chambres) {
        this.nomHotel = nomHotel;
        this.nbEtoile = nbEtoile;
        this.adresse = adresse;
        this.chambres = chambres;
        chambres=new ArrayList<>();
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public int getNbEtoile() {
        return nbEtoile;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public List<Partenariat> getPartenariats() {
        return partenariats;
    }

    public void setPartenariats(List<Partenariat> partenariats) {
        this.partenariats = partenariats;
    }
}