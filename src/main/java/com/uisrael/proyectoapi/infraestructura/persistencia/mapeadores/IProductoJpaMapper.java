package com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.proyectoapi.dominio.entidades.Producto;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ProductoJpa;

@Mapper(componentModel = "spring")
public interface IProductoJpaMapper {

	Producto toDomain(ProductoJpa entity);

	@Mapping(target = "id_producto", ignore = true)
	ProductoJpa toEntityCrear(Producto producto);

	ProductoJpa toEntityActualizar(Producto producto);

}
