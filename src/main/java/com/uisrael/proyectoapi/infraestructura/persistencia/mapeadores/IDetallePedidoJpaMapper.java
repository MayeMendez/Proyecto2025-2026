package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.DetallePedido;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.DetallePedidoJpa;

@Mapper(componentModel = "spring")
public interface IDetallePedidoJpaMapper {

	@Mapping(source = "pedido.id_pedido", target = "id_pedido")
	@Mapping(source = "producto.id_producto", target = "id_producto")
	DetallePedido toDomain(DetallePedidoJpa entity);
}
