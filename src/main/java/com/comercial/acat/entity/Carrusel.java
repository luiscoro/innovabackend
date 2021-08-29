package com.comercial.acat.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="carrusel")
public class Carrusel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcarrusel;
	@Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	private String descripcion;
	@Lob
	private String foto;
	
	
	public Carrusel() {
		super();
	}
	
	public Carrusel(String descripcion, String foto) {
		super();
		this.descripcion = descripcion;
		this.foto = foto;
	}

	public int getIdcarrusel() {
		return idcarrusel;
	}

	public void setIdcarrusel(int idcarrusel) {
		this.idcarrusel = idcarrusel;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	

}
