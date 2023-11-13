package org.polytech.covid.repository;
import java.util.List;

import org.polytech.covid.structureBDD.MedecinVaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinVaccinationRepository extends JpaRepository<MedecinVaccination, Integer> {
   List<MedecinVaccination> findByNomIgnoreCaseContaining(String sequence);
}

