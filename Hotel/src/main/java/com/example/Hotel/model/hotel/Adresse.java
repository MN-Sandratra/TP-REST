package com.example.Hotel.model.hotel;

public class Adresse {

    private String pays;
    private String ville;
    private String rue;
    private int numero;
    private String lieu;
    private GPS gps;

    public Adresse(String pays, String ville, String rue, int numero, String lieu, GPS gps) {
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.numero = numero;
        this.lieu = lieu;
        this.gps = gps;
    }

    public String getVille() {
        return ville;
    }

    @Override
    public String toString() {
        return "Adresse : [" + pays + ", " + ville + ", " + rue + ", " + numero + ", " + lieu + ", " + gps + "]";
    }
}