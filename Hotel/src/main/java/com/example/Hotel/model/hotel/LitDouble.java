package com.example.Hotel.model.hotel;

public class LitDouble extends Lit {

    public LitDouble(double prix) {
        super(prix);
    }

    @Override
    public int getNbPlace() {
        return 2;
    }

}
