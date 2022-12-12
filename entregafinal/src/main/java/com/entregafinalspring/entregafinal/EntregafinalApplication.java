package com.entregafinalspring.entregafinal;

import com.entregafinalspring.entregafinal.models.Dentist;
import com.entregafinalspring.entregafinal.services.DentistServiceOld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class EntregafinalApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(EntregafinalApplication.class, args);

//       Dentist dentist = new Dentist( "Carlos", "Bejarano", "5648789");
        Dentist dentist = new Dentist(1, "Andres", "Coral", "65498712");
		//		Dentist dentist = new Dentist(2,"Juan", "Alvarez", "456789132");

		DentistServiceOld dentistServiceOld = new DentistServiceOld();
		dentistServiceOld.saveDentist(dentist);

	}

}
