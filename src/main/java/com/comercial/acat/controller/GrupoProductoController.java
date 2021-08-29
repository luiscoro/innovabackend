package com.comercial.acat.controller;

import java.util.List;
import java.util.Optional;

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

import com.comercial.acat.entity.GrupoProducto;
import com.comercial.acat.entity.Mensaje;
import com.comercial.acat.entity.Producto;
import com.comercial.acat.service.GrupoProductoService;
import com.comercial.acat.service.ProductoService;

@RestController
@RequestMapping(path = "/grupoproducto")
@CrossOrigin(origins = "*")
public class GrupoProductoController {

	@Autowired
	GrupoProductoService gpService;//Para invocar los metodos
	
	@Autowired
	ProductoService proService;
	
	@GetMapping ("/listar")
	public ResponseEntity<List<GrupoProducto>> list(){
		List<GrupoProducto> list = gpService.findAll();
		return new ResponseEntity<List<GrupoProducto>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/grupo/{idgrupo}")
	public ResponseEntity<?> getProductosByGrupo(@PathVariable("idgrupo") int idgrupo){
		List<Producto> list = proService.getProductosByGrupo(idgrupo);
		return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/grupoById/{idgrupo}")
	public ResponseEntity<GrupoProducto> GrupoById (@PathVariable("idgrupo") int idgrupo){
		GrupoProducto gp = gpService.GrupoById(idgrupo).get();
		return new ResponseEntity<GrupoProducto>(gp, HttpStatus.OK);
	}

	
	@GetMapping ("/detail/{idgrupoproducto}")
	public ResponseEntity<GrupoProducto> getById (@PathVariable("idgrupoproducto") int idgrupoproducto){
		if (!gpService.existsById(idgrupoproducto))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		GrupoProducto proyecto = gpService.getById(idgrupoproducto);
		return new ResponseEntity<GrupoProducto>(proyecto, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<GrupoProducto> create(@RequestBody GrupoProducto grupoprod){
		return new ResponseEntity<>(gpService.addGrupoProducto(grupoprod), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<GrupoProducto> updateGrupoProducto(@Valid @RequestBody GrupoProducto gpRequest) {
		return new ResponseEntity<>(gpService.updateGrupoProducto(gpRequest), HttpStatus.OK);
	}	
	
	@DeleteMapping("/delete/{idgp}")
	public ResponseEntity<?> delete (@PathVariable ("idgp") int idgp){
		if (!gpService.existsById(idgp))
			return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
	
		gpService.delete(idgp);
		return new ResponseEntity(new Mensaje("Se elimino correctamente"),HttpStatus.OK);
	}

	
	
}
