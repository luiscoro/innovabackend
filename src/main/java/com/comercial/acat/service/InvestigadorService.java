package com.comercial.acat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.acat.entity.Investigador;
import com.comercial.acat.entity.ResourceNotFoundException;
import com.comercial.acat.repository.InvestigadorRepository;
import java.util.List;
//
@Service
@Transactional
public class InvestigadorService {

	@Autowired
	InvestigadorRepository investigadorRepository;
	
	
	public Investigador  saveInvestigador(Investigador investigadorRequest)
	{
       return investigadorRepository.save(investigadorRequest);
	}

	   
	    
	    public List<Investigador> findAll(){
			return investigadorRepository.findAll();  //devuelve todos los proyectos
		}
		
		public Investigador getById(int idproducto){
			return investigadorRepository.findById(idproducto).orElseThrow(()-> new ResourceNotFoundException("Proyecto","ID",idproducto));
			//devuelve un proyecto filtrado por id
		}
	    
	  
	    public void delete(int id) {
	   
	        investigadorRepository.deleteById(id);
	    }
	    
	    public boolean existsById(int idproducto) {
			return investigadorRepository.existsById(idproducto); //devuelve true si existe un productor buscado por id
		}

	 
}
