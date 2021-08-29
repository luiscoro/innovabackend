package com.comercial.acat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.acat.entity.Producto;
import com.comercial.acat.entity.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Integer> {

	
	//Optional<Proyecto>findByTitulo(String tituloproyecto);
	//boolean existsByTituloproyecto(String tituloproyecto);
	
}
