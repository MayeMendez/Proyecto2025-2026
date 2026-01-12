package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.DetallePedido;
import com.uisrael.proyectoapi.dominio.repositorios.IDetallePedidoRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.DetallePedidoJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IDetallePedidoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IDetallePedidoJpaRepositorio;

public class DetallePedidoRepositorioImpl implements IDetallePedidoRepositorio{

	//dependencias
	
	private final IDetallePedidoJpaRepositorio jpaRepositorio;
	private final IDetallePedidoJpaMapper entityMapper;
	
	//constructor
	
	public DetallePedidoRepositorioImpl(IDetallePedidoJpaRepositorio jpaRepositorio,
			IDetallePedidoJpaMapper entityMapper) {
		
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}
	
	@Override
	public DetallePedido guardar(DetallePedido detallePedido) {
		DetallePedidoJpa entity = entityMapper.toEntity(detallePedido);
		DetallePedidoJpa guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}


	@Override
	public Optional<DetallePedido> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<DetallePedido> listarTodos() {
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
