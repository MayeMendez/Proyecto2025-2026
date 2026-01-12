package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Repartidor;
import com.uisrael.proyectoapi.presentacion.dto.request.RepartidorRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.RepartidorResponseDTO;


@Mapper(componentModel = "spring")
public interface IRepartidorDTOMapper {

	Repartidor toDomain(RepartidorRequestDTO dto);
	RepartidorResponseDTO toResponseDTO (Repartidor repartidor);
	
}
