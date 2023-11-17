package org.polytech.covid.controller;

import org.polytech.covid.SecurityConfig;
import org.polytech.covid.service.RoleVaccinationService;
import org.polytech.covid.structureBDD.RoleVaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("")
public class RoleVaccinationController {

    @Autowired
    private RoleVaccinationService roleService;

    @Autowired
    private SecurityConfig SecurityConfig;

       @PostMapping("/public/roles/ajouter") // L'URL pour ajouter un Role (POST)
    public RoleVaccination ajouterRole(@RequestBody RoleVaccination Role) {
        return roleService.ajouterRole(Role);
    }

     // Endpoint pour mettre à jour un Role par ID (PUT)
     @PutMapping("/public/roles/modifier/{id}")
     public RoleVaccination modifierRole(@PathVariable Integer id, @RequestBody RoleVaccination Role) {
         return roleService.modifierRole(id, Role);
     }

    // Endpoint pour supprimer un Role par ID (DELETE)
    @DeleteMapping("/private/roles/supprimer/{id}")
    public void supprimerRole(@PathVariable Integer id) {
        roleService.supprimerRole(id);
    }

    
    @GetMapping("/public/roles/rechercher")
public String rechercherRoleParNomEtMotDePasse() {
     return "Rôle non trouvé.";
    }
}
   /*  try {
        
        RoleVaccination role = roleService.rechercherRoleParNomEtMotDePasse(nom, SecurityConfig.passwordEncoder().encode(motDePasse));
        if (role != null) {
            return ResponseEntity.ok(role); // Renvoie le rôle si trouvé
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rôle non trouvé.");
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la recherche du rôle.");
    }
*/


