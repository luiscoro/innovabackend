package com.comercial.acat.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.comercial.acat.entity.Contacto;
import com.comercial.acat.entity.Investigador;
import com.comercial.acat.entity.Mensaje;
import com.comercial.acat.service.ContactoService;

@RestController
@RequestMapping("/contacto")
@CrossOrigin(origins = "*")
public class ContactoController {
	@Autowired
	ContactoService contactoService;
	
	
	@GetMapping ("/listar")
	public ResponseEntity<List<Contacto>> list(){
		List<Contacto> list = contactoService.findAll();
		return new ResponseEntity<List<Contacto>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Contacto> saveContacto( @Valid @RequestBody Contacto contactoRequest)
	{
		return new ResponseEntity<>(contactoService.saveContacto(contactoRequest), HttpStatus.OK);
	}

	
	@PutMapping("/update")
	public ResponseEntity<?> update (@Valid @RequestBody Contacto contacto){
				
		contactoService.saveContacto(contacto);
		return new ResponseEntity(new Mensaje("Datos del contacto modificados con exito"),HttpStatus.OK);
		
	//	if(investigadorService.existsByEmail(investigadorDto.getEmailinvestigador()) && investigadorService.getByEmail(productorDto.getEmailproductor()).get().getIdproductor() != idproductor )
		//	return new ResponseEntity(new Mensaje("Usted ya tiene una cuenta con ese correo"), HttpStatus.BAD_REQUEST);
		
		/*if(StringUtils.isBlank(investigadorDto.getNombreinvestigador()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(investigadorDto.getEmailinvestigador()))
			return new ResponseEntity(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isBlank(investigadorDto.getCargoinvestigador()))
			return new ResponseEntity(new Mensaje("El cargo es obligatorio"), HttpStatus.BAD_REQUEST);
		*/		
		
	}
	
	@DeleteMapping("/delete/{idcontacto}")
	public ResponseEntity<?> delete (@PathVariable ("idcontacto") int idcontacto){
		if (!contactoService.existsById(idcontacto))
			return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
		contactoService.delete (idcontacto);
		return new ResponseEntity(new Mensaje("Se elimino correctamente"),HttpStatus.OK);
	}
	
}
