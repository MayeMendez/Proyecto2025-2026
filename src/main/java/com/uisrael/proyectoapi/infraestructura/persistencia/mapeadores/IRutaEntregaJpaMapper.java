package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.RutaEntrega;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.RutaEntregaJpa;

@Mapper(componentModel = "spring")
public interface IRutaEntregaJpaMapper {
	
	RutaEntrega toDomain(RutaEntregaJpa entity);
	RutaEntregaJpa toEntity(RutaEntrega rutaEntrega);

}
