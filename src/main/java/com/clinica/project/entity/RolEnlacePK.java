package com.clinica.project.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

//cuando tiene esta anotacion es xq esta clase
//va a formar parte de otro(en este caso formara parte de rolEnlace)
//esto se hace por que estos son las llaveprimarias
@Embeddable                //tiene que ser serializada
public class RolEnlacePK implements Serializable {

	private int idrol;
	private int idenlace;
	
	
	public int getIdrol() {
		return idrol;
	}
	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
	public int getIdenlace() {
		return idenlace;
	}
	public void setIdenlace(int idenlace) {
		this.idenlace = idenlace;
	}
	
	//genera un codigo de la combimacion ya que los 2 son PK
	//este indica la union de los 2 para ser el primatyk
	@Override
	public int hashCode() {
		return Objects.hash(idenlace, idrol);
	}
	//para evitar que los valore se repitan 
	//es mediante el equal(conpara el actual con el siguiente)
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePK other = (RolEnlacePK) obj;
		return idenlace == other.idenlace && idrol == other.idrol;
	}
	
	
	
	
	
	
	
}
