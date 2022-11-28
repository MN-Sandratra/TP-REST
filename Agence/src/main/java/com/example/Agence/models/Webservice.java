package com.example.Agence.models;

public class Webservice {
        String reservation;
        String Offre;

        public Webservice(String reservation,String offre){
            this.reservation=reservation;
            this.Offre=offre;
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
