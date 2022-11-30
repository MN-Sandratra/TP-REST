package com.example.Agence.DTO;

import java.util.UUID;

public class OffreComparateurDTO {
    private UUID id;
    private String nom_hotel;
    private String pays;
    private String ville;
    private int nbrLits;
    private int nbrEtoile;
    private double prix;

    public OffreComparateurDTO(String nom_hotel, String pays, String ville, int nbrLits, int nbrEtoile, double prix) {
        this.id = UUID.randomUUID();
        this.nom_hotel = nom_hotel;
        this.pays = pays;
        this.ville = ville;
        this.nbrLits = nbrLits;
        this.nbrEtoile = nbrEtoile;
        this.prix = prix;
    }
}
