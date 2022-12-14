package com.example.Agence.DTO;

public class OffreDTO {
    int id;
    String password;
    String dateDebut;
    String dateFin;
    int nbrPerson;

    public OffreDTO(int id, String password, String dateDebut, String dateFin, int nbrPerson) {
        this.id = id;
        this.password = password;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrPerson = nbrPerson;
    }

    public String getPassword() {
        return password;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public int getNbrPerson() {
        return nbrPerson;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setNbrPerson(int nbrPerson) {
        this.nbrPerson = nbrPerson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
