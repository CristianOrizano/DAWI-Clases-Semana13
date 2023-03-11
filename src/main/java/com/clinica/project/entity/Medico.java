package com.clinica.project.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_medico")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_med")
	private Integer codigome;
	
	@Column(name="nom_med")
	private String nombreme;
	
	@Column(name="pat_med")
	private String patmedico;
	
	@Column(name="mat_med")
	private String matmedico;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fec_nac_med")
	private Date fecha;
	
	@Column(name="est_civil_med")
	private String estado;
	
	@Column(name="num_hijos_med")
	private int numhijos;
	
	@ManyToOne
	@JoinColumn(name="cod_esp_med")
	private Especialidad Espec;//ASOC.
	
	

	public Especialidad getEspec() {
		return Espec;
	}

	public void setEspec(Especialidad espec) {
		Espec = espec;
	}

	public Integer getCodigome() {
		return codigome;
	}

	public void setCodigome(Integer codigome) {
		this.codigome = codigome;
	}

	public String getNombreme() {
		return nombreme;
	}

	public void setNombreme(String nombreme) {
		this.nombreme = nombreme;
	}

	public String getPatmedico() {
		return patmedico;
	}

	public void setPatmedico(String patmedico) {
		this.patmedico = patmedico;
	}

	public String getMatmedico() {
		return matmedico;
	}

	public void setMatmedico(String matmedico) {
		this.matmedico = matmedico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumhijos() {
		return numhijos;
	}

	public void setNumhijos(int numhijos) {
		this.numhijos = numhijos;
	}

	
	
	
	//
	
	
	

	
	
	
	
	
}
