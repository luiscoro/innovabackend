package com.comercial.acat.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comercial.acat.entity.Publicacion;



@Repository
public interface PublicacionRepository extends JpaRepository <Publicacion, Integer> {
//OBTENEMOS EL CRUD
	@Query("FROM Publicacion ORDER BY fechapublicacion DESC")
	List<Publicacion> findAllByOrderByIdAsc();
}
