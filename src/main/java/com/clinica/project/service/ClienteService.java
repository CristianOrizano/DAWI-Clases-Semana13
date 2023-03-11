package com.clinica.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.project.entity.Cliente;
import com.clinica.project.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	
	public List<Cliente> listarClientesXApellido(String ape){
		return repo.listAllAtCliente(ape);
	}

}
