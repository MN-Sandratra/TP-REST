package com.example.Hotel.model.hotel;

public class LitSimple extends Lit {

    public LitSimple(double prix) {
        super(prix);

    }

    @Override
    public int getNbPlace() {
        return 1;
    }
}

