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

import com.comercial.acat.entity.Enlace;
import com.comercial.acat.entity.Mensaje;
import com.comercial.acat.entity.Producto;
import com.comercial.acat.service.EnlaceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enlace")
public class EnlaceController {
	
	@Autowired
	EnlaceService es;
	
	@GetMapping("/listar")
	public List<Enlace> ListarEnlaces(){
		return es.Listar();
	}
	
	@GetMapping("/reporte-enlace/{idreporte}")
	public List<Enlace> ListarEnlacesByReporte(@PathVariable("idreporte") int idreporte){
	return  es.getEnlacesByReporte(idreporte);	
	}
	
	@PostMapping("/create")
	public ResponseEntity<Enlace> GuardarEnlace(@Valid @RequestBody Enlace enlace) {
		 es.Guardar(enlace);
		 return new ResponseEntity("Mensaje agregado con exito", HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Enlace> updateEnlace(@Valid @RequestBody Enlace enlaceRequest) {
		return new ResponseEntity<>(es.Guardar(enlaceRequest), HttpStatus.OK);
	}	
//	
//	@DeleteMapping("/delete/{idenlace}")
//	public ResponseEntity<?> EliminarEnlace(@PathVariable("idenlace") int idenlace) {
//		 es.Eliminar(idenlace);
//		 return new ResponseEntity("Enlace eliminado", HttpStatus.OK);
//	}
	
	@DeleteMapping("/delete/{idenlace}")
	public ResponseEntity<?> delete (@PathVariable ("idenlace") int idenlace){
		if (!es.existsById(idenlace))
			return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
	
		es.Eliminar(idenlace);
		return new ResponseEntity(new Mensaje("Se elimino correctamente"),HttpStatus.OK);
	}
	
	

}
