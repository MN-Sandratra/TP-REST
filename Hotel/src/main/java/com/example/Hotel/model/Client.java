package com.example.Hotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.*;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private int id;
    private String nomClient;

    private String prenomClient;

    private String infoPaiment;

    public Client(String nomClient, String prenomClient, String infoPaiment) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.infoPaiment = infoPaiment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getInfoPaiment() {
        return infoPaiment;
    }

    public void setInfoPaiment(String infoPaiment) {
        this.infoPaiment = infoPaiment;
    }

    public Client() {
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