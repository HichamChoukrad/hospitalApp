package org.sid.hospital.repositories;

import org.sid.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    //Chercher les patients par leurs noms
    Patient findByNom(String name);


}
