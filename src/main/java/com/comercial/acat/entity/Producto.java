package com.comercial.acat.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//@Data
//@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="producto")
public class Producto{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproducto;
	
	@Column(name="nombreproducto")
	private String nombreproducto;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "grupoproducto",  nullable = true, updatable = true)//name: Nombre para la relacion m-1, updatable:true=actualizable   
	 @JsonBackReference
	    private GrupoProducto grupoproducto;
	 

	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.EAGER)
		@JsonManagedReference(value="producto-reporte")//Permite obtener el json de cada reporte en el Producto
	    private List<Reporte> reportes;
	 
	 
	 @Lob
	 @Basic (fetch = FetchType.LAZY)
	 @Column(name="fotoproducto")
	 private String fotoproducto;
	 
	 
	public Producto() {
		super();
	}
	
	// ** Es necesario para la referencia de id de reportes hacia un producto
	public Producto(int id) {
		super();
		this.idproducto = id;
	}
	//**
	
	public Producto(String nombreproducto, GrupoProducto grupoproducto, String fotoproducto) {
		super();
		this.nombreproducto = nombreproducto;
		this.grupoproducto = grupoproducto;
		this.fotoproducto = fotoproducto;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	public GrupoProducto getGrupoproducto() {
		return grupoproducto;
	}

	public void setGrupoproducto(GrupoProducto grupoproducto) {
		this.grupoproducto = grupoproducto;
	}
	
	    public List<Reporte> getReportes() {
		return reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

		public String getFotoproducto() {
		return fotoproducto;
	}

	public void setFotoproducto(String fotoproducto) {
		this.fotoproducto = fotoproducto;
	}

		@Override
	    public String toString() {
	        return "Producto{" +
	            "idproducto=" + getIdproducto() +
	            ", nombreproducto='" + getNombreproducto() + "'" +
	            ", grupoproducto='" + getGrupoproducto() + "'" +
	            ", fotoproducto='" + getFotoproducto() + "'" +
	            "}";
	    }

	 
	 
	
	
}