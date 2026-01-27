package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Pedido;
import com.uisrael.proyectoapi.dominio.repositorios.IPedidoRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ClienteJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.PedidoJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.RepartidorJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.RutaEntregaJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IPedidoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IPedidoJpaRepositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PedidoRepositorioImpl implements IPedidoRepositorio {

	// dependencias

	private final IPedidoJpaRepositorio jpaRepositorio;
	private final IPedidoJpaMapper entityMapper;

	// constructor

	public PedidoRepositorioImpl(IPedidoJpaRepositorio jpaRepositorio, IPedidoJpaMapper entityMapper) {

		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Pedido guardar(Pedido pedido) {

	    PedidoJpa entity = new PedidoJpa();

	    entity.setCliente(em.getReference(ClienteJpa.class, pedido.getId_cliente()));

	    entity.setRuta_entrega(
	        pedido.getId_ruta_entrega() != null
	            ? em.getReference(RutaEntregaJpa.class, pedido.getId_ruta_entrega())
	            : null
	    );

	    entity.setRepartidor(
	        pedido.getId_repartidor() != null
	            ? em.getReference(RepartidorJpa.class, pedido.getId_repartidor())
	            : null
	    );

	    entity.setFecha_pedido(pedido.getFecha_pedido());
	    entity.setFecha_entrega_programada(pedido.getFecha_entrega_programada()); 
	    entity.setEstado(pedido.getEstado());
	    entity.setTipo_venta(pedido.getTipo_venta());

	    entity.setTotal_pedido(
	        pedido.getTotal_pedido() != null ? BigDecimal.valueOf(pedido.getTotal_pedido()) : null
	    );

	    return entityMapper.toDomain(jpaRepositorio.save(entity));
	}

	@Override
	public Optional<Pedido> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Pedido> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);

	}

	@Override
	public Pedido actualizar(int id, Pedido pedido) {

	    PedidoJpa entity = jpaRepositorio.findById(id)
	        .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

	    entity.setCliente(em.getReference(ClienteJpa.class, pedido.getId_cliente()));

	    entity.setRuta_entrega(
	        pedido.getId_ruta_entrega() != null
	            ? em.getReference(RutaEntregaJpa.class, pedido.getId_ruta_entrega())
	            : null
	    );

	    entity.setRepartidor(
	        pedido.getId_repartidor() != null
	            ? em.getReference(RepartidorJpa.class, pedido.getId_repartidor())
	            : null
	    );

	    entity.setFecha_pedido(pedido.getFecha_pedido()); // ✅ NO parse
	    entity.setFecha_entrega_programada(pedido.getFecha_entrega_programada()); // ✅ NO parse

	    entity.setEstado(pedido.getEstado());
	    entity.setTipo_venta(pedido.getTipo_venta());

	    entity.setTotal_pedido(
	        pedido.getTotal_pedido() != null ? BigDecimal.valueOf(pedido.getTotal_pedido()) : null
	    );

	    return entityMapper.toDomain(jpaRepositorio.save(entity));
	}
}
