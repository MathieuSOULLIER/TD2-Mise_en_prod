package org.polytech.covid.service;

import org.polytech.covid.structureBDD.MedecinVaccination;

import java.util.List;

import org.polytech.covid.exception.MedecinNotFoundException;
import org.polytech.covid.repository.MedecinVaccinationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedecinVaccinationService {

    @Autowired
    private MedecinVaccinationRepository medecinRepository;


    // Méthode pour créer un médecin
    public MedecinVaccination ajouterMedecin(MedecinVaccination medecin) {
        return medecinRepository.save(medecin);
    }

    
    // Méthode pour mettre à jour un medecin par ID
    public MedecinVaccination modifiermedecin(Integer id, MedecinVaccination nouveaumedecin) {
        // Vérifiez si le medecin existe avant de le mettre à jour
        MedecinVaccination medecinExistant = medecinRepository.findById(id)
                .orElseThrow(() -> new MedecinNotFoundException("medecin introuvable avec l'ID : " + id));

        // Mettez à jour les données du medecin existant
        medecinExistant.setNom(nouveaumedecin.getNom());
        medecinExistant.setMotDePasse(nouveaumedecin.getMotDePasse());
        medecinExistant.setIdCentre(nouveaumedecin.getIdCentre());

        // Enregistrez les modifications dans la base de données
        return medecinRepository.save(medecinExistant);
    }

     // Méthode pour rechercher les medecins par ville ou par séquence de caractères
   public List<MedecinVaccination> recherchermedecins(String sequence) {
    if (sequence != null && !sequence.isEmpty()) {
    
        return medecinRepository.findByNomIgnoreCaseContaining(sequence);
    } else {
       
        return medecinRepository.findAll();
    }
}

}
