package com.entregafinalspring.entregafinal.controller;

import com.entregafinalspring.entregafinal.dto.DentistDTO;
import com.entregafinalspring.entregafinal.entity.Dentist;
import com.entregafinalspring.entregafinal.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
    @PostMapping("/new") // Es una abreviacion de Spring
    public ResponseEntity<DentistDTO> createDentistHandler(@RequestBody Dentist dentist) throws SQLException {
        DentistDTO dentistDTO = dentistService.createDentist(dentist).orElse(null);
        return ResponseEntity.ok(dentistDTO);
    }

    // GET MAPPING
//    @GetMapping("/{id}}") Usando @PathVariable
    @GetMapping("/search")
    public ResponseEntity<DentistDTO> searchDentistHandler(@RequestParam int id) {
        // .orElse de libreria Optional
        DentistDTO dentistDTO = dentistService.searchDentist(id).orElse(null);
        return ResponseEntity.ok(dentistDTO);
    }

    // GET ALL
    @GetMapping("/list")
    public ResponseEntity<List<Optional<DentistDTO>>> searchAllDentistHandler() {
        List<Optional<DentistDTO>> dentistDTOList = dentistService.searchAllDentist();
        return ResponseEntity.ok(dentistDTOList);
    }

    // PUT MAPPING
    @PutMapping()
    public ResponseEntity<DentistDTO> updateDentistHandler(@RequestBody Dentist dentist) {
        DentistDTO dentistDTO = dentistService.updateDentist(dentist).orElse(null);
        return ResponseEntity.ok(dentistDTO);
    }

    // DELETE MAPPING
    @DeleteMapping("/{id}")
    public void deleteDentistHandler(@PathVariable int id) {
        dentistService.deleteDentist(id);
    }

}
