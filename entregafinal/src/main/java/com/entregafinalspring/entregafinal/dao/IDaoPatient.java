package com.entregafinalspring.entregafinal.dao;

import com.entregafinalspring.entregafinal.models.Patient;

import java.sql.SQLException;
import java.util.List;

public interface IDaoPatient {

    void savePatient(Patient patient);

    Patient searchPatient(Integer id) throws SQLException;

    List<Patient> searchAllPatients();

    Patient updatePatient(Patient patient);

    void deletePatient(Integer id);

}
