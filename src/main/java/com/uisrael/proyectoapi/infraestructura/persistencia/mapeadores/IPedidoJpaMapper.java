package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Pedido;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.PedidoJpa;

@Mapper(componentModel = "spring")
public interface IPedidoJpaMapper {
	
	Pedido toDomain(PedidoJpa entity);
	PedidoJpa toEntity(Pedido pedido);
}
