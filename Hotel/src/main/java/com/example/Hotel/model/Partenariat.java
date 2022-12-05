package com.example.Hotel.model;

public class Partenariat {
    int agence;
    double pourcentage;
    String Password;
    String login;

    public Partenariat(int agence, double pourcentage,String login, String password) {
        this.agence = agence;
        this.pourcentage = pourcentage;
        this.Password = password;
        this.login=login;
    }

    public int getAgence() {
        return agence;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public String getPassword() {
        return Password;
    }

    public String getLogin() {
        return login;
    }
}
