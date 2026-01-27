package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.Repartidor;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.RepartidorJpa;

@Mapper(componentModel = "spring")
public interface IRepartidorJpaMapper {
	
    @Mapping(source = "id_repartidor", target = "id_repartidor")
    Repartidor toDomain(RepartidorJpa entity);

    
    @Mapping(source = "id_repartidor", target = "id_repartidor")
    RepartidorJpa toEntity(Repartidor repartidor);


}
