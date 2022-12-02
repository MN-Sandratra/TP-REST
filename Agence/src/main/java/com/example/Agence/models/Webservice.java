package com.example.Agence.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Webservice {
        @Id
        @GeneratedValue
        int id;
        String reservation;
        String Offre;

        public Webservice(String reservation,String offre){
            this.reservation=reservation;
            this.Offre=offre;
        }

    public Webservice() {

    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String getOffre() {
        return Offre;
    }

    public void setOffre(String offre) {
        Offre = offre;
    }
}
