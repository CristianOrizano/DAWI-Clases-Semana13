package com.clinica.project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.clinica.project.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{
       
	@Transactional
	@Modifying
	@Query ("update Medicamento m set m.foto=?1,m.nombreArchivo=?2 where m.codigo=?3")
	public void actualizarFoto(byte[] img,String nomAr,Integer cod);
}
