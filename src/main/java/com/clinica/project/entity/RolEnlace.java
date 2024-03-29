package com.clinica.project.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_rol_enlace")
public class RolEnlace {
    //esto viene delRolEnlacePK
	//creo un obj de una clase que contenga la anotacion @Embeddable
	//si no la tuviera daria error por que se debe colocar
	@EmbeddedId
	private RolEnlacePK pk;
	
	@ManyToOne
	@JoinColumn(name="idrol",insertable = false,updatable =false )
	private Rol rol;

	@ManyToOne
	@JoinColumn(name="idenlace",insertable = false,updatable =false)
	private Enlace enlace;
	
	
	

	public RolEnlacePK getPk() {
		return pk;
	}

	public void setPk(RolEnlacePK pk) {
		this.pk = pk;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Enlace getEnlace() {
		return enlace;
	}

	public void setEnlace(Enlace enlace) {
		this.enlace = enlace;
	}
	
	
	
	
	
}
