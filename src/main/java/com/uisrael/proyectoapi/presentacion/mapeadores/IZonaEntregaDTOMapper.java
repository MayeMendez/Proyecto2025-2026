package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.ZonaEntrega;
import com.uisrael.proyectoapi.presentacion.dto.request.ZonaEntregaRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.ZonaEntregaResponseDTO;


@Mapper(componentModel = "spring")
public interface IZonaEntregaDTOMapper {

	ZonaEntrega toDomain(ZonaEntregaRequestDTO dto);
	ZonaEntregaResponseDTO toResponseDTO (ZonaEntrega zonaEntrega);
	
}
