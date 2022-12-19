package com.entregafinalspring.entregafinal.services.impl;

import com.entregafinalspring.entregafinal.dto.DentistDTO;
import com.entregafinalspring.entregafinal.entity.Dentist;
import com.entregafinalspring.entregafinal.repository.DentistRepository;
import com.entregafinalspring.entregafinal.services.DentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {
    final static Logger logger = Logger.getLogger(DentistServiceImpl.class);

    private final DentistRepository dentistRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public DentistDTO createDentist(Dentist dentist) {
        dentistRepository.save(dentist);
        DentistDTO dentistDTO = objectMapper.convertValue(dentist, DentistDTO.class);
        return dentistDTO;
    }

    @Override
    public Optional<DentistDTO> searchDentist(int id) {
        logger.debug("buscando el odontologo con id= " + id);
        Optional<DentistDTO> dentistDTO = Optional.of(objectMapper.convertValue(dentistRepository.findById(id).get(), DentistDTO.class));
        return dentistDTO;
    }

    @Override
    public List<Optional<DentistDTO>> searchAllDentist() {
        List<Dentist> dentistsList = dentistRepository.findAll();
        Optional<DentistDTO> dentistDTO = null;
        List<Optional<DentistDTO>> dentistDTOList = new ArrayList<>();

        for (Dentist dentist : dentistsList) {
            dentistDTO = Optional.of(objectMapper.convertValue(dentist, DentistDTO.class));
            dentistDTOList.add(dentistDTO);
        }
        return dentistDTOList;
    }

    @Override
    public Optional<DentistDTO> updateDentist(Dentist dentist) {
        return Optional.empty();
    }

    @Override
    public void deleteDentist(Integer id) {
        logger.debug("Odontologo con id " + id  + " fue elimindao");
        dentistRepository.deleteById(id);
    }


}
