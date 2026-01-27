package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;

import com.uisrael.proyectoapi.dominio.entidades.DetallePedido;
import com.uisrael.proyectoapi.dominio.repositorios.IDetallePedidoRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.DetallePedidoJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.PedidoJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ProductoJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IDetallePedidoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IDetallePedidoJpaRepositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.math.BigDecimal;

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
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public DetallePedido guardar(DetallePedido det) {

	    if (det.getId_pedido() == null || det.getId_pedido() <= 0)
	        throw new RuntimeException("id_pedido obligatorio");

	    if (det.getId_producto() == null || det.getId_producto() <= 0)
	        throw new RuntimeException("id_producto obligatorio");

	    DetallePedidoJpa entity = new DetallePedidoJpa();

	    entity.setPedido(em.getReference(PedidoJpa.class, det.getId_pedido()));
	    entity.setProducto(em.getReference(ProductoJpa.class, det.getId_producto()));

	    entity.setCantidad(det.getCantidad());
	    entity.setPrecio_unitario(BigDecimal.valueOf(det.getPrecio_unitario()));
	    entity.setSubtotal(BigDecimal.valueOf(det.getSubtotal()));

	    return entityMapper.toDomain(jpaRepositorio.save(entity));
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



	@Override
	public DetallePedido actualizar(int id, DetallePedido detallePedido) {

	    DetallePedidoJpa entity = jpaRepositorio.findById(id)
	        .orElseThrow(() -> new RuntimeException("Detalle de Pedido no encontrado"));

	   
	    PedidoJpa pedidoRef = new PedidoJpa();
	    pedidoRef.setId_pedido(detallePedido.getId_pedido());   
	    entity.setPedido(pedidoRef);

	    ProductoJpa productoRef = new ProductoJpa();
	    productoRef.setId_producto(detallePedido.getId_producto()); 
	    entity.setProducto(productoRef);


	    entity.setCantidad(detallePedido.getCantidad());

	
	    BigDecimal precio = BigDecimal.valueOf(detallePedido.getPrecio_unitario());
	    entity.setPrecio_unitario(precio);

	 
	    BigDecimal subtotal = precio.multiply(BigDecimal.valueOf(detallePedido.getCantidad()));
	    entity.setSubtotal(subtotal);

	    DetallePedidoJpa guardado = jpaRepositorio.save(entity);
	    return entityMapper.toDomain(guardado);
	}

}
