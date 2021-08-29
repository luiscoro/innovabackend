package com.comercial.acat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.acat.entity.Enlace;
import com.comercial.acat.repository.EnlaceRepository;

@Service
@Transactional
public class EnlaceService {
	
	@Autowired
	EnlaceRepository er;
	
	public List<Enlace> Listar(){
		return er.findAll();
	}
	
	  public List<Enlace> getEnlacesByReporte(int idreporte) {//Se retornan los enlaces del reporte seleccionado mediante event onclick en front
	    	return  er.enlacesByReporte(idreporte);
	    }
	
	public Enlace Guardar(Enlace enlace) {//Este sirve para guardar y actualizar
		return er.save(enlace);
	}
	
	public void Eliminar(int idenlace) {
		 er.deleteById(idenlace);
	}
	
	public boolean existsById(int idenlace) {
		return er.existsById(idenlace); //devuelve true si existe un productor buscado por id
	}
	

}
