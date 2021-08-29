package com.comercial.acat.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.acat.entity.Producto;
import com.comercial.acat.entity.ResourceNotFoundException;
import com.comercial.acat.repository.ProductoRepository;

@Service
@Transactional
public class ProductoService {

	@Autowired
	ProductoRepository proRepository;

	  
	public Producto  saveFoto(Producto productoRequest)
	{
       return proRepository.save(productoRequest);
	}

	    public List<Producto> getProductosByGrupo(int idgrupo) {
	    	return  proRepository.productosByGrupo(idgrupo);
	    }
	    
	    public List<Producto> findAll(){
			return proRepository.findAll();  //devuelve todos los proyectos
		}
		
		public Producto getById(int idproducto){
			return proRepository.findById(idproducto).orElseThrow(()-> new ResourceNotFoundException("Proyecto","ID",idproducto));
			//devuelve un proyecto filtrado por id
		}
	    
	  
	    public void delete(int id) {
	   
	        proRepository.deleteById(id);
	    }
	    
	    public boolean existsById(int idproducto) {
			return proRepository.existsById(idproducto); //devuelve true si existe un productor buscado por id
		}

	 
}