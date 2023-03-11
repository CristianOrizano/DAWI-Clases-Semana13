package com.clinica.project.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.OutputStream;
import com.clinica.project.entity.Medicamento;
import com.clinica.project.service.MedicamentoService;
import com.clinica.project.utils.Libreria;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	
	@Autowired
	//est es para todo el crud y consultas
	//esta sentencia es inyectar
	private MedicamentoService servicioMed;
	

	@RequestMapping("/medicamento")
	public void inicio(HttpServletResponse response) {
		try {
			//obtener todos los medicamentos
			List<Medicamento> data=servicioMed.listarTodos();
			//acceder al reporte "reporte_medicamento"
			File file = ResourceUtils.getFile("classpath:reportes_medicamento.jrxml");
			//origen de datos convertir data a tipo JRBeanCollectionDatasource
			JRBeanCollectionDataSource info= new JRBeanCollectionDataSource(data);
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
	

}
