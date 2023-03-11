package com.clinica.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.clinica.project.entity.Enlace;
import com.clinica.project.entity.Usuario;
import com.clinica.project.security.UserService;
import com.clinica.project.service.UsuarioService;

//tengo dos atributos a nivel de session
@SessionAttributes({"ENLACES","CODIGOUSUARIO"})
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService servicio;
        
	@RequestMapping("/login")
	public String login(Model model){
		
		return "login";
	}
	
	@RequestMapping("/intranet")
	public String intranet(Authentication  auth,Model model){
		       //obtener nombre del usuario
				String vLogin=auth.getName(); //nombre usuario que se loguio
				//invoco al metodo login para que me traiga el usuario
				Usuario u=servicio.loginUsuario(vLogin);
		   //una ves me devuelva el usuario segun nombre(saco el codigorol de ese nombre usuario)
				//luego lo mando como parametro para que traiga los enlaces del rol
				List<Enlace> lista=servicio.enlacesDelUsuario(u.getRol().getCodrol());
				//envio la lista de enlaces como atributoSession almacenado en ENLACES(ses)
				model.addAttribute("ENLACES",lista);
				model.addAttribute("CODIGOUSUARIO",u.getCodigo());
		
		return "intranet";
	}
	

	
	
}
