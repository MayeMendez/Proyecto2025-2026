package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.DetallePedido;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.DetallePedidoJpa;

@Mapper(componentModel = "spring")
public interface IDetallePedidoJpaMapper {

	DetallePedido toDomain(DetallePedidoJpa entity);
	DetallePedidoJpa toEntity(DetallePedido detallePedido);
}
