package com.comercial.acat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comercial.acat.entity.Enlace;

@Repository
public interface EnlaceRepository extends JpaRepository<Enlace, Integer> {

	@Query(value = "SELECT * FROM Enlace as e WHERE e.reporte=:idreporte", nativeQuery=true)
    List<Enlace> enlacesByReporte(int idreporte);
}
