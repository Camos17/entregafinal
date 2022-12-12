package com.entregafinalspring.entregafinal.controller;

import com.entregafinalspring.entregafinal.models.Dentist;
import com.entregafinalspring.entregafinal.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping
    public Dentist getDentistHandler() {
        return dentistService.getDentist();
    }

}
