package com.clinica.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.project.entity.Boleta;
import com.clinica.project.entity.MedicamentoHasBoleta;
import com.clinica.project.entity.MedicamentoHasBoletaPK;
import com.clinica.project.repository.BoletaRepository;
import com.clinica.project.repository.MedicaHasBolReporsitory;

@Service
public class BoletaService {
	
	@Autowired
	private BoletaRepository repoBol;
	
	@Autowired
	private MedicaHasBolReporsitory repoDet;
	
	@Transactional
	public void registrarBoleta(Boleta bean) {
		try {
			//grabar Boleta
			repoBol.save(bean);
			//grabar detalle
			for(MedicamentoHasBoleta mhb:bean.getListaMedicamentoHasBoleta()) {
				MedicamentoHasBoletaPK pk=new MedicamentoHasBoletaPK();
				pk.setNumeroBoleta(bean.getNumeroBoleta());
				//creo que se puede borrar
				pk.setCodigoMedicamento(mhb.getMedicamento().getCodigo());
				mhb.setPk(pk);
				repoDet.save(mhb);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
