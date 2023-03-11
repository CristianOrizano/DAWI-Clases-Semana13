package com.clinica.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinica.project.entity.TipoMedicamento;
import com.clinica.project.service.TipoMedicamentoService;

@Controller
@RequestMapping("/tipo")
public class TipoMedicamentoController {
	
	@Autowired 
	private TipoMedicamentoService servicioTipo;
	
	
	@RequestMapping("/")
	public String index(){
		return "tipo";
	}
	
	
	@RequestMapping("/registrar")
	public String registrar(@RequestParam("nombre") String nom) {
		TipoMedicamento bean=new TipoMedicamento();
		bean.setNombre(nom);
		servicioTipo.grabar(bean);
		return "tipo";
	}
	
	
}
