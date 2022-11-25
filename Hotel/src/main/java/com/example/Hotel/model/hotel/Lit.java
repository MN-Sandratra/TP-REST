package com.example.Hotel.model.hotel;

public abstract class Lit {

    private double prix;

    public Lit(double prix) {
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }

    public abstract int getNbPlace();
}
