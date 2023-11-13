
package org.polytech.covid.controller;

import org.polytech.covid.structureBDD.MedecinVaccination;

import java.util.List;

import org.polytech.covid.service.MedecinVaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medecins")
public class MedecinVaccinationController {

    @Autowired
    private MedecinVaccinationService medecinService;

    // Endpoint pour ajouter un médecin (POST)
    @PostMapping("/ajouter") // URL pour ajouter un médecin (POST)
    public MedecinVaccination ajouterMedecin(@RequestBody MedecinVaccination medecin) {
        return medecinService.ajouterMedecin(medecin);
    }

     // Endpoint pour mettre à jour un medecin par ID (PUT)
     @PutMapping("/modifier/{id}")
     public MedecinVaccination modifiermedecin(@PathVariable Integer id, @RequestBody MedecinVaccination medecin) {
         return medecinService.modifiermedecin(id, medecin);
     }

    // Endpoint pour rechercher les medecins par ville (GET) ou par préfixe (GET), pas de ville = findAll
     @GetMapping("/rechercher")
     public List<MedecinVaccination> recherchermedecins(@RequestParam("nom") String nom) {
         return medecinService.recherchermedecins(nom);
     }
}

