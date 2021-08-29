package com.comercial.acat.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import com.comercial.acat.entity.ObjetivoEspecifico;
import com.comercial.acat.service.ObjetivoEspecificoService;



@RestController
@RequestMapping(path = "/objetivoespecifico")
@CrossOrigin(origins = "*")
public class ObjetivoEspecificoController {

	@Autowired
	ObjetivoEspecificoService objEspService;//Para invocar los metodos
	
	@GetMapping ("/listar")
	public ResponseEntity<List<ObjetivoEspecifico>> list(){
		List<ObjetivoEspecifico> list = objEspService.findAll();
		return new ResponseEntity<List<ObjetivoEspecifico>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping ("/detail/{idobjesp}")
	public ResponseEntity<ObjetivoEspecifico> getById (@PathVariable("idobjesp") int idobjesp){
		if (!objEspService.existsById(idobjesp))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		ObjetivoEspecifico objEsp = objEspService.getById(idobjesp).get();
		return new ResponseEntity<ObjetivoEspecifico>(objEsp, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ObjetivoEspecifico> create (@RequestBody ObjetivoEspecifico objetivoERequest){
		
		return new ResponseEntity<>(objEspService.addObjetivo(objetivoERequest), HttpStatus.CREATED);
		//return new ResponseEntity(new Mensaje("Objetivo especifico agregado con exito"), new HttpHeaders(),HttpStatus.OK);
	}
	
	
	
	@PutMapping("/update")
	public ResponseEntity<ObjetivoEspecifico> updateObjetivo(@Valid @RequestBody ObjetivoEspecifico objetivoRequest) {
		return new ResponseEntity<>(objEspService.addObjetivo(objetivoRequest), HttpStatus.OK);
	}	
	
	
	@DeleteMapping("/delete/{idobjesp}")
	public ResponseEntity<?> delete (@PathVariable ("idobjesp") int idobjesp){
		if (!objEspService.existsById(idobjesp))
			return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
		objEspService.delete(idobjesp);
		return new ResponseEntity(new Mensaje("Se elimino correctamente"),HttpStatus.OK);
	}

	
}
