package org.sid.hospital.service;

import org.sid.hospital.entities.Consultation;
import org.sid.hospital.entities.Medecin;
import org.sid.hospital.entities.Patient;
import org.sid.hospital.entities.RendezVous;
import org.sid.hospital.repositories.ConsultationRepository;
import org.sid.hospital.repositories.MedecinRepository;
import org.sid.hospital.repositories.PatientRepository;
import org.sid.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service  // les objets de la couche métier utilisent l'annotation Service
@Transactional //Toutes les méthodes sont Transactional


public class HospitalServiceImpl implements IhospitalService {
      //Nous Allons déclarer les interfaces

      /* @Autowired, C'est de faire @Autowired Pour chaque interface afin de faire l'injection, Ou bien
      Je peux ajouter un constructeur qui reçoit tous ses paramètres */
       private PatientRepository patientRepository;

       private MedecinRepository medecinRepository;

       private RendezVousRepository rendezVousRepository;

       private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }





    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
