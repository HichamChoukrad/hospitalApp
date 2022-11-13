package org.sid.hospital.repositories;

import org.sid.hospital.entities.Medecin;
import org.sid.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
