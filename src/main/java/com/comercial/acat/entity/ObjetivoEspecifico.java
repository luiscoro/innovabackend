package com.comercial.acat.entity;
import javax.persistence.Basic;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


//@Data
//@ToString(exclude = "proyecto")
//@EqualsAndHashCode(exclude = "proyecto")
//@RequiredArgsConstructor
//@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class ObjetivoEspecifico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idobjetivo;
	@Lob @Basic (fetch = FetchType.EAGER) @Column (columnDefinition = "TEXT")
	private String nombreobjetivo;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "proyecto", nullable = true, updatable = true)
	 @JsonBackReference
	    private Proyecto proyecto;
	 
	public ObjetivoEspecifico(){
		super();
	}

	public ObjetivoEspecifico(String nombreobjetivo, @NonNull Proyecto proyecto) {
		super();
		this.nombreobjetivo = nombreobjetivo;
		this.proyecto = proyecto;
	}

	public int getIdobjetivo() {
		return idobjetivo;
	}

	public void setIdobjetivo(int idobjetivo) {
		this.idobjetivo = idobjetivo;
	}

	public String getNombreobjetivo() {
		return nombreobjetivo;
	}

	public void setNombreobjetivo(String nombreobjetivo) {
		this.nombreobjetivo = nombreobjetivo;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
}
