package com.entregafinalspring.entregafinal.services;

import com.entregafinalspring.entregafinal.dao.IDaoDentist;
import com.entregafinalspring.entregafinal.dao.impl.DentistDaoImplH2;
import com.entregafinalspring.entregafinal.entity.Dentist;

import java.sql.SQLException;
import java.util.List;

public class DentistService {

    private final IDaoDentist iDaoDentist;

    public DentistService() {
        this.iDaoDentist = new DentistDaoImplH2();
    }

    public void saveDentist(Dentist dentist) throws SQLException {
        iDaoDentist.saveDentist(dentist);
    }

    public Dentist searchDentist(Integer id) {
       return iDaoDentist.searchDentist(id);
    }

    public List<Dentist> searchAllDentists() {
        return iDaoDentist.searchAllDentist();
    }

    public Dentist updateDentist(Dentist dentist) {
        return iDaoDentist.updateDentist(dentist);
    }

    public void deleteDentist(Integer id) {
        iDaoDentist.deleteDentist(id);
    }

}
