package com.comercial.acat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="contacto")
public class Contacto {

	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idcontacto;

@NotBlank
@Column(name="nombrecontacto")
private String nombreContacto;

@NotBlank
@Column(name="telefonocontacto")
private String telefonoContacto;

@NotBlank
@Column(name="correocontacto")
private String correoContacto;

@Lob
@Column(name="fotocontacto")
private String fotocontacto;

public Contacto() {
	
}

public Contacto(@NotBlank String nombreContacto, @NotBlank String telefonoContacto, @NotBlank String correoContacto,
		String fotocontacto) {
	super();
	this.nombreContacto = nombreContacto;
	this.telefonoContacto = telefonoContacto;
	this.correoContacto = correoContacto;
	this.fotocontacto = fotocontacto;
}

public int getIdcontacto() {
	return idcontacto;
}

public void setIdcontacto(int idcontacto) {
	this.idcontacto = idcontacto;
}

public String getNombreContacto() {
	return nombreContacto;
}

public void setNombreContacto(String nombreContacto) {
	this.nombreContacto = nombreContacto;
}

public String getTelefonoContacto() {
	return telefonoContacto;
}

public void setTelefonoContacto(String telefonoContacto) {
	this.telefonoContacto = telefonoContacto;
}

public String getCorreoContacto() {
	return correoContacto;
}

public void setCorreoContacto(String correoContacto) {
	this.correoContacto = correoContacto;
}

public String getFotocontacto() {
	return fotocontacto;
}

public void setFotocontacto(String fotocontacto) {
	this.fotocontacto = fotocontacto;
}

}
