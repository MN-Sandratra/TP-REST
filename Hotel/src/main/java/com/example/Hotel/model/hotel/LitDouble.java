package com.example.Hotel.model.hotel;

import javax.persistence.Entity;

@Entity
public class LitDouble extends Lit {
    public LitDouble() {
        super();
    }

    public LitDouble(double prix) {
        super(prix);
    }

    @Override
    public int getNbPlace() {
        return 2;
    }

}
