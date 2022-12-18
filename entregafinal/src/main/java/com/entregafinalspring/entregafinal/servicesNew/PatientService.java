package com.entregafinalspring.entregafinal.servicesNew;

import com.entregafinalspring.entregafinal.entity.Dentist;
import com.entregafinalspring.entregafinal.entity.Patient;

import java.sql.SQLException;
import java.util.List;

public interface PatientService {

    Patient savePatient(Patient patient) throws SQLException;

    Patient searchPatient(Integer id) throws SQLException;

    List<Patient> searchAllPatients();

    Patient updatePatient(Patient patient);

    void deletePatient(Integer id);

}
