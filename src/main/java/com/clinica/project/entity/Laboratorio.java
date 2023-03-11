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
@Table(name = "tb_laboratorio")
public class Laboratorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lab")
	private Integer codigo;
	
	@Column(name = "nom_lab")
	private String nombre;
	
	@Column(name = "dir_lab")
	private String dir;
	//---relacion uno a muchos
	//esto no es mapeo es para la relacion en tablas
	//(en todo onetomany le decimos que no se genere jason de esta lista)
	@JsonIgnore
	@OneToMany(mappedBy = "labo")//ASOC nombre tipo
	private List<TipoMedicamento> listaTipoMedi;
	
	//metodos de accseso
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
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public List<TipoMedicamento> getListaTipoMedi() {
		return listaTipoMedi;
	}
	public void setListaTipoMedi(List<TipoMedicamento> listaTipoMedi) {
		this.listaTipoMedi = listaTipoMedi;
	}
	

}
