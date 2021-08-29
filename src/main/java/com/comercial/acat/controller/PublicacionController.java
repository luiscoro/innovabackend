package com.comercial.acat.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.comercial.acat.entity.Mensaje;
import com.comercial.acat.entity.Publicacion;
import com.comercial.acat.service.PublicacionService;

@RestController
@RequestMapping("/publicacion")
@CrossOrigin(origins = "*")
public class PublicacionController {

	@Autowired
	PublicacionService ps;
	
	
	@GetMapping ("/listar")
	public ResponseEntity<List<Publicacion>> list(){
		List<Publicacion> list = ps.list();
		return new ResponseEntity<List<Publicacion>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("/create")
    public ResponseEntity<Publicacion> savePublicacion(@Valid @RequestBody Publicacion pub)
    {	
		LocalDate fechaAhora = LocalDate.now();
		System.out.printf("La fecha actual es: ",fechaAhora);
		pub.setFechapublicacion(fechaAhora);
    	return new ResponseEntity<>(ps.savePublicacion(pub),HttpStatus.OK);
    }
	
	@PutMapping("/update")
	public ResponseEntity<?> update (@Valid @RequestBody Publicacion pub ){
		
		if (!ps.existsById(pub.getIdpublicacion()))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		
		ps.savePublicacion(pub);
		return new ResponseEntity(new Mensaje("Datos de la publicacion modificados con exito"),HttpStatus.OK);
	
	}
	
	

@DeleteMapping("/delete/{idpublicacion}")
public ResponseEntity<?> Delete (@PathVariable ("idpublicacion") int idpublicacion){
	ps.delete(idpublicacion);
	return new ResponseEntity(new Mensaje("Publicacion eliminada correctamente"),HttpStatus.OK);
}
	
	

}

