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

import com.comercial.acat.entity.Investigador;
import com.comercial.acat.entity.Mensaje;
import com.comercial.acat.service.InvestigadorService;

@RestController
@RequestMapping("/investigador")
@CrossOrigin(origins = "*")
public class InvestigadorController {

	@Autowired
	InvestigadorService investigadorService;


@DeleteMapping("/delete/{idinvestigador}")
public ResponseEntity<?> Delete (@PathVariable ("idinvestigador") int idinvestigador){

	investigadorService.delete(idinvestigador);
	return new ResponseEntity(new Mensaje("Investigador eliminado correctamente"),HttpStatus.OK);
}

@GetMapping ("/listar")
public ResponseEntity<List<Investigador>> list(){
	List<Investigador> list = investigadorService.findAll();
	return new ResponseEntity<List<Investigador>>(list, HttpStatus.OK);
}

@PostMapping("/create")
public ResponseEntity<Investigador> saveInvestigador( @Valid @RequestBody Investigador invRequest)
{
	return new ResponseEntity<>(investigadorService.saveInvestigador(invRequest), HttpStatus.OK);
}
	
@GetMapping ("/detail/{idinv}")
public ResponseEntity<Investigador> getById (@PathVariable("idinv") int idinv){
	if (!investigadorService.existsById(idinv))
		return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	Investigador inv = investigadorService.getById(idinv);
	return new ResponseEntity<Investigador>(inv, HttpStatus.OK);
}

@PutMapping("/update")
public ResponseEntity<Investigador> updateInvestigador(@Valid @RequestBody Investigador investigadorRequest) {
	return new ResponseEntity<>(investigadorService.saveInvestigador(investigadorRequest), HttpStatus.OK);
}	




}
