package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Repartidor;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.RepartidorJpa;

@Mapper(componentModel = "spring")
public interface IRepartidorJpaMapper {
	
	Repartidor toDomain(RepartidorJpa entity);
	RepartidorJpa toEntity(Repartidor repartidor);

}
