package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.ZonaEntrega;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ZonaEntregaJpa;

@Mapper(componentModel = "spring")
public interface IZonaEntregaJpaMapper {

	ZonaEntrega toDomain(ZonaEntregaJpa entity);
	ZonaEntregaJpa toEntity(ZonaEntrega zonaEntrega);
	
}
