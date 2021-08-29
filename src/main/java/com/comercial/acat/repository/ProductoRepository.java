package com.comercial.acat.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comercial.acat.entity.Producto;


@Repository
@Transactional
public interface ProductoRepository extends JpaRepository<Producto, Integer>{


//	Optional<Producto>findByNombreproducto(String nombreproducto);
//	boolean existsByNombreproducto(String nombreproducto);
//	
//	
	
	@Query(value = "SELECT * FROM Producto as p WHERE p.grupoproducto=:grupoproducto", nativeQuery=true)
    List<Producto> productosByGrupo(int grupoproducto);
}
