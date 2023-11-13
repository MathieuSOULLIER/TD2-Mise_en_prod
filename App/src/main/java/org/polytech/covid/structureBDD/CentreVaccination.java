package org.polytech.covid.structureBDD;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;

@Entity
@Table(name = "ListeCentre")
public class CentreVaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCentre")
    private Integer idCentre;

    @OneToMany(mappedBy = "centreVaccination")
    @JsonManagedReference
    private List<ReservationVaccination> reservation;
    

    
    @Column(name = "nom")
    private String nom;

    @Column(name = "ville")
    private String ville;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "codePostal")
    private Integer codePostal;

    @Column(name = "heurOuverture")
    private Integer heurOuverture;

    @Column(name = "heurFermeture")
    private Integer heurFermeture;

    public Integer getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(Integer idCentre) {
        this.idCentre = idCentre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public Integer getHeurOuverture() {
        return heurOuverture;
    }

    public void setHeurOuverture(Integer heurOuverture) {
        this.heurOuverture = heurOuverture;
    }

    public Integer getHeurFermeture() {
        return heurFermeture;
    }

    public void setHeurFermeture(Integer heurFermeture) {
        this.heurFermeture = heurFermeture;
    }

   
}
