package org.polytech.covid.service;

import org.polytech.covid.structureBDD.SuperAdminVaccination;


import org.polytech.covid.repository.SuperAdminVaccinationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SuperAdminVaccinationService {

    @Autowired
    private SuperAdminVaccinationRepository superAdminRepository;


    // Méthode pour créer un médecin
    public SuperAdminVaccination ajouterSuperAdmin(SuperAdminVaccination superAdmin) {
        return superAdminRepository.save(superAdmin);
    }

   
}
