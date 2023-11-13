
package org.polytech.covid.controller;

import org.polytech.covid.structureBDD.SuperAdminVaccination;

import org.polytech.covid.service.SuperAdminVaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/superadmin")
public class SuperAdminVaccinationController {

    @Autowired
    private SuperAdminVaccinationService superAdminService;

    // Endpoint pour ajouter un super admin (POST)
    @PostMapping("/ajouter") // URL pour ajouter un médecin (POST)
    public SuperAdminVaccination ajouterSuperAdmin(@RequestBody SuperAdminVaccination SuperAdmin) {
        return superAdminService.ajouterSuperAdmin(SuperAdmin);
    }
}

