package com.comercial.acat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.acat.entity.Reporte;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
	

}
