package com.clinica.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.project.entity.Especialidad;


public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
    
}
