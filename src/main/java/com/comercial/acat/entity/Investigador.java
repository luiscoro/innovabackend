package com.comercial.acat.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="investigador")
public class Investigador {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idinvestigador;
	
	@Column(name="nombreinvestigador")
	private String nombreinvestigador;
	
	@Column(name="emailinvestigador")
	private String emailinvestigador;
	
	@Column(name="cargoinvestigador")
	private String cargoinvestigador;
	
	@Lob
	@Column(name="fotoinvestigador")
	private String fotoinvestigador;
	
	
	public Investigador() {
		
	}
	
	public Investigador(String nombreinvestigador, String emailinvestigador, String cargoinvestigador, String fotoinvestigador) {
		super();
		this.nombreinvestigador = nombreinvestigador;
		this.emailinvestigador = emailinvestigador;
		this.cargoinvestigador = cargoinvestigador;
		this.fotoinvestigador = fotoinvestigador;
	}

	public int getIdinvestigador() {
		return idinvestigador;
	}

	public void setIdinvestigador(int idinvestigador) {
		this.idinvestigador = idinvestigador;
	}

	public String getNombreinvestigador() {
		return nombreinvestigador;
	}

	public void setNombreinvestigador(String nombreinvestigador) {
		this.nombreinvestigador = nombreinvestigador;
	}

	public String getEmailinvestigador() {
		return emailinvestigador;
	}

	public void setEmailinvestigador(String emailinvestigador) {
		this.emailinvestigador = emailinvestigador;
	}

	public String getCargoinvestigador() {
		return cargoinvestigador;
	}

	public void setCargoinvestigador(String cargoinvestigador) {
		this.cargoinvestigador = cargoinvestigador;
	}

	public String getFoto() {
		return fotoinvestigador;
	}

	public void setFoto(String foto) {
		this.fotoinvestigador = foto;
	}

	@Override
	public String toString() {
		return "Investigador [id=" + idinvestigador + ", name=" + nombreinvestigador + ", description=" 
	            + cargoinvestigador + ", foto=" + fotoinvestigador+"]";
	}

}