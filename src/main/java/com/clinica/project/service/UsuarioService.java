package com.clinica.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.project.entity.Enlace;
import com.clinica.project.entity.Usuario;
import com.clinica.project.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	
	public Usuario loginUsuario(String vLogin) {
		return repo.iniciarSesion(vLogin);
	}
	public List<Enlace> enlacesDelUsuario(int rol){
		return repo.TraerEnlaceUsuario(rol);
	}
	

}
