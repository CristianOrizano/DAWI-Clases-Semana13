package com.clinica.project;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clinica.project.entity.Medicamento;
import com.clinica.project.service.MedicamentoService;


@SpringBootTest
class SpringClinicaApplicationTests2 {

	@Autowired
	private MedicamentoService servicio;
	
	@Test
	void contextLoads() {
		List<Medicamento> data=servicio.listarTodos();
		for(Medicamento t:data)
			System.out.println(t.getCodigo()+"---"+t.getNombre()+"---"+t.getTipo().getNombre());
		
	}

}
