package com.uisrael.proyectoapi.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Producto;
import com.uisrael.proyectoapi.presentacion.dto.request.ProductoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.ProductoResponseDTO;


@Mapper(componentModel = "spring")
public interface IProductoDTOMapper {

	Producto toDomain(ProductoRequestDTO dto);
	ProductoResponseDTO toResponseDTO (Producto producto);
	
}
