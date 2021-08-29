package com.comercial.acat.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comercial.acat.entity.Investigador;



@Repository
public interface InvestigadorRepository extends JpaRepository<Investigador, Integer> {

		/*Optional<Productor>findByIdproductor(int idproductor);
		boolean existsByIdproductor(int idproductor);*/
	
		Optional<Investigador>findByNombreinvestigador(String nombreinvestigador);
		boolean existsByNombreinvestigador(String nombreinvestigador);
		
		Optional<Investigador>findByEmailinvestigador(String emailinvestigador);
		boolean existsByEmailinvestigador(String emailinvestigador);
}
