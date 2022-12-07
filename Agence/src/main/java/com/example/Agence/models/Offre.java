package com.example.Agence.models;

import java.util.UUID;

public class Offre {
    private UUID id;
    private int nbrLits;
    private String dateDeDisponibiliteDeb;
    private String dateDeDisponibiliteFin;
    private double prix;

    private String  Image ;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getNbrLits() {
        return nbrLits;
    }

    public void setNbrLits(int nbrLits) {
        this.nbrLits = nbrLits;
    }

    public String getDateDeDisponibiliteDeb() {
        return dateDeDisponibiliteDeb;
    }

    public void setDateDeDisponibiliteDeb(String dateDeDisponibiliteDeb) {
        this.dateDeDisponibiliteDeb = dateDeDisponibiliteDeb;
    }

    public String getDateDeDisponibiliteFin() {
        return dateDeDisponibiliteFin;
    }

    public void setDateDeDisponibiliteFin(String dateDeDisponibiliteFin) {
        this.dateDeDisponibiliteFin = dateDeDisponibiliteFin;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        this.Image = image;
    }
}
