package com.example.Agence.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Hotel {

    @Id
    private int id;
    private String Nom;
    private String Pays;
    private String Ville;
    private int nbrEtoile;
    @OneToOne(cascade=CascadeType.ALL)
    private Webservice webservice;


    public Hotel(int id, String nom, String pays, String ville, int nbrEtoile, Webservice webservice) {
        this.id = id;
        Nom = nom;
        Pays = pays;
        Ville = ville;
        this.nbrEtoile = nbrEtoile;
        this.webservice = webservice;
    }

    public Hotel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String pays) {
        Pays = pays;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public int getNbrEtoile() {
        return nbrEtoile;
    }

    public void setNbrEtoile(int nbrEtoile) {
        this.nbrEtoile = nbrEtoile;
    }

    public Webservice getWebservice() {
        return webservice;
    }

    public void setWebservice(Webservice webservice) {
        this.webservice = webservice;
    }
}
