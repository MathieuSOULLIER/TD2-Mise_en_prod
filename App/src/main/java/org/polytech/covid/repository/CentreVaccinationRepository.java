package org.polytech.covid.repository;

import java.util.List;

import org.polytech.covid.structureBDD.CentreVaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreVaccinationRepository extends JpaRepository<CentreVaccination, Integer> {
    List<CentreVaccination> findByVilleIgnoreCaseContaining(String sequence);
}
