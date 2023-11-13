package org.polytech.covid.service;

import org.polytech.covid.structureBDD.CentreVaccination;
import org.polytech.covid.repository.CentreVaccinationRepository;
import org.polytech.covid.exception.CentreNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CentreVaccinationService {

    @Autowired
    private CentreVaccinationRepository centreRepository;

    public CentreVaccination ajouterCentre(CentreVaccination centre) {
        // ajouter ici la logique de validation ou de traitement des données
        return centreRepository.save(centre);
    }


    // Méthode pour mettre à jour un centre par ID
    public CentreVaccination modifierCentre(Integer id, CentreVaccination nouveauCentre) {
        // Vérifiez si le centre existe avant de le mettre à jour
        CentreVaccination centreExistant = centreRepository.findById(id)
                .orElseThrow(() -> new CentreNotFoundException("Centre introuvable avec l'ID : " + id));

        // Mettez à jour les données du centre existant
        centreExistant.setVille(nouveauCentre.getVille());
        centreExistant.setNom(nouveauCentre.getNom());
        centreExistant.setAdresse(nouveauCentre.getAdresse());
        centreExistant.setCodePostal(nouveauCentre.getCodePostal());
        centreExistant.setHeurOuverture(nouveauCentre.getHeurOuverture());
        centreExistant.setHeurFermeture(nouveauCentre.getHeurFermeture());

        // Enregistrez les modifications dans la base de données
        return centreRepository.save(centreExistant);
    }


      // Méthode pour supprimer un centre par ID
      public void supprimerCentre(Integer id) {
        // Vérifiez si le centre existe avant de le supprimer
        Optional<CentreVaccination> centreOpt = centreRepository.findById(id);
        if (centreOpt.isPresent()) {
            centreRepository.delete(centreOpt.get());
        } else {
            // Gérer le cas où le centre n'existe pas
            throw new CentreNotFoundException("Centre introuvable avec l'ID : " + id);
        }
    }

  
   // Méthode pour rechercher les centres par ville ou par séquence de caractères
   public List<CentreVaccination> rechercherCentres(String sequence) {
    if (sequence != null && !sequence.isEmpty()) {
    
        return centreRepository.findByVilleIgnoreCaseContaining(sequence);
    } else {
       
        return centreRepository.findAll();
    }
}

}

