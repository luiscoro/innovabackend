package com.comercial.acat.entity;


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

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="grupoproducto")
public class GrupoProducto{
	 
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idgrupo;
	
	@Column(name="nombregrupo")
	private String nombregrupo;
	
	@Column(name="titulo")
	private String titulo;
	
	@Lob @Basic (fetch = FetchType.LAZY)
	@Column(name="descripcion", columnDefinition = "TEXT")
	private String descripcion;
	
	@Lob
	@Column(name="fotogrupo")
	private String fotogrupo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoproducto", fetch = FetchType.EAGER)
	@JsonManagedReference
    private List<Producto> productos;

	public GrupoProducto() {
	
	}

	
	public GrupoProducto(int idgrupo) {
	super();
	this.idgrupo=idgrupo;
	
	}
	
	public GrupoProducto( String nombregrupo, String titulo, String fotogrupo, String descripcion, List<Producto> productos) {
		super();
		this.nombregrupo = nombregrupo;
		this.productos = productos;
		this.titulo = titulo;
		this.fotogrupo = fotogrupo;
		this.descripcion = descripcion;
	}

	public int getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}

	public String getNombregrupo() {
		return nombregrupo;
	}

	public void setNombregrupo(String nombregrupo) {
		this.nombregrupo = nombregrupo;
	}
	
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	public String getFotogrupo() {
		return fotogrupo;
	}


	public void setFotogrupo(String fotogrupo) {
		this.fotogrupo = fotogrupo;
	}
	
	
	
	

}
