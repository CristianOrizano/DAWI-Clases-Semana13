package com.clinica.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.project.entity.Especialidad;
import com.clinica.project.entity.Laboratorio;
import com.clinica.project.entity.Sede;
import com.clinica.project.entity.TipoMedicamento;
import com.clinica.project.repository.LaboratorioRepository;
import com.clinica.project.repository.SedeRepository;

@Service
public class SedeService {

	@Autowired
	private SedeRepository reposede;
	
	public List<Especialidad> listEspPorsede(int sede){
		return reposede.findAllEspecialidadBySede(sede);
	}
	
	public List<Sede> listarTodosSede() {
		return reposede.findAll();
	}

	
	
}
