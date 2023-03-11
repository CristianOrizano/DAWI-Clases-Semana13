package com.clinica.project;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clinica.project.entity.Especialidad;
import com.clinica.project.entity.Medicamento;
import com.clinica.project.entity.Medico;
import com.clinica.project.entity.TipoMedicamento;
import com.clinica.project.service.LaboratorioService;
import com.clinica.project.service.MedicamentoService;
import com.clinica.project.service.MedicoService;
import com.clinica.project.service.SedeService;
import com.clinica.project.service.TipoMedicamentoService;

@SpringBootTest
class SpringClinicaApplicationTests {

	@Autowired
	private MedicamentoService medica;
	@Autowired
	private LaboratorioService servicioLab;
	@Autowired
	private SedeService sedeser;
	
	
	@Test
	void contextLoads() {
		Medicamento data=medica.buscar(2);
		List<Especialidad> ti=sedeser.listEspPorsede(1);
			
			for (Especialidad e : ti) {
				System.out.println(e.getNombre() +"---"+e.getCodigo());
			}
		
		
	}

	

}
