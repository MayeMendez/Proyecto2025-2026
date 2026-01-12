package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Pedido;
import com.uisrael.proyectoapi.presentacion.dto.request.PedidoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.PedidoResponseDTO;


@Mapper(componentModel = "spring")
public interface IPedidoDTOMapper {

	Pedido toDomain(PedidoRequestDTO dto);
	PedidoResponseDTO toResponseDTO (Pedido pedido);
	
}
