package com.clinica.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinica.project.entity.Especialidad;
import com.clinica.project.entity.Medico;
import com.clinica.project.entity.Sede;

public interface SedeRepository extends JpaRepository<Sede, Integer> {
	
	@Query("select espe from Especialidad espe where espe.sede.codigo=?1")
	public List<Especialidad> findAllEspecialidadBySede(int codSede);
}
