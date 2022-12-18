package com.entregafinalspring.entregafinal.controller;

import com.entregafinalspring.entregafinal.dto.DentistDTO;
import com.entregafinalspring.entregafinal.entity.Dentist;
import com.entregafinalspring.entregafinal.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @GetMapping()
    public ResponseEntity<DentistDTO> searchDentistHandler(@RequestParam int id) {
        // .orElse de libreria Optional
        DentistDTO dentistDTO = dentistService.searchDentist(id).orElse(null);
        return ResponseEntity.ok(dentistDTO);
    }

    // GET ALL
    @GetMapping("/list")
    public List<Dentist> searchAllDentistHandler() {
        return dentistService.searchAllDentist();
    }

    // PUT MAPPING
    @PutMapping()
    public Dentist updateDentistHandler(@RequestBody Dentist dentist) {
        return dentistService.updateDentist(dentist);
    }

    // DELETE MAPPING
    @DeleteMapping("/{id}")
    public void deleteDentistHandler(@PathVariable int id) {
        dentistService.deleteDentist(id);
    }

}
