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

import com.comercial.acat.entity.Mensaje;
import com.comercial.acat.entity.Producto;
import com.comercial.acat.service.ProductoService;


@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoController {
	
@Autowired
	    ProductoService proService;
	    

@DeleteMapping("/delete/{idproducto}")
public ResponseEntity<?> Delete (@PathVariable ("idproducto") int idproducto){

	proService.delete(idproducto);
	return new ResponseEntity(new Mensaje("Producto eliminado correctamente"),HttpStatus.OK);
}

@GetMapping ("/listar")
public ResponseEntity<List<Producto>> list(){
	List<Producto> list = proService.findAll();
	return new ResponseEntity<List<Producto>>(list, HttpStatus.OK);
}

@PostMapping("/create")
public ResponseEntity<Producto> saveProducto( @Valid @RequestBody Producto fotoRequest)
{
	return new ResponseEntity<>(proService.saveFoto(fotoRequest), HttpStatus.OK);
}

	
@GetMapping ("/detail/{idproducto}")
public ResponseEntity<Producto> getById (@PathVariable("idproducto") int idproducto){
	if (!proService.existsById(idproducto))
		return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	Producto producto = proService.getById(idproducto);
	return new ResponseEntity<Producto>(producto, HttpStatus.OK);
}

@PutMapping("/update")
public ResponseEntity<Producto> updateProducto(@Valid @RequestBody Producto productoRequest) {
	return new ResponseEntity<>(proService.saveFoto(productoRequest), HttpStatus.OK);
}	




}
