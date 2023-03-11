package com.clinica.project.controller;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clinica.project.entity.Boleta;
import com.clinica.project.entity.Cliente;
import com.clinica.project.entity.Detalle;
import com.clinica.project.entity.Medicamento;
import com.clinica.project.entity.MedicamentoHasBoleta;
import com.clinica.project.entity.Usuario;
import com.clinica.project.service.BoletaService;
import com.clinica.project.service.ClienteService;
import com.clinica.project.service.MedicamentoService;
import com.clinica.project.utils.Libreria;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Controller
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	MedicamentoService servicioMed;
	
	@Autowired
	private ClienteService servicioClie; 
	
	@Autowired
	private BoletaService servicioBol;
	
	@RequestMapping("/boleta")
	public String Boleta(Model model) {
		
		model.addAttribute("medicamentos",servicioMed.listarTodos());
		
		return "boleta";
	}
	
	
	@RequestMapping("/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo") int cod,@RequestParam("nombre") String nom,
							@RequestParam("cantidad") int can,@RequestParam("precio") double pre,HttpSession session) {
		
		//declarar arreglo de objetos de la clase Detalle
		List<Detalle> data=null;
		//validar si existe el atributo de tipo sesión "carrito"
		if(session.getAttribute("carrito")==null)//no existe el atributo
			//crear el arreglo data
			data=new ArrayList<Detalle>();
		else//existe el atributo data "recuperar y guardarlo en data"
			data=(List<Detalle>) session.getAttribute("carrito");
		
		
		//crear objeto de la clase Detalle
		Detalle d=new Detalle();
		//setear
		d.setCodigo(cod);
		d.setNombre(nom);
		d.setCantidad(can);
		d.setPrecio(pre);
		//adicionar objeto "d" dentro del arreglo "data"
		data.add(d);
		
		//crear atributo de tipo sesión "carrito"
		session.setAttribute("carrito", data);
		
		return data;
		
	}
	
	
	@RequestMapping("/reporte")
	public void inicio(HttpServletResponse response,HttpSession session) {
		try {
			
			List<Medicamento> data= servicioMed.listarTodos();
			List<Detalle> m= new ArrayList<Detalle>();
			
			for(Medicamento d:data) {
				Detalle detabol=new Detalle();
				
				detabol.setCodigo(d.getCodigo());
				detabol.setNombre(d.getNombre());
				
				m.add(detabol);
			}
			
			
			
			//acceder al reporte "reporte_medicamento"
			File file = ResourceUtils.getFile("classpath:reportes_medicamento.jrxml");
			//origen de datos convertir data a tipo JRBeanCollectionDatasource
			JRBeanCollectionDataSource info= new JRBeanCollectionDataSource(m);
			//invocar al metodo generar reporte 
			JasperPrint print= Libreria.generarReporte(file, info);
			//salida en el navegador en formato pdf
			response.setContentType("application/pdf");
			//salida del flujo
			OutputStream salida= response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(print, salida);
				
		} catch (Exception e) {
			System.out.println("Error:"+e);
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@RequestMapping("/eliminar")
	@ResponseBody
	public List<Detalle> eliminar(@RequestParam("codigo") int cod,HttpSession session){
		//recuperar atributo "carrito"
		List<Detalle> data=(List<Detalle>) session.getAttribute("carrito");
		//bucle
		for(Detalle d:data){
			if(d.getCodigo()==cod) {
				data.remove(d);
				break;
			}
		}
		
		//crear atributo de tipo sesión "carrito"
		session.setAttribute("carrito", data);
		
	
		return data;
	}
	
	@RequestMapping("/listarClientes")
	@ResponseBody
	public List<Cliente> listarClientes(@RequestParam("paterno") String pat){
             
	  List<Cliente> data=servicioClie.listarClientesXApellido(pat+"%");
		
		return data;
	}
			
	//grabar boleta
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("fecha") String fec,
				@RequestParam("codigoCliente") int codCli,
				@SessionAttribute("CODIGOUSUARIO") int codUsu,
				HttpSession session,RedirectAttributes redirect) {
		
		try {
			
			Boleta bol=new Boleta();
			bol.setFechaEmision(new SimpleDateFormat("yyyy-MM-dd").parse(fec));
			bol.setMonto(1000);
			Cliente c=new Cliente();
			c.setCodigo(codCli);
			Usuario u=new Usuario();
			u.setCodigo(codUsu);
			bol.setCliente(c);
			bol.setUsuario(u);
			//
			List<Detalle> data=(List<Detalle>) session.getAttribute("carrito");
			//
			List<MedicamentoHasBoleta> lista=new ArrayList<MedicamentoHasBoleta>();
			//
			for(Detalle d:data) {
				MedicamentoHasBoleta mhb=new MedicamentoHasBoleta();
				Medicamento m=new Medicamento();
				m.setCodigo(d.getCodigo());
				
				mhb.setMedicamento(m);
				mhb.setPrecio(d.getPrecio());	
				lista.add(mhb);
			}
			//
			bol.setListaMedicamentoHasBoleta(lista);
		
			servicioBol.registrarBoleta(bol);
			data.clear();
			session.setAttribute("carrito", data);
			redirect.addFlashAttribute("MENSAJE","Boleta registrada");
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en el registro");
		}
		return "redirect:/venta/boleta";
	}
	

}
