package com.comercial.acat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.acat.entity.Informacion;
import com.comercial.acat.repository.InformacionRepository;

@Service
public class InformacionService {
	
	@Autowired
	InformacionRepository ir;
	
	public List<Informacion> listar(){
		return ir.findAll();
	}
	
	public Informacion guardar(Informacion informacion) {
		return ir.save(informacion);
	}
	
	public void eliminar(int idinfo) {
		 ir.deleteById(idinfo);
	}

}
