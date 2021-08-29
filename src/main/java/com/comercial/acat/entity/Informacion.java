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
@Table(name="informacion")
public class Informacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idinformacion;

	@Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	private String titulobienvenida;
	@Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	private String subtitulobienvenida;
	@Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	private String quienessomos;
	@Lob
	private String imagenquienessomos;
	 @Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	 private String descripcioninnova;
	 
	 @Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	 private String tituloseccion1;
	 @Lob @Basic (fetch = FetchType.LAZY) @Column (columnDefinition = "TEXT")
	 private String subtituloseccion1;
	
	public Informacion() {
		super();
	}

	public Informacion(String titulobienvenida, String subtitulobienvenida, String quienessomos,
			String imagenquienessomos, String descripcioninnova) {
		super();
		this.titulobienvenida = titulobienvenida;
		this.subtitulobienvenida = subtitulobienvenida;
		this.quienessomos = quienessomos;
		this.imagenquienessomos = imagenquienessomos;
		this.descripcioninnova = descripcioninnova;
	}

	public int getIdinformacion() {
		return idinformacion;
	}

	public void setIdinformacion(int idinformacion) {
		this.idinformacion = idinformacion;
	}

	public String getTitulobienvenida() {
		return titulobienvenida;
	}

	public void setTitulobienvenida(String titulobienvenida) {
		this.titulobienvenida = titulobienvenida;
	}

	public String getSubtitulobienvenida() {
		return subtitulobienvenida;
	}

	public void setSubtitulobienvenida(String subtitulobienvenida) {
		this.subtitulobienvenida = subtitulobienvenida;
	}

	public String getQuienessomos() {
		return quienessomos;
	}

	public void setQuienessomos(String quienessomos) {
		this.quienessomos = quienessomos;
	}

	public String getImagenquienessomos() {
		return imagenquienessomos;
	}

	public void setImagenquienessomos(String imagenquienessomos) {
		this.imagenquienessomos = imagenquienessomos;
	}

	public String getDescripcioninnova() {
		return descripcioninnova;
	}

	public void setDescripcioninnova(String descripcioninnova) {
		this.descripcioninnova = descripcioninnova;
	}

	public String getTituloseccion1() {
		return tituloseccion1;
	}

	public void setTituloseccion1(String tituloseccion1) {
		this.tituloseccion1 = tituloseccion1;
	}

	public String getSubtituloseccion1() {
		return subtituloseccion1;
	}

	public void setSubtituloseccion1(String subtituloseccion1) {
		this.subtituloseccion1 = subtituloseccion1;
	}

	
	

	
}
