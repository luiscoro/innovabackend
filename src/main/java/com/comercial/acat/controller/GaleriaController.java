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
import com.comercial.acat.entity.Mensaje;
import com.comercial.acat.service.GaleriaService;

@RestController
@RequestMapping(path = "/galeria")
@CrossOrigin(origins = "*")
public class GaleriaController {
	
	@Autowired
	GaleriaService gs;
	
	
	@GetMapping ("/listar")
	public ResponseEntity<List<Galeria>> list(){
		List<Galeria> list = gs.listar();
		return new ResponseEntity<List<Galeria>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Galeria> create(@RequestBody Galeria galeria){
		return new ResponseEntity<>(gs.guardar(galeria), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Galeria> updateGaleria(@Valid @RequestBody Galeria galeriaRequest) {
		return new ResponseEntity<>(gs.guardar(galeriaRequest), HttpStatus.OK);
	}	
	
	@DeleteMapping("/delete/{idgaleria}")
	public ResponseEntity<?> delete (@PathVariable ("idgaleria") int idgaleria){
				gs.eliminar(idgaleria);
		return new ResponseEntity(new Mensaje("Se elimino correctamente"),HttpStatus.OK);
	}

	

}
