package com.clinica.project;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.clinica.project.entity.Medicamento;
import com.clinica.project.service.MedicamentoService;


@SpringBootTest
class SpringClinicaApplicationTests3 {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String a= encoder.encode("cristian");
		System.out.println("Encrip===="+a);
		
		
	}

}
