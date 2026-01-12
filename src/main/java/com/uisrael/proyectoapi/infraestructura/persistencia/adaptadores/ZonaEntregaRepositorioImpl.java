package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.ZonaEntrega;
import com.uisrael.proyectoapi.dominio.repositorios.IZonaEntregaRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ZonaEntregaJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IZonaEntregaJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IZonaEntregaJpaRepositorio;

public class ZonaEntregaRepositorioImpl implements IZonaEntregaRepositorio{

	//dependencias
	
	private final IZonaEntregaJpaRepositorio jpaRepositorio;
	private final IZonaEntregaJpaMapper entityMapper;
	
	//constructor
	
	public ZonaEntregaRepositorioImpl(IZonaEntregaJpaRepositorio jpaRepositorio, IZonaEntregaJpaMapper entityMapper) {
	
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}
	
	@Override
	public ZonaEntrega guardar(ZonaEntrega zonaEntrega) {
		ZonaEntregaJpa entity = entityMapper.toEntity(zonaEntrega);
		ZonaEntregaJpa guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}


	@Override
	public Optional<ZonaEntrega> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<ZonaEntrega> listarTodos() {
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
