package com.example.comparateur.dto;

import java.util.UUID;

public class OffreComparateurResDTO {
    private UUID id;
    private String nom_hotel;
    private String adresse;

    private String image;
    private int nbrLits;
    private int nbrEtoile;
    private double prix;

    public OffreComparateurResDTO(UUID id,String nom_hotel, String adresse, String image, int nbrLits, int nbrEtoile, double prix) {
        this.id = id;
        this.nom_hotel = nom_hotel;
        this.adresse = adresse;
        this.image=image;
        this.nbrLits = nbrLits;
        this.nbrEtoile = nbrEtoile;
        this.prix = prix;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNom_hotel() {
        return nom_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbrLits() {
        return nbrLits;
    }

    public void setNbrLits(int nbrLits) {
        this.nbrLits = nbrLits;
    }

    public int getNbrEtoile() {
        return nbrEtoile;
    }

    public void setNbrEtoile(int nbrEtoile) {
        this.nbrEtoile = nbrEtoile;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
