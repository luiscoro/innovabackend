package com.comercial.acat.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.comercial.acat.entity.Publicacion;
import com.comercial.acat.exceptions.RecordNotFoundException;
import com.comercial.acat.repository.PublicacionRepository;

@Service
@Transactional
public class PublicacionService {
	
	@Autowired
	PublicacionRepository pr;

	public List<Publicacion> list(){
		return pr.findAllByOrderByIdAsc();  //devuelve todos los productos de la tabla
	}
	
	public Optional<Publicacion> getOne(int idpublicacion){
		return pr.findById(idpublicacion); //devuelve un producto filtrado por id
	}
	
	
	public Publicacion  savePublicacion(Publicacion pub)
	{
		return pr.save(pub);
	}
	
//	public void save (Publicacion pub) {
//		pr.save(pub); //guarda el productor
//	}

	
	public void delete (int idpublicacion) {
		pr.deleteById(idpublicacion);  //elimina un producto por su ID
	}
	
//	public Publicacion updateProducto(Publicacion publicacion) throws RecordNotFoundException {
//		Optional<Publicacion> recetaTemp = pr.findById(publicacion.getIdpublicacion());
//	
//		if(recetaTemp.isPresent()){
//			return pr.save(publicacion);
//		} else {
//			throw new RecordNotFoundException("No se encontro publicación con el id dado");
//		}
//	}
	
	public boolean existsById(int idpublicacion) {
		return pr.existsById(idpublicacion); //devuelve true si existe un usuario buscado por id
	}
	
	
}
