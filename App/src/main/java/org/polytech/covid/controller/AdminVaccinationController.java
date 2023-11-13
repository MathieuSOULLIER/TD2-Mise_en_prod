
package org.polytech.covid.controller;

import org.polytech.covid.structureBDD.AdminVaccination;

import java.util.List;

import org.polytech.covid.service.AdminVaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminVaccinationController {

    @Autowired
    private AdminVaccinationService adminService;

    // Endpoint pour ajouter un médecin (POST)
    @PostMapping("/ajouter") // URL pour ajouter un médecin (POST)
    public AdminVaccination ajouterAdmin(@RequestBody AdminVaccination admin) {
        return adminService.ajouterAdmin(admin);
    }

     // Endpoint pour mettre à jour un Admin par ID (PUT)
     @PutMapping("/modifier/{id}")
     public AdminVaccination modifierAdmin(@PathVariable Integer id, @RequestBody AdminVaccination admin) {
         return adminService.modifierAdmin(id, admin);
     }

     // Endpoint pour supprimer un admin par ID (DELETE)
    @DeleteMapping("/supprimer/{id}")
    public void supprimerAdmin(@PathVariable Integer id) {
        adminService.supprimerAdmin(id);
    }

    // Endpoint pour rechercher les Admins par ville (GET) ou par préfixe (GET), pas de ville = findAll
     @GetMapping("/rechercher")
     public List<AdminVaccination> rechercherAdmins(@RequestParam("nom") String nom) {
         return adminService.rechercherAdmins(nom);
     }
}

