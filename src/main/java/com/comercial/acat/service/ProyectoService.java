package com.comercial.acat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.acat.entity.Proyecto;
import com.comercial.acat.entity.ResourceNotFoundException;
import com.comercial.acat.repository.ProyectoRepository;

@Service
public class ProyectoService {

		@Autowired
		ProyectoRepository proyectoRepository;
		
		public List<Proyecto> findAll(){
			return proyectoRepository.findAll();  //devuelve todos los proyectos
		}
		
		public Proyecto getById(int idproyecto){
			return proyectoRepository.findById(idproyecto).orElseThrow(()-> new ResourceNotFoundException("Proyecto","ID",idproyecto));
			//devuelve un proyecto filtrado por id
		}
		
		//public Optional<Proyecto> getOne(String tituloproyecto){
		//	return proyectoRepository.findByTitulo(tituloproyecto); //devuelve un proyecto filtrado por id
	//	}
		
		public Proyecto addProyecto(Proyecto proyectoRequest) {		
			return proyectoRepository.save(proyectoRequest);
		}
		
		public Proyecto updateProyecto(Integer proyectoId, Proyecto proyectoRequest) {
			return proyectoRepository.findById(proyectoId).map(proyecto -> {
				proyecto.setTitulo(proyectoRequest.getTitulo());
				proyecto.setObjetivogeneral(proyectoRequest.getObjetivogeneral());
				proyecto.setResumen(proyectoRequest.getResumen());
				proyecto.setAutor(proyectoRequest.getAutor());
				proyecto.setFecha(proyectoRequest.getFecha());
				return proyectoRepository.save(proyecto);
			}).orElseThrow(()-> new ResourceNotFoundException("Mission","id", proyectoId));
		//	}).orElseThrow(() -> new ResourceNotFoundException("Mission", "id", proyectoId));
			
		}
		
		public void delete(int idproyecto) {
			proyectoRepository.deleteById(idproyecto);  //elimina un productor por su Id
		}
		
		public boolean existsById(int idproyecto) {
			return proyectoRepository.existsById(idproyecto); //devuelve true si existe un productor buscado por id
		}
		
	//	public boolean existsByTitulo(String proyectotitulo) {
		//	return proyectoRepository.existsByTituloproyecto(proyectotitulo); //devuelve true si existe un proyecto buscado por titulo
		//}
		
	
}
