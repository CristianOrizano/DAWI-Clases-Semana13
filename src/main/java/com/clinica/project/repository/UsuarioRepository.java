package com.clinica.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinica.project.entity.Enlace;
import com.clinica.project.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	//select * from tb_usuario where login='ana' and password='ana'
	
	//select * from tb_usuario where login='ana'
	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String vlogin);
	
	
	//select e.idenlace,e.descripcion,e.ruta from tb_enlace e
	//join tb_rol_enlace re on re.idenlace=e.idenlace where re.idrol=2
	//prueba
	//@Query("select e from Enlace e join RolEnlace re where re.rol.codrol=?1")
	@Query("select e from RolEnlace re join re.enlace e  where re.rol.codrol=?1")
	public List<Enlace> TraerEnlaceUsuario(int codRol);
	
	

}
