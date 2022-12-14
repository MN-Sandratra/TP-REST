package com.example.comparateur.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agence {
    @GeneratedValue
    @Id
    int id;

    String WebService;

    public Agence() {
    }

    public Agence(String webService) {
        WebService = webService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWebService() {
        return WebService;
    }

    public void setWebService(String webService) {
        WebService = webService;
    }
}
