package com.comercial.acat.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="proyecto")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproyecto;
	@Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	String titulo;
	@Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	String objetivogeneral;
	@Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	String resumen;
	@Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	String palabrasclave;
	String autor;
	@Column(name="fecha")
	private LocalDate fecha;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto",  fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<ObjetivoEspecifico> objetivosespecificos;
	
	public Proyecto(int id ) {
		super();
		this.idproyecto = id;
	}
	public Proyecto() {
		super();
	}
	
	public Proyecto(String titulo, String objetivogeneral, String resumen, String autor, @NotBlank LocalDate fecha, String palabrasclave) {
		super();
		this.titulo = titulo;
		this.objetivogeneral = objetivogeneral;
		this.resumen = resumen;
		this.autor = autor;
		this.fecha = fecha;
		this.palabrasclave = palabrasclave;
	}

	public int getIdproyecto() {
		return idproyecto;
	}

	public void setIdproyecto(int idproyecto) {
		this.idproyecto = idproyecto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObjetivogeneral() {
		return objetivogeneral;
	}

	public void setObjetivogeneral(String objetivogeneral) {
		this.objetivogeneral = objetivogeneral;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<ObjetivoEspecifico> getObjetivosespecificos() {
		return objetivosespecificos;
	}

	public void setObjetivosespecificos(List<ObjetivoEspecifico> objetivosespecificos) {
		this.objetivosespecificos = objetivosespecificos;
	}
	public String getPalabrasclave() {
		return palabrasclave;
	}
	public void setPalabrasclave(String palabrasclave) {
		this.palabrasclave = palabrasclave;
	}
	
	

//	public List<PalabraClave> getPalabrasclave() {
//		return palabrasclave;
//	}
//
//	public void setPalabrasclave(List<PalabraClave> palabrasclave) {
//		this.palabrasclave = palabrasclave;
//	}

	
	

}
