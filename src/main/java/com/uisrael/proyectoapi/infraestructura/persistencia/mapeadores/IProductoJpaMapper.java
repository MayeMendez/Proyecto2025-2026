package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.Producto;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ProductoJpa;

@Mapper(componentModel = "spring")
public interface IProductoJpaMapper {
	
	Producto toDomain(ProductoJpa entity);
	ProductoJpa toEntity(Producto producto);

}
