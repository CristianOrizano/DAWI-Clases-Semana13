package com.clinica.project.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_sede")
public class Sede {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_sed")
	private Integer codigo;
	
	@Column(name="nom_sed")
	private String nombresede;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sede")//ASOC nombre tipo
	private List<Especialidad> listaEspe;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombresede() {
		return nombresede;
	}

	public void setNombresede(String nombresede) {
		this.nombresede = nombresede;
	}

	public List<Especialidad> getListaEspe() {
		return listaEspe;
	}

	public void setListaEspe(List<Especialidad> listaEspe) {
		this.listaEspe = listaEspe;
	}




	
}
