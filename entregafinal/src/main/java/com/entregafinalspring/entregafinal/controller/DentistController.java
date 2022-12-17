package com.entregafinalspring.entregafinal.controller;

import com.entregafinalspring.entregafinal.entity.Dentist;
import com.entregafinalspring.entregafinal.servicesNew.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/dentist") // Base URL
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    //@RequestMapping(value = "/crear", method = RequestMethod.POST) // Esto seria sin usar Spring
    @PostMapping() // Es una abreviacion de Spring
    public void createDentistHandler(Dentist dentist) throws SQLException {
        dentistService.createDentist(dentist);
    }


}
