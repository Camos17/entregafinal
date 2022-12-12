package com.entregafinalspring.entregafinal.services;

import com.entregafinalspring.entregafinal.dao.IDaoDentist;
import com.entregafinalspring.entregafinal.dao.impl.IDaoDentistImplH2;
import com.entregafinalspring.entregafinal.models.Dentist;

import java.sql.SQLException;

public class DentistServiceOld {

    private IDaoDentist daoDentist;

    public DentistServiceOld() {
        this.daoDentist = new IDaoDentistImplH2();
    }

    public void saveDentist(Dentist dentist) throws SQLException {
        this.daoDentist.saveDentist(dentist);
    }

}
