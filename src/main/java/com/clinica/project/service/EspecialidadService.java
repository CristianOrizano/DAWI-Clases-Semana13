package com.clinica.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.project.entity.Especialidad;

import com.clinica.project.repository.EspecialidadRepository;

@Service
public class EspecialidadService {
	@Autowired
	private EspecialidadRepository repo;
	
	//para listar
	public List<Especialidad> listarTodos(){
		return repo.findAll();
	}

}
