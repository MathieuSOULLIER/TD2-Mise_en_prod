package org.polytech.covid.service;


import org.polytech.covid.structureBDD.ReservationVaccination;
import org.polytech.covid.repository.ReservationVaccinationRepository;
import org.polytech.covid.exception.ReservationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationVaccinationService {

    @Autowired
    private ReservationVaccinationRepository reservationRepository;

    // Méthode pour ajouter une réservation
    public ReservationVaccination ajouterReservation(ReservationVaccination nouvelleReservation) {
        return reservationRepository.save(nouvelleReservation);
    }

     // Méthode pour supprimer une réservation par ID
     public void supprimerReservation(Integer reservationId) throws ReservationNotFoundException {
        // Vérifiez si la réservation existe
        ReservationVaccination reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ReservationNotFoundException("Réservation non trouvée avec l'ID : " + reservationId));

        // Supprimez la réservation
        reservationRepository.delete(reservation);
    }


  // Méthode pour valider une réservation par ID
  public ReservationVaccination validerReservation(Integer reservationId) throws ReservationNotFoundException {
    // Recherchez la réservation par ID
    ReservationVaccination reservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new ReservationNotFoundException("Réservation non trouvée avec l'ID : " + reservationId));

    // Mettez à jour validationVaccin à true
    reservation.setValidationVaccin(true);

    // Enregistrez la réservation mise à jour
    return reservationRepository.save(reservation);
}

    // Méthode pour rechercher les réservations par nom
    public List<ReservationVaccination> rechercherReservationsParNom(String nom) {
        return reservationRepository.findByNom(nom);
    }

    // Méthode pour renvoyer toutes les réservations
    public List<ReservationVaccination> toutesLesReservations() {
        return reservationRepository.findAll();
    }
}

