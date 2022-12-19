package com.entregafinalspring.entregafinal.services;

import com.entregafinalspring.entregafinal.dto.DentistDTO;
import com.entregafinalspring.entregafinal.entity.Dentist;

import java.util.List;
import java.util.Optional;

public interface DentistService {

    DentistDTO createDentist(Dentist dentist);

    Optional<DentistDTO> searchDentist(int id);

    List<Optional<DentistDTO>> searchAllDentist();

    Optional<DentistDTO> updateDentist(Dentist dentist);
//
    void deleteDentist(Integer id);

}
