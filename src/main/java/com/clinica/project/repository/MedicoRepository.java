package com.clinica.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.clinica.project.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
