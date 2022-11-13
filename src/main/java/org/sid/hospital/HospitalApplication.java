package org.sid.hospital;

import org.apache.tomcat.Jar;
import org.sid.hospital.entities.*;
import org.sid.hospital.repositories.ConsultationRepository;
import org.sid.hospital.repositories.MedecinRepository;
import org.sid.hospital.repositories.PatientRepository;
import org.sid.hospital.repositories.RendezVousRepository;
import org.sid.hospital.service.IhospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean

	 /*  J'ai pas besoin d'utiliser ce traitement là, Car on Ajouter la couche Service (l'interface IhospitalService) pour que l'application va etre fermer a le modification
	 et ouvert a l'extentien)
	  CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository,
							ConsultationRepository consultationRepository) { */

		CommandLineRunner start(IhospitalService hospitalService, PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository,
								RendezVousRepository rendezVousRepository)
		/*PatientRepository patientRepository, MedecinRepository medecinRepository, ConsultationRepository consultationRepository,
										RendezVousRepository rendezVousRepository, j'ai ajouté ça,Car j'ai pas ajouter les méthodes findById
		findByNom dans l'interface Ihospital au contraire de la méthode save*/

		{
		return args -> {
			Stream.of("Hicham", "Hamza", "Khadija")
					.forEach(name -> {
						Patient patient = new Patient();
						patient.setNom("Hamza");      //modifier le nom de patient , On lui donnat le nom Hamza
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						//patientRepository.save(patient); Au lieu de ça, Nous allons utilisé:
						hospitalService.savePatient(patient);

					});
			Stream.of("Nabil", "Houssam", "Dounia")
					.forEach(name -> {
						Medecin medecin = new Medecin();
						medecin.setNom("Houssam");      //modifier le nom de medecin , On lui donnat le nom Houssam
						medecin.setEmail(name + "@gmail.com");
						medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
						//medecinRepository.save(medecin); Au lieu de ça, Nous allons utilisé:
						hospitalService.saveMedecin(medecin);
					});
			//Chercher les patients par Nom and id
			Patient patient = patientRepository.findById(1L).orElse((null));
			Patient patient1 = patientRepository.findByNom("Hicham");
			//Chercher les medecins par Nom
			Medecin medecin = medecinRepository.findByNom("Nabil");


			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			RendezVous saveDRDV= hospitalService.saveRDV(rendezVous);
			System.out.println(saveDRDV.getId());

			RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);

			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation ....");
			hospitalService.saveConsultation(consultation);


		};
	}
}

