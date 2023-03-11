package com.clinica.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.clinica.project.entity.Medico;

import com.clinica.project.repository.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository repo;
	//graba o actualiza
	public void grabar(Medico bean) {
		repo.save(bean);
	}
	//eliminar por codigo
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	
	//metodo buscar para editar
	//pero si el codigo no existe me tiene que
	//devolver entidad nulla entonces por eso va el null
	public Medico buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	//para listar
	public List<Medico> listarTodosmed(){
		return repo.findAll();
	}
	

}
