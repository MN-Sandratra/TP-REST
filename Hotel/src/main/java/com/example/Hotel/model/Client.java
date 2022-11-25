package com.example.Hotel.model;

import java.util.*;

public class Client {

    private String nomClient;

    private String prenomClient;

    private String infoPaiment;

    public Client(String nomClient, String prenomClient, String infoPaiment) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.infoPaiment = infoPaiment;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    @Override
    public String toString() {
        return nomClient + " " + prenomClient;
    }
}