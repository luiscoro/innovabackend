package com.comercial.acat.controller;

import java.time.LocalDate;
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
import com.comercial.acat.entity.Mensaje;
import com.comercial.acat.entity.Proyecto;
import com.comercial.acat.service.ProyectoService;

@RestController
@RequestMapping(path = "/proyecto")
@CrossOrigin(origins = "*")
public class ProyectoController {
	
	@Autowired
	ProyectoService proService;//Para invocar los metodos
	
	@GetMapping ("/listar")
	public ResponseEntity<List<Proyecto>> list(){
		List<Proyecto> list = proService.findAll();
		return new ResponseEntity<List<Proyecto>>(list, HttpStatus.OK);
	}
	
	
	
	@GetMapping ("/detail/{idproyecto}")
	public ResponseEntity<Proyecto> getById (@PathVariable("idproyecto") int idproyecto){
		if (!proService.existsById(idproyecto))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Proyecto proyecto = proService.getById(idproyecto);
		return new ResponseEntity<Proyecto>(proyecto, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Proyecto> create(@RequestBody Proyecto proyecto){
		LocalDate fechaAhora = LocalDate.now();
		System.out.printf("La fecha actual es: ",fechaAhora);
		proyecto.setFecha(fechaAhora);
		return new ResponseEntity<>(proService.addProyecto(proyecto), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Proyecto> updateProyecto(@Valid @RequestBody Proyecto proyectoRequest) {
		return new ResponseEntity<>(proService.addProyecto(proyectoRequest), HttpStatus.OK);
	}	
	
	@DeleteMapping("/delete/{idproyecto}")
	public ResponseEntity<?> delete (@PathVariable ("idproyecto") int idproyecto){
		if (!proService.existsById(idproyecto))
			return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
	
		proService.delete(idproyecto);
		return new ResponseEntity(new Mensaje("Se elimino correctamente"),HttpStatus.OK);
	}

	
	
}
