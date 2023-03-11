package com.clinica.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinica.project.entity.Laboratorio;
import com.clinica.project.entity.TipoMedicamento;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Integer> {
	
	//hql==>manejo de select
		//?1==>parametro. ordinal
		//:nom==>para. nombrado
	//tp alias de tipo medicamento
		@Query("select tp from TipoMedicamento tp where tp.labo.codigo=?1")
		public List<TipoMedicamento> findAllByLaboratorio(int codLab);

}
