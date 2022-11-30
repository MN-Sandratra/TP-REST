package com.example.Hotel.model.hotel;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Entity
public class Chambre {
    public Chambre() {
    }

    @Id
    private int numeroChambre;

    @ElementCollection
    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Lit> lits;

    private String image;

    public Chambre(int numeroChambre, List<Lit> lits, String image) {
        this.numeroChambre = numeroChambre;
        this.lits = lits;
        this.image = image;
    }

    public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int nbLits() {
        return lits.size();
    }

    public int getNbPlace() {
        int nbPlace = 0;
        for (Lit lit : lits) {
            nbPlace += lit.getNbPlace();
        }
        return nbPlace;
    }

    public double getPrix(LocalDate dateArrivee, LocalDate dateDepart){
        double prix = 0;
        for(Lit lit : lits){
            prix += lit.getPrix();
        }
        return prix * dateArrivee.until(dateDepart).getDays();
    }

    public double getPrix(){
        double prix = 0;
        for(Lit lit : lits){
            prix += lit.getPrix();
        }
        return prix;
    }

    @Override
    public String toString() {
        return String.valueOf(numeroChambre);
    }
}