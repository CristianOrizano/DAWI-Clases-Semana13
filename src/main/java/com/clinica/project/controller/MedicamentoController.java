package com.clinica.project.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clinica.project.entity.Laboratorio;
import com.clinica.project.entity.Medicamento;
import com.clinica.project.entity.TipoMedicamento;
import com.clinica.project.service.LaboratorioService;
import com.clinica.project.service.MedicamentoService;
import com.clinica.project.service.TipoMedicamentoService;

@Controller
@RequestMapping("/medicamento")
public class MedicamentoController {
	
	@Autowired
	//est es para todo el crud y consultas
	//esta sentencia es inyectar
	private MedicamentoService servicioMed;
	
	@Autowired
	private LaboratorioService servicioLab;
	
	
	@RequestMapping("/lis")
	public String inicio(Model model) {
		//recuperar la lista de Medicamentos
		List<Medicamento> data=servicioMed.listarTodos();
		//recuperar lista de laboratorios
		List<Laboratorio> dataLabo = servicioLab.listarTodosLab();
		
		//recuperar lista de tipos de medicamentos
		//List<TipoMedicamento> dataTipo=servicioTipo.listarTodos();
		//crear atributo
		  //enviar atributo
		model.addAttribute("lista",data);
		//model.addAttribute("tipos",dataTipo);
		
		model.addAttribute("labora",dataLabo);

		
		return "medicamento";
	}
	
	@RequestMapping("/grabar")
	public String grabar(Model model,@RequestParam("codigo") int cod,
						 @RequestParam("nombre") String nom,@RequestParam("descripcion") String des,
					     @RequestParam("stock")int sto,@RequestParam("precio") double pre,
					     @RequestParam("fecha")String fec,@RequestParam("tipo") int codTipo,
					     RedirectAttributes redirect) {
		try {
			//crear objeto
			Medicamento m=new Medicamento();
			//setear
			m.setCodigo(cod);
			m.setNombre(nom);
			m.setDescripcion(des);
			m.setStock(sto);
			m.setPrecio(pre);
			m.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fec));
			//crear objeto
			TipoMedicamento tip=new TipoMedicamento();
			tip.setCodigo(codTipo);
			//enviar objeto "tip" dentro del objeto "m"
			m.setTipo(tip);
			//invocar al método grabar
			servicioMed.grabar(m);
			
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
		return "redirect:/medicamento/lis";
	}
	
	@RequestMapping("/buscar")
	//al poner esto el valor de retorno del metodo se convierte en json
	@ResponseBody
	//convertir ese medicamento que retorna aun json
	public Medicamento buscar(@RequestParam("codigo") int cod) {
		Medicamento m= servicioMed.buscar(cod); 
		System.out.println(m.getDescripcion()+"---------------------------");
		return m;
	}
	
	//metodo eliminar
	@RequestMapping("/eliminar")
	public String Eliminar(@RequestParam("codigo") int cod,RedirectAttributes redirect) {	
		try {
			servicioMed.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE","Eliminado exitoso");
			
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","error eliminar");
			System.out.println("error al eliiminar"+e.getMessage());
		}	
		return "redirect:/medicamento/lis";
	}
	
	
	//-----------
	@RequestMapping("/buscarPorLaboratorio")
	@ResponseBody
	public List<TipoMedicamento> buscarPorLaboratorio(@RequestParam("codigo") int cod) {
		
		List<TipoMedicamento> data=servicioLab.listTiposAtLaboratorio(cod);
		return data;
	}
	
	
	@RequestMapping("/subir-archivo") 
	//recuperamos la caja data y almcaceno en archivo
     public String subirArchivo(@RequestParam("data")MultipartFile archivo,
    		 @RequestParam("codigo") Integer cod,
 			RedirectAttributes redirect) throws IOException {
		
		//guardo el nombre de la imagen en una varible
		String nomArchivo =archivo.getOriginalFilename();
		
		//necesito los archivos de la img pero en byte(ya que las imagnes tienes byte)
		byte[] bytes=archivo.getBytes();
		//
		String ruta="C://ZClinica//DatosImg//";
		//generar archivo(lo que hace es guardar la foto en la ruta indicada)
		Files.write(Paths.get(ruta+nomArchivo), bytes);	
		servicioMed.actualizarIMG(bytes, nomArchivo, cod);
		redirect.addFlashAttribute("MENSAJE","Foto actualizada");
		return "redirect:/medicamento/lis";
	}
	
}












