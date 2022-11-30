package com.example.Hotel.model.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Lit {

    @Id
    @GeneratedValue
    private int id;
    private double prix;

    public Lit(double prix) {
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }

    public abstract int getNbPlace();

    public Lit() {
    }
}
