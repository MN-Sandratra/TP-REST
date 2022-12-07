package com.example.Hotel.model;


import com.example.Hotel.model.hotel.Chambre;

import java.time.LocalDate;
import java.util.UUID;

public class Offre {
    private UUID id;
    private int nbrLits;
    private String Image;
    private int ChambreId;
    private String dateDeDisponibiliteDeb;
    private String dateDeDisponibiliteFin;
    private double prix;

    public Offre(int nbrLits, String image, int chambreId, String dateDeDisponibiliteDeb, String dateDeDisponibiliteFin, double prix) {
        this.id = UUID.randomUUID();
        this.nbrLits = nbrLits;
        Image = image;
        ChambreId = chambreId;
        this.dateDeDisponibiliteDeb = dateDeDisponibiliteDeb;
        this.dateDeDisponibiliteFin = dateDeDisponibiliteFin;
        this.prix = prix;
    }



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
        Image = image;
    }

    public int getChambreId() {
        return ChambreId;
    }

    public void setChambreId(int chambreId) {
        ChambreId = chambreId;
    }
}
