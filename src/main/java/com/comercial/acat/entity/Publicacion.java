package com.comercial.acat.entity;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="publicacion")
public class Publicacion {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idpublicacion;

@NotBlank

@Lob @Basic (fetch = FetchType.LAZY)
@Column(name="titulopublicacion", columnDefinition = "TEXT")
private String titulopublicacion;

@NotBlank
@Lob @Basic (fetch = FetchType.LAZY)
@Column(name="contenidopublicacion", columnDefinition = "TEXT")
private String contenidopublicacion;

@NotBlank
@Column(name="fechapublicacion")
private LocalDate fechapublicacion;

@Lob
@Basic (fetch = FetchType.LAZY)
@Column(name="fotopublicacion")
private String fotopublicacion;

public Publicacion() {

}

public Publicacion(@NotBlank String titulopublicacion,@NotBlank String contenidopublicacion,@NotBlank LocalDate fechapublicacion,
		String fotopublicacion) {
	super();
	this.titulopublicacion = titulopublicacion;
	this.contenidopublicacion = contenidopublicacion;
	this.fechapublicacion = fechapublicacion;
	this.fotopublicacion = fotopublicacion;
}

public int getIdpublicacion() {
	return idpublicacion;
}

public void setIdpublicacion(int idpublicacion) {
	this.idpublicacion = idpublicacion;
}

public String getTitulopublicacion() {
	return titulopublicacion;
}

public void setTitulopublicacion(String titulopublicacion) {
	this.titulopublicacion = titulopublicacion;
}

public String getContenidopublicacion() {
	return contenidopublicacion;
}

public void setContenidopublicacion(String contenidopublicacion) {
	this.contenidopublicacion = contenidopublicacion;
}

public LocalDate getFechapublicacion() {
	return fechapublicacion;
}

public void setFechapublicacion(LocalDate fechapublicacion) {
	this.fechapublicacion = fechapublicacion;
}

public String getFotopublicacion() {
	return fotopublicacion;
}

public void setFotopublicacion(String fotopublicacion) {
	this.fotopublicacion = fotopublicacion;
}


}
