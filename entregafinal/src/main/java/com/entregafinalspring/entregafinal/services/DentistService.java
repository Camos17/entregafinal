package com.entregafinalspring.entregafinal.services;

import com.entregafinalspring.entregafinal.dto.DentistDTO;
import com.entregafinalspring.entregafinal.entity.Dentist;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DentistService {

    Dentist createDentist(Dentist dentist) throws SQLException;

    Optional<DentistDTO> searchDentist(int id);

    List<Dentist> searchAllDentist();

    Dentist updateDentist(Dentist dentist);

    void deleteDentist(Integer id);

}
