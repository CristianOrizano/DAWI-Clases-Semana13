package com.clinica.project.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clinica.project.entity.Especialidad;
import com.clinica.project.entity.Medicamento;
import com.clinica.project.entity.Medico;
import com.clinica.project.entity.Sede;
import com.clinica.project.entity.TipoMedicamento;
import com.clinica.project.service.EspecialidadService;

import com.clinica.project.service.MedicoService;
import com.clinica.project.service.SedeService;

@Controller
@RequestMapping("/medico")
public class MedicoController {
	
	@Autowired
	private MedicoService mediSer;
	@Autowired
	private EspecialidadService espeSer;
	@Autowired
	private SedeService sedeSer;
	
	
	@RequestMapping("/lis")
	public String inicio(Model model) {
		
		List<Medico> listMedic= mediSer.listarTodosmed();
		
		//List<Especialidad> listEsp = espeSer.listarTodos();
		List<Sede> listSede = sedeSer.listarTodosSede();
		
		model.addAttribute("listmedi",listMedic);		
		model.addAttribute("listarsedes",listSede);		
		//model.addAttribute("listespe",listEsp);
		
		
		return "medico";
	}
	
	@RequestMapping("/grabar")
	public String grabar(Model model,@RequestParam("codigo") int cod,
						 @RequestParam("nombre") String nom,@RequestParam("paterno") String pater,
					     @RequestParam("materno")String mater,@RequestParam("estado") String estado,
					     @RequestParam("fecha")String fec,@RequestParam("hijos") int hijos,
					     @RequestParam("tipo") int codTip,
					     RedirectAttributes redirect) {
		try {
			//crear objeto
			Medico m=new Medico();
			//setear
			m.setCodigome(cod);
			m.setNombreme(nom);
			m.setPatmedico(pater);
			m.setMatmedico(mater);
			m.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fec));
			m.setEstado(estado);
			m.setNumhijos(hijos);
			//crear objeto
			Especialidad esp=new Especialidad();
			esp.setCodigo(codTip);
			//enviar objeto "tip" dentro del objeto "m"
			m.setEspec(esp);
			//invocar al método grabar
			mediSer.grabar(m);
			
			if(cod==0) {
				//crear atributo
				//este atributo solo va a servir cuando este redireccionando a una ruta "redirect:/medicamento/lis"
				//porq luego desaparece cuando lo lee en la pagina
				redirect.addFlashAttribute("MENSAJE","Registro exitoso");
			}else {
				//crear atributo
				//este atributo solo va a servir cuando este redireccionando a una ruta "redirect:/medicamento/lis"
				//porq luego desaparece cuando lo lee en la pagina
				redirect.addFlashAttribute("MENSAJE","Actualizado exitoso");
			}
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","error exitoso");
			System.out.println("error al grabar: "+e.getMessage());
		}
		//cuando grabe invoque al controlador y su metodo listar
		return "redirect:/medico/lis";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Medico buscar(@RequestParam("codigo") int cod) {
		Medico m= mediSer.buscar(cod);
		System.out.println(m.getNombreme()+m.getFecha());
		return m;
	}
	
	
	//metodo eliminar
		@RequestMapping("/eliminar")
		public String Eliminar(@RequestParam("codigo") int cod,RedirectAttributes redirect) {	
			try {
				mediSer.eliminar(cod);
				redirect.addFlashAttribute("MENSAJE","Eliminado exitoso");
				
			} catch (Exception e) {
				redirect.addFlashAttribute("MENSAJE","error eliminar");
				System.out.println("error al eliiminar"+e.getMessage());
			}	
			return "redirect:/medico/lis";
		}
		
		@RequestMapping("/buscarPorsede")
		@ResponseBody
		public List<Especialidad>buscarPorsede(@RequestParam("codigo") int cod) {
			
			List<Especialidad> data=sedeSer.listEspPorsede(cod);
			return data;
		}
		


}
