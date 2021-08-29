package com.comercial.acat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="enlace")
public class Enlace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idenlace;
	
	@Column(name="nombreenlace")
	private String nombreenlace;
	
	@Column(name="enlace",updatable = true)
	private String enlace;
	
	@JoinColumn(name="reporte")
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference(value="reporte-enlace")
	private Reporte reporte;

	public Enlace() {
		super();
	}

	public Enlace(String nombreenlace, String enlace, Reporte reporte) {
		super();
		this.nombreenlace = nombreenlace;
		this.reporte = reporte;
		this.enlace = enlace;
	}

	public int getIdenlace() {
		return idenlace;
	}

	public void setIdenlace(int idenlace) {
		this.idenlace = idenlace;
	}

	public String getNombreenlace() {
		return nombreenlace;
	}

	public void setNombreenlace(String nombreenlace) {
		this.nombreenlace = nombreenlace;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}
	
	
	
	
	
	
	

}
