package org.polytech.covid.repository;
import java.util.List;

import org.polytech.covid.structureBDD.AdminVaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminVaccinationRepository extends JpaRepository<AdminVaccination, Integer> {
   List<AdminVaccination> findByNomIgnoreCaseContaining(String sequence);
}

