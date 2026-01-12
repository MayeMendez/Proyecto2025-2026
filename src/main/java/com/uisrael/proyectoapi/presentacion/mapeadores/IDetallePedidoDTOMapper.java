package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.DetallePedido;
import com.uisrael.proyectoapi.presentacion.dto.request.DetallePedidoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.DetallePedidoResponseDTO;


@Mapper(componentModel = "spring")
public interface IDetallePedidoDTOMapper {

	DetallePedido toDomain(DetallePedidoRequestDTO dto);
	DetallePedidoResponseDTO toResponseDTO (DetallePedido detallePedido);
}
