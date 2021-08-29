package com.comercial.acat.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.comercial.acat.entity.Contacto;
import com.comercial.acat.repository.ContactoRepository;

@Service
@Transactional
public class ContactoService {

	@Autowired
	ContactoRepository contactoRepository;
	
	public Contacto  saveContacto(Contacto contacto)
	{
		return contactoRepository.save(contacto);
	}
	
	public List<Contacto> findAll(){
		return contactoRepository.findAll();  //devuelve todos los productores de la tablas
	}
	
	public Optional<Contacto> getOne(int idcontacto){
		return contactoRepository.findById(idcontacto); //devuelve un productor filtrado por id
	}
	

	
	public void delete (int idcontacto) {
		contactoRepository.deleteById(idcontacto);  //elimina un productor por su Id
	}
	
	public boolean existsById(int idcontacto) {
		return contactoRepository.existsById(idcontacto); //devuelve true si existe un productor buscado por id
	}
}
