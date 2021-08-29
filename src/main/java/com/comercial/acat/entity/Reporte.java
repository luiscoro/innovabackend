package com.comercial.acat.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.NonNull;

@Entity
@Table(name="reporte")
public class Reporte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idreporte;
	
	@Column(name="nombrereporte")
	private String nombrereporte;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "producto", nullable = true, updatable = true)
	 @JsonBackReference(value="producto-reporte")
	    private @NonNull Producto producto;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "reporte")
	@JsonManagedReference(value="reporte-enlace")
	 private List<Enlace> enlaces;
	 
	Reporte(){
		super();
	}
	
	Reporte(int id){
		super();
		this.idreporte = id;
	}
	
	Reporte(String nombrereporte, Producto producto )
	{
		this.nombrereporte = nombrereporte;
		this.producto = producto;
	}

	public int getIdreporte() {
		return idreporte;
	}

	public void setIdreporte(int idreporte) {
		this.idreporte = idreporte;
	}


	public String getNombrereporte() {
		return nombrereporte;
	}

	public void setNombrereporte(String nombrereporte) {
		this.nombrereporte = nombrereporte;
	}

	public List<Enlace> getEnlaces() {
		return enlaces;
	}

	public void setEnlaces(List<Enlace> enlaces) {
		this.enlaces = enlaces;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	
	

}
