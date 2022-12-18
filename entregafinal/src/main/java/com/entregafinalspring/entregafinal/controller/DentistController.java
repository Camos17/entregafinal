package com.entregafinalspring.entregafinal.controller;

import com.entregafinalspring.entregafinal.entity.Dentist;
import com.entregafinalspring.entregafinal.servicesNew.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/dentist") // Base URL
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    // POST MAPPING
    //@RequestMapping(value = "/crear", method = RequestMethod.POST) // Esto seria sin usar Spring
    @PostMapping() // Es una abreviacion de Spring
    public Dentist createDentistHandler(@RequestBody Dentist dentist) throws SQLException {
        return dentistService.createDentist(dentist);
    }

    // GET MAPPING
    @GetMapping("/{id}")
    public Dentist searchDentist(@PathVariable int id) {
        return dentistService.searchDentist(id);
    }

    // GET ALL
    @GetMapping("/list")
    public List<Dentist> searchAllDentist() {
        return dentistService.searchAllDentist();
    }

    // PUT MAPPING
    @PutMapping()
    public Dentist updateDentist(@RequestBody Dentist dentist) {
        return dentistService.updateDentist(dentist);
    }

    // DELETE MAPPING
    @DeleteMapping("/{id}")
    public void deleteDentist(@PathVariable int id) {
        dentistService.deleteDentist(id);
    }

}
