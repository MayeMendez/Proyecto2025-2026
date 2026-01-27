package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.ZonaEntrega;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ZonaEntregaJpa;

@Mapper(componentModel = "spring")
public interface IZonaEntregaJpaMapper {

    @Mapping(source = "id_zona_entrega", target = "id_zona_entrega")
    ZonaEntrega toDomain(ZonaEntregaJpa entity);

    
    @Mapping(source = "id_zona_entrega", target = "id_zona_entrega")
    ZonaEntregaJpa toEntity(ZonaEntrega zonaEntrega);

}
