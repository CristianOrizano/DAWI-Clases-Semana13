package com.clinica.project.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_especialidad")
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_esp")
	private Integer codigo;
	
	@Column(name="nom_des")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="cod_sede")
	private Sede sede;//ASOC.
	
	
	public Sede getSede() {
		return sede;
	}


	public void setSede(Sede sede) {
		this.sede = sede;
	}


	@JsonIgnore
	@OneToMany(mappedBy = "Espec")//ASOC nombre tipo
	private List<Medico> listaMedi;



	public List<Medico> getListaMedi() {
		return listaMedi;
	}


	public void setListaMedi(List<Medico> listaMedi) {
		this.listaMedi = listaMedi;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	
	
	
	
}
