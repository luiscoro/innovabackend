package com.comercial.acat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.acat.entity.GrupoProducto;
import com.comercial.acat.entity.Proyecto;
import com.comercial.acat.entity.ResourceNotFoundException;
import com.comercial.acat.repository.GrupoProductoRepository;
import com.comercial.acat.repository.ProyectoRepository;

@Service
@Transactional
public class GrupoProductoService {

		@Autowired
		GrupoProductoRepository gpRepository;
		
		public List<GrupoProducto> findAll(){
			return gpRepository.findAll();  //devuelve todos los proyectos
		}
		
		public GrupoProducto getById(int idgp){
			return gpRepository.findById(idgp).orElseThrow(()-> new ResourceNotFoundException("GrupoProducto","ID",idgp));
		
		}
		
		public Optional<GrupoProducto> GrupoById(int idgrupo){
		return gpRepository.findById(idgrupo);
		}
		
		public GrupoProducto addGrupoProducto(GrupoProducto gpRequest) {		
			return gpRepository.save(gpRequest);
		}
		
		public GrupoProducto updateGrupoProducto(GrupoProducto gpRequest) {
			return gpRepository.save(gpRequest);
//			return gpRepository.findById(gpId).map(grupoproducto -> {
//				grupoproducto.setNombregrupo(gpRequest.getNombregrupo());
//				return gpRepository.save(grupoproducto);
//			}).orElseThrow(()-> new ResourceNotFoundException("Producto","id", gpId));
//	
			
		}
		
		public void delete(int idgp) {
			gpRepository.deleteById(idgp);  //elimina un productor por su Id
		}
		
		public boolean existsById(int idgp) {
			return gpRepository.existsById(idgp); //devuelve true si existe un productor buscado por id
		}
			
	
}