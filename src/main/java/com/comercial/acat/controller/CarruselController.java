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

import com.comercial.acat.entity.Carrusel;
import com.comercial.acat.entity.Mensaje;
import com.comercial.acat.service.CarruselService;

@RestController
@RequestMapping(path = "/carrusel")
@CrossOrigin(origins = "*")
public class CarruselController {
	@Autowired
	CarruselService cs;
	
	@GetMapping ("/listar")
	public ResponseEntity<List<Carrusel>> list(){
		List<Carrusel> list = cs.listar();
		return new ResponseEntity<List<Carrusel>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Carrusel> create(@RequestBody Carrusel carrusel){
		return new ResponseEntity<>(cs.guardar(carrusel), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Carrusel> updateCarrusel(@Valid @RequestBody Carrusel carruselRequest) {
		return new ResponseEntity<>(cs.guardar(carruselRequest), HttpStatus.OK);
	}	
	
	@DeleteMapping("/delete/{idcarrusel}")
	public ResponseEntity<?> delete (@PathVariable ("idcarrusel") int idcarrusel){
				cs.eliminar(idcarrusel);
		return new ResponseEntity(new Mensaje("Se elimino correctamente"),HttpStatus.OK);
	}


}
