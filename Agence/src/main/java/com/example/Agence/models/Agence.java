package com.example.Agence.models;

import java.util.ArrayList;
import java.util.List;

public class Agence {
    int id ;
    String Login;
    String Password;

    List<Webservice> Hotelpartenaire;


    public Agence() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setHotelPartennaire(List<Webservice> hotelPart) {
        Hotelpartenaire=hotelPart;
    }
    public List<Webservice> getHotelPartennaire() {
        return Hotelpartenaire;
    }
}
