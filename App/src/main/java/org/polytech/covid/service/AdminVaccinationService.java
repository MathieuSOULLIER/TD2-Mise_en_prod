package org.polytech.covid.service;

import org.polytech.covid.structureBDD.AdminVaccination;

import java.util.List;
import java.util.Optional;

import org.polytech.covid.exception.AdminNotFoundException;
import org.polytech.covid.exception.CentreNotFoundException;
import org.polytech.covid.repository.AdminVaccinationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminVaccinationService {

    @Autowired
    private AdminVaccinationRepository adminRepository;


    // Méthode pour créer un admin
    public AdminVaccination ajouterAdmin(AdminVaccination admin) {
        return adminRepository.save(admin);
    }

    // Méthode pour supprimer un admin par ID
      public void supprimerAdmin(Integer id) {
        // Vérifiez si le centre existe avant de le supprimer
        Optional<AdminVaccination> centreOpt = adminRepository.findById(id);
        if (centreOpt.isPresent()) {
            adminRepository.delete(centreOpt.get());
        } else {
            // Gérer le cas où le centre n'existe pas
            throw new CentreNotFoundException("Admin introuvable avec l'ID : " + id);
        }
    }
    
    // Méthode pour mettre à jour un Admin par ID
    public AdminVaccination modifierAdmin(Integer id, AdminVaccination nouveauAdmin) {
        // Vérifiez si le Admin existe avant de le mettre à jour
        AdminVaccination adminExistant = adminRepository.findById(id)
                .orElseThrow(() -> new AdminNotFoundException("Admin introuvable avec l'ID : " + id));

        // Mettez à jour les données du Admin existant
        adminExistant.setNom(nouveauAdmin.getNom());
        adminExistant.setMotDePasse(nouveauAdmin.getMotDePasse());
        adminExistant.setIdCentre(nouveauAdmin.getIdCentre());

        // Enregistrez les modifications dans la base de données
        return adminRepository.save(adminExistant);
    }

     // Méthode pour rechercher les Admins par ville ou par séquence de caractères
   public List<AdminVaccination> rechercherAdmins(String sequence) {
    if (sequence != null && !sequence.isEmpty()) {
    
        return adminRepository.findByNomIgnoreCaseContaining(sequence);
    } else {
       
        return adminRepository.findAll();
    }
}

}
