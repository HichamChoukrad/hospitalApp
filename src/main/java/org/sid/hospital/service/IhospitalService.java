package org.sid.hospital.service;

import org.sid.hospital.entities.Consultation;
import org.sid.hospital.entities.Medecin;
import org.sid.hospital.entities.Patient;
import org.sid.hospital.entities.RendezVous;

public interface IhospitalService {

     Patient savePatient(Patient patient);

     Medecin saveMedecin(Medecin medecin);
     RendezVous saveRDV(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);



}
