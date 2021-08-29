package com.comercial.acat.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.comercial.acat.entity.Galeria;
import com.comercial.acat.entity.Informacion;
import com.comercial.acat.entity.Mensaje;
import com.comercial.acat.service.InformacionService;

@RestController
@RequestMapping(path = "/informacion")
@CrossOrigin(origins = "*")
public class InformacionController {

	@Autowired
	InformacionService is;
	

	@GetMapping ("/listar")
	public ResponseEntity<List<Informacion>> list(){
		List<Informacion> list = is.listar();
		return new ResponseEntity<List<Informacion>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Informacion> create(@RequestBody Informacion informacion){
		return new ResponseEntity<>(is.guardar(informacion), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Informacion> updateInformacion(@Valid @RequestBody Informacion informacionRequest) {
		return new ResponseEntity<>(is.guardar(informacionRequest), HttpStatus.OK);
	}	
	
	@DeleteMapping("/delete/{idinformacion}")
	public ResponseEntity<?> delete (@PathVariable ("idinformacion") int idinformacion){
				is.eliminar(idinformacion);
		return new ResponseEntity(new Mensaje("Se elimino correctamente"),HttpStatus.OK);
	}

	
}
