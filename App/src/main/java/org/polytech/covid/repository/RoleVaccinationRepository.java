package org.polytech.covid.repository;

import org.polytech.covid.structureBDD.RoleVaccination;

import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleVaccinationRepository extends JpaRepository<RoleVaccination, Integer> {
    // Recherche un rôle par nom et mot de passe
    RoleVaccination findByNomAndMotDePasse(String nom, String motDePasse);

    RoleVaccination findByNom(String username);
}
