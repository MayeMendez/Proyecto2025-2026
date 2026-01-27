package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.Pedido;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.PedidoJpa;

@Mapper(componentModel = "spring")
public interface IPedidoJpaMapper {
	
	@Mapping(source = "cliente.id_cliente", target = "id_cliente")
	@Mapping(source = "ruta_entrega.id_ruta_entrega", target = "id_ruta_entrega")
	@Mapping(source = "repartidor.id_repartidor", target = "id_repartidor")
	Pedido toDomain(PedidoJpa entity);

	@Mapping(target = "cliente", ignore = true)
	@Mapping(target = "ruta_entrega", ignore = true)
	@Mapping(target = "repartidor", ignore = true)
	PedidoJpa toEntity(Pedido domain);

}
