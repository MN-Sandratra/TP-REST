package com.example.Agence.DTO;

import java.util.UUID;

public class ReservationDTO {
    int id;
    String login;
    String password;
    String offre;
    String nom;
    String prenom;
    String cartecredit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCartecredit() {
        return cartecredit;
    }

    public void setCartecredit(String cartecredit) {
        this.cartecredit = cartecredit;
    }

    public ReservationDTO(int id, String login, String password, String offre, String nom, String prenom, String cartecredit) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.offre = offre;
        this.nom = nom;
        this.prenom = prenom;
        this.cartecredit = cartecredit;
    }
}
