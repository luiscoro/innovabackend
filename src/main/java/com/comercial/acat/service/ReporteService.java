package com.comercial.acat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comercial.acat.entity.Reporte;
import com.comercial.acat.repository.ReporteRepository;

@Service
public class ReporteService {
	
	@Autowired
	ReporteRepository rr;

	public List<Reporte> Listar() {
		return rr.findAll();
	}
	
	public Reporte Guardar(Reporte reporte) {
		return rr.save(reporte);
	}
	
	public void Delete(int idreporte) {
		rr.deleteById(idreporte);  //elimina un obj esp por su Id
	}
}
