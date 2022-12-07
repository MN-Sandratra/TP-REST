package com.example.comparateur.dto;

public class ComparateurDTO {
    private String ville;
    private String dateDebut;
    private String dateFin;
    int nbrPerson;
    int nbrEtoile;

    public ComparateurDTO(String ville, String dateDebut, String dateFin, int nbrPerson, int nbretoile) {
        this.ville = ville;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbrPerson = nbrPerson;
        this.nbrEtoile = nbretoile;
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

    public int getNbrEtoile() {
        return nbrEtoile;
    }

    public void setNbretoile(int nbretoile) {
        this.nbrEtoile = nbretoile;
    }
}
