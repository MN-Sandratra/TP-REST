package com.example.comparateur.DTO;

import java.util.UUID;

public class OffreComparateurResDTO {
    private UUID id;
    private String nom_hotel;
    private String pays;
    private String ville;
    private int nbrLits;
    private int nbrEtoile;
    private double prix;

    public OffreComparateurResDTO(String nom_hotel, String pays, String ville, int nbrLits, int nbrEtoile, double prix) {
        this.id = UUID.randomUUID();
        this.nom_hotel = nom_hotel;
        this.pays = pays;
        this.ville = ville;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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
}
