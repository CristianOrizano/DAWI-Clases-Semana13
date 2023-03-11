package com.clinica.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.project.entity.Laboratorio;
import com.clinica.project.entity.TipoMedicamento;
import com.clinica.project.repository.LaboratorioRepository;

@Service
public class LaboratorioService {
	
	@Autowired
	private LaboratorioRepository repo;
	
	public List<TipoMedicamento> listTiposAtLaboratorio(int codLab){
		return repo.findAllByLaboratorio(codLab);
	}
	
	public List<Laboratorio> listarTodosLab() {
		return repo.findAll();
	}

	
}
