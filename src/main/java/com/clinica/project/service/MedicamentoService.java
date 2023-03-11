package com.clinica.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clinica.project.entity.Medicamento;
import com.clinica.project.repository.MedicamentoRepository;

@Service
public class MedicamentoService {
	
	@Autowired
	private MedicamentoRepository repo;
	
	//graba o actualiza
	public void grabar(Medicamento bean) {
		repo.save(bean);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	public Medicamento buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<Medicamento> listarTodos(){
		return repo.findAll();
	}
	public void actualizarIMG(byte[] img,String nomAr,Integer cod) {
		repo.actualizarFoto(img, nomAr, cod);
	}
	
}
