package com.example.Hotel.model;


import com.example.Hotel.model.hotel.Chambre;

import java.time.LocalDate;
import java.util.UUID;

public class Offre {
    private UUID id;
    private int nbrLits;
    private Chambre chambre;
    private String dateDeDisponibiliteDeb;
    private String dateDeDisponibiliteFin;
    private double prix;

    public Offre(int nbrLits, Chambre c, String dateDeDisponibiliteDeb, String getDateDeDisponibiliteFin, double prix) {
        this.id = UUID.randomUUID();
        this.nbrLits = nbrLits;
        this.chambre=c;
        this.dateDeDisponibiliteDeb = dateDeDisponibiliteDeb;
        this.dateDeDisponibiliteFin = getDateDeDisponibiliteFin;
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

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id: "+ id +
                ", nbrLits: " + nbrLits +
                ", Date de debut de disponibilite: " + dateDeDisponibiliteDeb +
                ",Date de debut de disponibilite:" + dateDeDisponibiliteFin +
                ", prix: " + prix + ", chambre: " + chambre +
                '}';
    }
}
