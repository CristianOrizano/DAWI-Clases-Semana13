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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_medicamento")
public class Medicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_med")
	private Integer codigo;
	
	@Column(name="nom_med")
	private String nombre;
	
	@Column(name="des_med")
	private String descripcion;
	
	@Column(name="sto_med")
	private int stock;
	
	@Column(name="pre_med")
	private double precio;
	
	//para indicarle el formato de fecha, porque sino devuelve uno largo
	@Temporal(TemporalType.DATE)
	@Column(name="fec_fab_med")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	//bi-direccional
	//--------------------llave foranea
	@ManyToOne
	@JoinColumn(name="cod_tipo")
	private TipoMedicamento tipo;//ASOC.
	
	//no es necesario@Column por el nombre es igual
	private byte[] foto;
	
	@Column(name="nom_archivo")
	private String nombreArchivo;
	
	
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TipoMedicamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMedicamento tipo) {
		this.tipo = tipo;
	}

	


	
	
	
	
}
