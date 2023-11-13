package org.polytech.covid.repository;

import java.util.List;

import org.polytech.covid.structureBDD.ReservationVaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationVaccinationRepository extends JpaRepository<ReservationVaccination, Integer> {
    List<ReservationVaccination> findByNom(String nom);
}