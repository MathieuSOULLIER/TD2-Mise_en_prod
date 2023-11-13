package org.polytech.covid.controller;

import org.polytech.covid.structureBDD.ReservationVaccination;
import org.polytech.covid.service.ReservationVaccinationService;
import org.polytech.covid.exception.ReservationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationVaccinationController {

    @Autowired
    private ReservationVaccinationService reservationService;


    // Endpoint pour ajouter une réservation avec validationVaccin à false (POST)
    @PostMapping("/ajouter")
    public ReservationVaccination ajouterReservation(@RequestBody ReservationVaccination nouvelleReservation) {
        // Fixez la validation de la vaccination à false
        nouvelleReservation.setValidationVaccin(false);

        // Enregistrez la nouvelle réservation
        return reservationService.ajouterReservation(nouvelleReservation);
    }

    
    // Endpoint pour supprimer une réservation par ID (DELETE)
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<?> supprimerReservation(@PathVariable Integer id) {
        try {
            reservationService.supprimerReservation(id);
            return ResponseEntity.ok("Réservation supprimée avec succès.");
        } catch (ReservationNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Réservation non trouvée.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la suppression de la réservation.");
        }
    }

      // Endpoint pour mettre à jour la validationVaccin d'une réservation (PATCH)
      @PatchMapping("/valider/{id}")
      public ResponseEntity<?> validerReservation(@PathVariable Integer id) {
          try {
              ReservationVaccination reservation = reservationService.validerReservation(id);
              return ResponseEntity.ok("Réservation validée avec succès. ID : " + reservation.getIdReservation());
          } catch (ReservationNotFoundException e) {
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Réservation non trouvée.");
          } catch (Exception e) {
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la validation de la réservation.");
          }
        }


    // Endpoint pour afficher les réservations en fonction du nom (GET)
    @GetMapping("/afficher")
    public List<ReservationVaccination> afficherReservations(@RequestParam(name = "nom", required = false) String nom) {
        if (nom != null && !nom.isEmpty()) {
            // Si un nom est spécifié, recherchez les réservations par nom
            return reservationService.rechercherReservationsParNom(nom);
        } else {
            // Si aucun nom n'est spécifié, retournez toutes les réservations
            return reservationService.toutesLesReservations();
        }
    }
}

