package com.comercial.acat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.acat.entity.Carrusel;
import com.comercial.acat.entity.Galeria;
import com.comercial.acat.repository.CarruselRepository;

@Service
public class CarruselService {
	
	@Autowired
	CarruselRepository cr;
	
	public List<Carrusel> listar(){
		return cr.findAll();
	}
	
	public Carrusel guardar(Carrusel carrusel) {
		return cr.save(carrusel);
	}
	
	public void eliminar(int idcarrusel) {
		 cr.deleteById(idcarrusel);
	}

}
