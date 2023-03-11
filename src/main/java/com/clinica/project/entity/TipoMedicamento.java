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
@Table(name = "tb_tipo_medicamento")
public class TipoMedicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tipo")
	private Integer codigo;
	
	@Column(name = "nom_tipo")
	private String nombre;
	
	//colocamos esto de forma especial 
	//solo por forma parte de combo dependiente
	//ademas no quiero que devuelva esa lista
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cod_lab")
	private Laboratorio labo;
	
	//---relacion uno a muchos
	//esto no es mapeo es para la relacion en tablas
	//(en todo onetomany le decimos que no se genere jason de esta lista)
	@JsonIgnore
	@OneToMany(mappedBy = "tipo")//ASOC nombre tipo
	private List<Medicamento> listaMedicamentos;

	
	

	public List<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}

	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
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


	public Laboratorio getLabo() {
		return labo;
	}

	public void setLabo(Laboratorio labo) {
		this.labo = labo;
	}
	
	
	
	
}
