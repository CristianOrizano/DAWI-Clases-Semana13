package com.clinica.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clinica.project.entity.TipoMedicamento;
import com.clinica.project.repository.TipoMedicamentoRepository;

@Service
public class TipoMedicamentoService {
	
	@Autowired
	private TipoMedicamentoRepository repo;
	
	public void grabar(TipoMedicamento bean) {
		repo.save(bean);
	}
	public void eliminar(Integer cod) {
		repo.deleteById(cod);
	}
	public TipoMedicamento buscar(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	public List<TipoMedicamento> listarTodos(){
		return repo.findAll();
	}
	
	
}
