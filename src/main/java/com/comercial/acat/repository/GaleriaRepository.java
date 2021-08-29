package com.comercial.acat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.acat.entity.Galeria;

@Repository
public interface GaleriaRepository extends JpaRepository<Galeria, Integer>{
	
	

}
