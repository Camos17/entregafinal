package com.entregafinalspring.entregafinal;

import com.entregafinalspring.entregafinal.services.DentistService;
import com.entregafinalspring.entregafinal.services.PatientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class EntregafinalApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(EntregafinalApplication.class, args);

//		DentistService dentistService = new DentistService();

		//// ODONTOLOGO
		// GUARDAR UN ODONTOLOGO
//       Dentist dentist = new Dentist( "Carlos", "Bejarano", "5648789");
//		        Dentist dentist = new Dentist(1, "Andres", "Coral", "65498712");
//				Dentist dentist2 = new Dentist(2,"Juan", "Alvarez", "235698741");
//				Dentist dentist3 = new Dentist(3, "Alberto", "Barranca", "456789132");
//		Dentist dentist4 = new Dentist(4, "Juliana", "Vanegas", "56478921");


//		dentistService.saveDentist(dentist);
//		dentistService.saveDentist(dentist2);
//		dentistService.saveDentist(dentist4);

		// BUCAR UN ODONTOLOGO
//		System.out.println(dentistService.searchDentist(0));

		// BUSCAR TODOS LOS ODONTOLOGOS
		//System.out.println(dentistService.searchAllDentists());

		// ACTUALIZAR UN ODONTOLOGO
//		Dentist updateDentist = new Dentist(0, "Carlos", "Bejarano", "123456789");
//		dentistService.updateDentist(updateDentist);

		// BORRAR UN DENTISTA
//		dentistService.deleteDentist(0);



		//// PACIENTE
//		PatientService patientService = new PatientService();
//		Patient patient = new Patient(1, "Manuela", "Ramirez", "calle 345 # 76-12", "3216545987", new Date(2022-12-11));
//		Patient patient1 = new Patient(2, "Alvaro", "Castellanos", "calle 65 # 76D-12", "6547891", new java.sql.Date(2022-11-5));

		// GUARDAR UN PACIENTE
//		patientService.savePatient(patient);
//		patientService.savePatient(patient1);

		// BUSCAR PACIENTE
//		System.out.println(patientService.searchPatient(2));

		// BUSCAR TODOS LOS PACIENTES
//		System.out.println(patientService.searchAllPatients());

		// ACTUALIZAR PACIENTE
//		Patient updatePatient = new Patient(1, "Manuela A", "Ramirez", "calle 345 # 76-12", "3216545987", new Date(2022-12-11));
//		System.out.println(patientService.updatePatient(updatePatient));

		// BORRAR PACIENTE
//		patientService.deletePatient(7);


	}

}
