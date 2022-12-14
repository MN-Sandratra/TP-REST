package com.example.Agence.DTO;

public class HotelInfoDTO {
    private String nomHotel;
    private int nbEtoile;
    private String adresse;

    public HotelInfoDTO(String nomHotel, int nbEtoile, String adresse) {
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
