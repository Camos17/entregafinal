package com.entregafinalspring.entregafinal.repository;

import com.entregafinalspring.entregafinal.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
