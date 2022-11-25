package com.example.Hotel.model;

import com.example.Hotel.model.hotel.Chambre;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {

    private UUID id;
    private Chambre chambre;
    private Client client;
    private LocalDate dateDebut;

    private LocalDate dateFin;

    public Reservation(Chambre chambre, Client client, LocalDate dateDebut, LocalDate dateFin) {
        this.id=UUID.randomUUID();
        this.chambre = chambre;
        this.client = client;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[Chambre : " + chambre.getNumeroChambre() + ", Client: " + client.getNomClient() + " " + client.getPrenomClient() + ", Date de début: " + dateDebut + ", Date de fin: " + dateFin + "]";
    }
}