package com.entregafinalspring.entregafinal.services.impl;

import com.entregafinalspring.entregafinal.dto.DentistDTO;
import com.entregafinalspring.entregafinal.dto.PatientDTO;
import com.entregafinalspring.entregafinal.entity.Dentist;
import com.entregafinalspring.entregafinal.entity.Patient;
import com.entregafinalspring.entregafinal.repository.PatientRepository;
import com.entregafinalspring.entregafinal.services.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    final static Logger logger = Logger.getLogger(PatientServiceImpl.class);

    private final PatientRepository patientRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public Optional<PatientDTO> savePatient(Patient patient) throws SQLException {
        patientRepository.save(patient);
        Optional<PatientDTO> patientDTO = Optional.of(objectMapper.convertValue(patient, PatientDTO.class));
        return patientDTO;
    }

    @Override
    public Optional<PatientDTO> searchPatient(Integer id) throws SQLException {
        Optional<PatientDTO> patientDTO = Optional.of(objectMapper.convertValue(patientRepository.findById(id).get(), PatientDTO.class));
        return patientDTO;
    }

    @Override
    public List<Optional<PatientDTO>> searchAllPatients() {
        List<Patient> patientsList = patientRepository.findAll();
        Optional<PatientDTO> patientDTO = null;
        List<Optional<PatientDTO>> patientsDTOList = new ArrayList<>();

        for (Patient patient : patientsList) {
            patientDTO = Optional.of(objectMapper.convertValue(patient, PatientDTO.class));
            patientsDTOList.add(patientDTO);
        }
        return patientsDTOList;
    }

    @Override
    public Optional<PatientDTO> updatePatient(Patient patient) {
        return Optional.empty();
    }

    @Override
    public void deletePatient(Integer id) {
        logger.debug("Paciente con id " + id  + " fue elimindao");
        patientRepository.deleteById(id);
    }
}
