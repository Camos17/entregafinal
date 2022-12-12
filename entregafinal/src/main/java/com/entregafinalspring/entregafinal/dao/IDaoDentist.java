package com.entregafinalspring.entregafinal.dao;

import com.entregafinalspring.entregafinal.models.Dentist;

import java.sql.SQLException;

public interface IDaoDentist {

    void saveDentist(Dentist dentist) throws SQLException;

    Dentist getDentist(int id);

}
