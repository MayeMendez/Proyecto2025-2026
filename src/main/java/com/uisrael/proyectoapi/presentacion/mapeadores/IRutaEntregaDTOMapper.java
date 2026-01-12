package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.RutaEntrega;
import com.uisrael.proyectoapi.presentacion.dto.request.RutaEntregaRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.RutaEntregaResponseDTO;


@Mapper(componentModel = "spring")
public interface IRutaEntregaDTOMapper {

	RutaEntrega toDomain(RutaEntregaRequestDTO dto);
	RutaEntregaResponseDTO toResponseDTO (RutaEntrega rutaEntrega);
	
}
