package com.entregafinalspring.entregafinal.services;

import com.entregafinalspring.entregafinal.dao.IDaoDentist;
import com.entregafinalspring.entregafinal.dao.impl.DentistDaoImplH2;
import com.entregafinalspring.entregafinal.models.Dentist;

import java.sql.SQLException;

public class DentistService {

    private final IDaoDentist iDaoDentist;

    public DentistService() {
        this.iDaoDentist = new DentistDaoImplH2();
    }

    public void saveDentist(Dentist dentist) throws SQLException {
        iDaoDentist.saveDentist(dentist);
    }

}
