package com.comercial.acat.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comercial.acat.entity.Mensaje;
import com.comercial.acat.entity.Producto;
import com.comercial.acat.entity.Reporte;

import com.comercial.acat.service.ReporteService;

@RestController
@RequestMapping("/reporte")
@CrossOrigin(origins = "*")
public class ReporteController {
	
	@Autowired
	ReporteService rs;
	
	@GetMapping("/listar")
	public List<Reporte> ListarReportes(){
		return rs.Listar();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Reporte> saveReporte( @Valid @RequestBody Reporte reporteRequest)
	{
		System.out.println("objeto recibido en el backend "+reporteRequest);
		return new ResponseEntity<>(rs.Guardar(reporteRequest), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{idreporte}")
	public ResponseEntity<?> delete (@PathVariable ("idreporte") int idreporte){
		rs.Delete(idreporte);
		return new ResponseEntity(new Mensaje("Producto eliminado correctamente"),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public Reporte ActualizarReporte(@Valid @RequestBody Reporte reporte) {
		System.out.println("objeto recibido en el backend update "+reporte);
		return rs.Guardar(reporte);
	}

}
