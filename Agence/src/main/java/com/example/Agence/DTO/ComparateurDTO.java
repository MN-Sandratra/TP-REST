package com.example.Agence.DTO;

public class ComparateurDTO {
    private String ville;
    private String dateDebut;
    private String dateFin;
    int nbrPerson;
    int nbretoile;

    public ComparateurDTO(String ville, String dateDebut, String dateFin, int nbrPerson, int nbretoile) {
        this.ville = ville;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrPerson = nbrPerson;
        this.nbretoile = nbretoile;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrPerson() {
        return nbrPerson;
    }

    public void setNbrPerson(int nbrPerson) {
        this.nbrPerson = nbrPerson;
    }

    public int getNbretoile() {
        return nbretoile;
    }

    public void setNbretoile(int nbretoile) {
        this.nbretoile = nbretoile;
    }
}
