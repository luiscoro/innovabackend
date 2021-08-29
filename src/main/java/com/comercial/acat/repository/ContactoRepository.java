package com.comercial.acat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.acat.entity.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

}
