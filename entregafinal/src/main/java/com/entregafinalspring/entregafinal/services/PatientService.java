package com.entregafinalspring.entregafinal.services;

import com.entregafinalspring.entregafinal.dto.PatientDTO;
import com.entregafinalspring.entregafinal.entity.Patient;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PatientService {

    Optional<PatientDTO> savePatient(Patient patient) throws SQLException;

    Optional<PatientDTO> searchPatient(Integer id) throws SQLException;

    List<Optional<PatientDTO>> searchAllPatients();

    Optional<PatientDTO> updatePatient(Patient patient);

    void deletePatient(Integer id);

}
