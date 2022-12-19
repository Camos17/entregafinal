package com.entregafinalspring.entregafinal.repository;

import com.entregafinalspring.entregafinal.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
