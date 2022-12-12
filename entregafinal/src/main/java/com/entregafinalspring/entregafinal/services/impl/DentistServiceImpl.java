package com.entregafinalspring.entregafinal.services.impl;

import com.entregafinalspring.entregafinal.models.Dentist;
import com.entregafinalspring.entregafinal.services.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {


    @Override
    public Dentist getDentist() {
        return new Dentist(1, "Andres", "Coral", "65498712");
    }

    @Override
    public List<Dentist> getDentistsList() {
        return null;
    }
}
