package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.RutaEntrega;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.RutaEntregaJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ZonaEntregaJpa;

@Mapper(componentModel = "spring")
public interface IRutaEntregaJpaMapper {


    @Mapping(source = "zona_entrega.id_zona_entrega", target = "id_zona_entrega")
    RutaEntrega toDomain(RutaEntregaJpa entity);

   
    @Mapping(source = "id_zona_entrega", target = "zona_entrega")
    RutaEntregaJpa toEntity(RutaEntrega rutaEntrega);

  
    default ZonaEntregaJpa map(Integer idZona) {
        if (idZona == null) return null;
        ZonaEntregaJpa z = new ZonaEntregaJpa();
        z.setId_zona_entrega(idZona);
        return z;
    }
}