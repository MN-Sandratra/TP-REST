package com.example.Hotel.model;

import com.example.Hotel.model.hotel.Chambre;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Reservation {

    @Id
    @Type(type = "uuid-char")
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL)
    private Chambre chambre;
    @OneToOne(cascade = CascadeType.ALL)
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

    public Reservation() {
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