package org.polytech.covid.controller;

import org.polytech.covid.structureBDD.CentreVaccination;
import org.polytech.covid.service.CentreVaccinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CentreVaccinationController {

    @Autowired
    private CentreVaccinationService centreService;

    @PostMapping("/public/centres/ajouter") // L'URL pour ajouter un centre (POST)
    public CentreVaccination ajouterCentre(@RequestBody CentreVaccination centre) {
        return centreService.ajouterCentre(centre);
    }

     // Endpoint pour mettre à jour un centre par ID (PUT)
     @PutMapping("/public/modifier/{id}")
     public CentreVaccination modifierCentre(@PathVariable Integer id, @RequestBody CentreVaccination centre) {
         return centreService.modifierCentre(id, centre);
     }

    // Endpoint pour supprimer un centre par ID (DELETE)
    @DeleteMapping("/private/supprimer/{id}")
    public void supprimerCentre(@PathVariable Integer id) {
        centreService.supprimerCentre(id);
    }

     // Endpoint pour rechercher les centres par ville (GET) ou par préfixe (GET), pas de ville = findAll
     @GetMapping("/public/centres/rechercher")
     public List<CentreVaccination> rechercherCentres(@RequestParam("ville") String ville) {
         return centreService.rechercherCentres(ville);
     }
}
