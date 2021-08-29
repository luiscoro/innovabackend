package com.comercial.acat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.acat.entity.Galeria;
import com.comercial.acat.repository.GaleriaRepository;

@Service
public class GaleriaService {
	
	@Autowired
	GaleriaRepository gr;
	
	public List<Galeria> listar(){
		return gr.findAll();
	}
	
	public Galeria guardar(Galeria galeria) {
		return gr.save(galeria);
	}
	
	public void eliminar(int idgaleria) {
		 gr.deleteById(idgaleria);
	}

}
