package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Producto;
import com.uisrael.proyectoapi.dominio.repositorios.IProductoRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ProductoJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IProductoJpaRepositorio;

public class ProductoRepositorioImpl implements IProductoRepositorio{

	//dependencias
	
	private final IProductoJpaRepositorio jpaRepositorio;
	private final IProductoJpaMapper entityMapper;
	
	//constructor
	
	public ProductoRepositorioImpl(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper entityMapper) {
		
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}
	
	@Override
	public Producto guardar(Producto producto) {
		ProductoJpa entity = entityMapper.toEntity(producto);
		ProductoJpa guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}


	@Override
	public Optional<Producto> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Producto> listarTodos() {
		return jpaRepositorio.findAll()
				.stream()
				.map(entityMapper::toDomain)
				.toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);
		
	}

}
