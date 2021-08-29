package com.comercial.acat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.acat.entity.GrupoProducto;
import com.comercial.acat.entity.Producto;
import com.comercial.acat.entity.Publicacion;

//@Transactional
@Repository
@Transactional
public interface GrupoProductoRepository extends JpaRepository<GrupoProducto, Integer>{

//	@Query(value = "SELECT * FROM GrupoProducto as gp WHERE gp.idgrupo =:idgrupo", nativeQuery=true)
//    void GrupoById(int idgrupo);
	
	
}

