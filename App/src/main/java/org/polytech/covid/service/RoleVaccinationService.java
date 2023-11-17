package org.polytech.covid.service;

import java.util.Optional;

import org.polytech.covid.SecurityConfig;
import org.polytech.covid.exception.RoleNotFoundException;
import org.polytech.covid.repository.RoleVaccinationRepository;
import org.polytech.covid.structureBDD.RoleVaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.annotation.PostConstruct;

@Service
@Transactional // Assure une transaction pour la méthode
public class RoleVaccinationService {

    
	@Autowired
    private SecurityConfig SecurityConfig;

    @Autowired
    private RoleVaccinationRepository roleRepository;

       public RoleVaccination ajouterRole(RoleVaccination Role) {
        // ajouter ici la logique de validation ou de traitement des données

       
        return roleRepository.save(Role);
    }

    @PostConstruct
    public void createSuperAdmin() {

        // Vérifiez d'abord si l'objet SuperAdmin n'existe pas déjà
        RoleVaccination superAdmin = roleRepository.findByNomAndMotDePasse("SuperAdmin", "SuperAdmin");
        
        if (superAdmin == null) {
            superAdmin = new RoleVaccination();
            superAdmin.setNom("SuperAdmin");
            superAdmin.setMotDePasse(SecurityConfig.passwordEncoder().encode("SuperAdmin")); 
            superAdmin.setRole("ROLE_SUPER_ADMIN"); 
            roleRepository.save(superAdmin);
        }
    }



    // Méthode pour mettre à jour un Role par ID
    public RoleVaccination modifierRole(Integer id, RoleVaccination nouveauRole) {
        // Vérifiez si le Role existe avant de le mettre à jour
        RoleVaccination RoleExistant = roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role introuvable avec l'ID : " + id));

        // Mettez à jour les données du Role existant
        RoleExistant.setNom(nouveauRole.getNom());
        RoleExistant.setMotDePasse(nouveauRole.getMotDePasse());
        RoleExistant.setRole(nouveauRole.getRole());

        // Enregistrez les modifications dans la base de données
        return roleRepository.save(RoleExistant);
    }


      // Méthode pour supprimer un Role par ID
      public void supprimerRole(Integer id) {
        // Vérifiez si le Role existe avant de le supprimer
        Optional<RoleVaccination> RoleOpt = roleRepository.findById(id);
        if (RoleOpt.isPresent()) {
            roleRepository.delete(RoleOpt.get());
        } else {
            // Gérer le cas où le Role n'existe pas
            throw new RoleNotFoundException("Role introuvable avec l'ID : " + id);
        }
    }
    /* 
    public RoleVaccination rechercherRoleParNomEtMotDePasse(String nom, String motDePasse) {
       // return roleRepository.findByNomAndMotDePasse(nom, motDePasse);
    }*/
    
}
