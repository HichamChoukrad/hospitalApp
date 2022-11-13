package org.sid.hospital.repositories;

import org.sid.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long > {
 Medecin findByNom(String nom);
}
