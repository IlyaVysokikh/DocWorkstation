package org.example.docworkstation.patient.repositories;

import org.example.docworkstation.patient.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT COUNT(p) > 0 FROM Patient p WHERE p.snils = :snils")
    boolean existsBySnils(@Param("snils") String snils);
}
