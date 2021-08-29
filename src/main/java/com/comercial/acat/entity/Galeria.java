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
@Table(name="galeria")
public class Galeria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idgaleria;
	@Lob
	@Basic (fetch = FetchType.LAZY)
	private String foto;
	@Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	private String descripcion;
	
	
	public Galeria() {
		super();
	}


	public Galeria(String foto, String descripcion) {
		super();
		this.foto = foto;
		this.descripcion = descripcion;
	}


	public int getIdgaleria() {
		return idgaleria;
	}


	public void setIdgaleria(int idgaleria) {
		this.idgaleria = idgaleria;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	

}
