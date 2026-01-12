package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Pedido;
import com.uisrael.proyectoapi.dominio.repositorios.IPedidoRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.PedidoJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IPedidoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IPedidoJpaRepositorio;

public class PedidoRepositorioImpl implements IPedidoRepositorio{

	//dependencias 
	
	private final IPedidoJpaRepositorio jpaRepositorio;
	private final IPedidoJpaMapper entityMapper;
	
	
	//constructor
	
	public PedidoRepositorioImpl(IPedidoJpaRepositorio jpaRepositorio, IPedidoJpaMapper entityMapper) {
		
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}
	
	@Override
	public Pedido guardar(Pedido pedido) {
		PedidoJpa entity = entityMapper.toEntity(pedido);
		PedidoJpa guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}


	@Override
	public Optional<Pedido> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Pedido> listarTodos() {
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
