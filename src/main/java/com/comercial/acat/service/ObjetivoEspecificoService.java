package com.comercial.acat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.acat.entity.*;
import com.comercial.acat.repository.*;

@Service
@Transactional
public class ObjetivoEspecificoService {

	@Autowired
	ObjetivoEspecificoRepository objEspRepository;
	
	public List<ObjetivoEspecifico>findAll(){
		return   objEspRepository.findAll();//devuelve todos los proyectos
	}
		
	public Optional<ObjetivoEspecifico>getById(int idobjEsp){
		return objEspRepository.findById(idobjEsp); //devuelve un obj esp filtrado por id
	}
	
	
	public ObjetivoEspecifico addObjetivo(ObjetivoEspecifico objetivoRequest) {		
		return objEspRepository.save(objetivoRequest);
	}
	
//	public ObjetivoEspecifico updateObjetivo(Integer objetivoId, ObjetivoEspecifico objetivoRequest) {
//		return objEspRepository.findById(objetivoId).map(objetivo -> {
//			objetivo.setNombreobjetivo(objetivoRequest.getNombreobjetivo());
//			objetivo.setProyecto(objetivoRequest.getProyecto());
//			return objEspRepository.save(objetivo);
//		}).orElseThrow(()-> new ResourceNotFoundException("Mission","id", objetivoId));
//	//	}).orElseThrow(() -> new ResourceNotFoundException("Mission", "id", proyectoId));
//		
//	}
	
	
	public void delete(int idObjEsp) {
		objEspRepository.deleteById(idObjEsp);  //elimina un obj esp por su Id
	}
	
	public boolean existsById(int idObjEsp) {
		return objEspRepository.existsById(idObjEsp); //devuelve true si existe un obj esp buscado por id
	}
	
	
}
