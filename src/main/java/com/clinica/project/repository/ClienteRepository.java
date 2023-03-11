package com.clinica.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinica.project.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Query("select c from Cliente c where c.paterno like ?1")
	public List<Cliente> listAllAtCliente(String ape);

}
