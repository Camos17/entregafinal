package com.entregafinalspring.entregafinal;

import com.entregafinalspring.entregafinal.models.Dentist;
import com.entregafinalspring.entregafinal.services.DentistService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class EntregafinalApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(EntregafinalApplication.class, args);

		DentistService dentistService = new DentistService();

		//// ODONTOLOGO
		// GUARDAR UN ODONTOLOGO
//       Dentist dentist = new Dentist( "Carlos", "Bejarano", "5648789");
//		        Dentist dentist = new Dentist(1, "Andres", "Coral", "65498712");
//				Dentist dentist2 = new Dentist(2,"Juan", "Alvarez", "456789132");
//				Dentist dentist3 = new Dentist(3, "Alberto", "Barranca", "235698741");
		Dentist dentist4 = new Dentist(4, "Juliana", "Vanegas", "56478921");


//		dentistService.saveDentist(dentist);
//		dentistService.saveDentist(dentist2);
		dentistService.saveDentist(dentist4);

		// BUCAR UN ODONTOLOGO
//		System.out.println(dentistService.searchDentist(0));

		// BUSCAR TODOS LOS ODONTOLOGOS
		//System.out.println(dentistService.searchAllDentists());

		// ACTUALIZAR UN ODONTOLOG
//		Dentist updateDentist = new Dentist(0, "Carlos", "Bejarano", "123456789");
//		dentistService.updateDentist(updateDentist);

		// BORRAR UN DENTISTA
//		dentistService.deleteDentist(0);


	}

}
