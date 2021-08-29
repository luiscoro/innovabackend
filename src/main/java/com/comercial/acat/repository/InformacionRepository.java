package com.comercial.acat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.acat.entity.Informacion;

@Repository
public interface InformacionRepository extends JpaRepository<Informacion, Integer> {

}
