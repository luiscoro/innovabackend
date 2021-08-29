package com.comercial.acat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.acat.entity.Carrusel;

@Repository
public interface CarruselRepository extends JpaRepository<Carrusel, Integer> {

}
