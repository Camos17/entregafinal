package com.entregafinalspring.entregafinal.dao;

import com.entregafinalspring.entregafinal.entity.Dentist;

import java.sql.SQLException;
import java.util.List;

public interface IDaoDentist {

    void saveDentist(Dentist dentist) throws SQLException;

    Dentist searchDentist(int id);

    List<Dentist> searchAllDentist();

    Dentist updateDentist(Dentist dentist);

    void deleteDentist(Integer id);

}
