package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.RutaEntrega;
import com.uisrael.proyectoapi.dominio.repositorios.IRutaEntregaRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.RutaEntregaJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IRepartidorJpaMapper;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IRutaEntregaJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IRutaEntregaJpaRepositorio;

public class RutaEntregaRepositorioImpl implements IRutaEntregaRepositorio{

	//dependencias
	
	private final IRutaEntregaJpaRepositorio jpaRepositorio;
	private final IRutaEntregaJpaMapper entityMapper;
	
	//constructor
	
	public RutaEntregaRepositorioImpl(IRutaEntregaJpaRepositorio jpaRepositorio, IRutaEntregaJpaMapper entityMapper) {
		
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}
	
	@Override
	public RutaEntrega guardar(RutaEntrega rutaEntrega) {
		RutaEntregaJpa entity = entityMapper.toEntity(rutaEntrega);
		RutaEntregaJpa guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}


	@Override
	public Optional<RutaEntrega> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<RutaEntrega> listarTodos() {
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
