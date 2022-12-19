package com.entregafinalspring.entregafinal.controller;

import com.entregafinalspring.entregafinal.dto.PatientDTO;
import com.entregafinalspring.entregafinal.entity.Patient;
import com.entregafinalspring.entregafinal.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient") // Base URL
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // POST MAPPING
    @PostMapping("/new")
    public ResponseEntity<PatientDTO> savePatientHandler(@RequestBody Patient patient) throws SQLException {
        PatientDTO patientDTO = patientService.savePatient(patient).orElse(null);
        return ResponseEntity.ok(patientDTO);
    }

    // GET MAPPING
    //    @GetMapping("/{id}}") Usando @PathVariable
    @GetMapping("/search")
    public ResponseEntity<PatientDTO> searchPatientHandler(@RequestParam Integer id) throws SQLException {
        PatientDTO patientDTO = patientService.searchPatient(id).orElse(null);
        return ResponseEntity.ok(patientDTO);
    }

    // GET ALL
    @GetMapping("/list")
    public List<Optional<PatientDTO>> searchAllPatientsHandler() {
        List<Optional<PatientDTO>> patientDTOList = patientService.searchAllPatients();
        return patientDTOList;
    }

    // PUT MAPPING
    @PutMapping()
    public ResponseEntity<PatientDTO> updatePatientHandler(@RequestBody Patient patient) {
        PatientDTO patientDTO = patientService.updatePatient(patient).orElse(null);
        return ResponseEntity.ok(patientDTO);
    }

    // DELETE MAPPING
    @DeleteMapping("/{id}")
    public void deletePatientHandler(@PathVariable Integer id) {
        patientService.deletePatient(id);
    }



}
