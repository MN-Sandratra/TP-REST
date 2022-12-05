package com.example.Hotel.model.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Adresse {

    private int Id;
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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public GPS getGps() {
        return gps;
    }

    public void setGps(GPS gps) {
        this.gps = gps;
    }

    @Override
    public String toString() {
        return "Adresse : [" + pays + ", " + ville + ", " + rue + ", " + numero + ", " + lieu + ", " + gps + "]";
    }
}