package com.entregafinalspring.entregafinal.services;

import com.entregafinalspring.entregafinal.dao.IDaoPatient;
import com.entregafinalspring.entregafinal.dao.impl.PatientDaoImplH2;
import com.entregafinalspring.entregafinal.entity.Patient;

import java.sql.SQLException;
import java.util.List;

public class PatientService {

    private final IDaoPatient iDaoPatient;

    public PatientService() {
        this.iDaoPatient = new PatientDaoImplH2();
    }

    public void savePatient(Patient patient) {
        iDaoPatient.savePatient(patient);
    }

    public Patient searchPatient(Integer id) throws SQLException {
        return iDaoPatient.searchPatient(id);
    }

    public List<Patient> searchAllPatients() {
        return iDaoPatient.searchAllPatients();
    }

    public Patient updatePatient(Patient patient) {
        return iDaoPatient.updatePatient(patient);
    }

    public void deletePatient (int id) {
        iDaoPatient.deletePatient(id);
    }
}
