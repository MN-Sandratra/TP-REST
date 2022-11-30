package com.example.Hotel.model.hotel;

import javax.persistence.Entity;

@Entity
public class LitSimple extends Lit {

    public LitSimple(double prix) {
        super(prix);

    }

    public LitSimple() {
        super();
    }

    @Override
    public int getNbPlace() {
        return 1;
    }
}

