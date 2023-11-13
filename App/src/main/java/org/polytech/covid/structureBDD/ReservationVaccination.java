package org.polytech.covid.structureBDD;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "ReservationVaccination")
public class ReservationVaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReservation")
    private Integer idReservation;

    @ManyToOne
    @JoinColumn(name = "idCentre")
    @JsonBackReference
    private CentreVaccination centreVaccination;

    @Column(name = "heure")
    private String heure;

    @Column(name = "date")
    private String date;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "mail")
    private String mail;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "validation_vaccin")
    private Boolean validationVaccin;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public CentreVaccination getCentreVaccination() {
        return centreVaccination;
    }

    public void setCentreVaccination(CentreVaccination centreVaccination) {
        this.centreVaccination = centreVaccination;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getValidationVaccin() {
        return validationVaccin;
    }

    public void setValidationVaccin(Boolean validationVaccin) {
        this.validationVaccin = validationVaccin;
    }
}
