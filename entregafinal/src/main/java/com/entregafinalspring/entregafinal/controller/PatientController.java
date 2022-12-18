package com.entregafinalspring.entregafinal.controller;

import com.entregafinalspring.entregafinal.entity.Patient;
import com.entregafinalspring.entregafinal.servicesNew.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/patient") // Base URL
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // POST MAPPING
    @PostMapping()
    public Patient savePatientHandler(@RequestBody Patient patient) throws SQLException {
        return patientService.savePatient(patient);
    }

    // GET MAPPING
    @GetMapping()
    public Patient searchPatientHandler(@RequestParam Integer id) throws SQLException {

        return patientService.searchPatient(id);
    }

    // GET ALL
    @GetMapping("/list")
    public List<Patient> searchAllPatientsHandler() {
        return patientService.searchAllPatients();
    }

    // PUT MAPPING
    @PutMapping()
    public Patient updatePatientHandler(@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    // DELETE MAPPING
    @DeleteMapping("/{id}")
    public void deletePatientHandler(@PathVariable Integer id) {
        patientService.deletePatient(id);
    }



}
