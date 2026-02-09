package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ClienteJpa;

public interface IClienteJpaRepositorio extends JpaRepository<ClienteJpa, Integer>{

	@Query("SELECT COUNT(c) FROM ClienteJpa c WHERE c.identificacion = :identificacion")
	long countByIdentificacion(@Param("identificacion") String identificacion);


}
