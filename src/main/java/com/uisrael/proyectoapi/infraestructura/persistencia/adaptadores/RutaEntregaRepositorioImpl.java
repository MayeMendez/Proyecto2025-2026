package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.RutaEntrega;
import com.uisrael.proyectoapi.dominio.repositorios.IRutaEntregaRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.RutaEntregaJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ZonaEntregaJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IRutaEntregaJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IRutaEntregaJpaRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RutaEntregaRepositorioImpl implements IRutaEntregaRepositorio {

	// dependencias

	private final IRutaEntregaJpaRepositorio jpaRepositorio;
	private final IRutaEntregaJpaMapper entityMapper;

	// constructor

	public RutaEntregaRepositorioImpl(IRutaEntregaJpaRepositorio jpaRepositorio, IRutaEntregaJpaMapper entityMapper) {

		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	public RutaEntrega guardar(RutaEntrega ruta) {

		if (ruta.getId_zona_entrega() == null || ruta.getId_zona_entrega() <= 0) {
			throw new RuntimeException("id_zona_entrega es obligatorio y debe ser > 0");
		}

		RutaEntregaJpa entity = new RutaEntregaJpa();

		ZonaEntregaJpa zonaRef = em.getReference(ZonaEntregaJpa.class, ruta.getId_zona_entrega());
		entity.setZona_entrega(zonaRef);

		entity.setNombre_ruta(ruta.getNombre_ruta());
		entity.setDistancia_estimada_km(BigDecimal.valueOf(ruta.getDistancia_estimada_km()));
		entity.setTiempo_estimado_min(ruta.getTiempo_estimado_min());

		RutaEntregaJpa guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<RutaEntrega> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<RutaEntrega> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);

	}

	@Override
	public RutaEntrega actualizar(int id, RutaEntrega rutaEntrega) {

		RutaEntregaJpa entity = jpaRepositorio.findById(id)
				.orElseThrow(() -> new RuntimeException("Ruta de entrega no encontrada"));

		if (rutaEntrega.getId_zona_entrega() == null || rutaEntrega.getId_zona_entrega() <= 0) {
			throw new RuntimeException("id_zona_entrega es obligatorio y debe ser > 0");
		}

		ZonaEntregaJpa zonaRef = em.getReference(ZonaEntregaJpa.class, rutaEntrega.getId_zona_entrega());
		entity.setZona_entrega(zonaRef);

		entity.setNombre_ruta(rutaEntrega.getNombre_ruta());
		entity.setDistancia_estimada_km(BigDecimal.valueOf(rutaEntrega.getDistancia_estimada_km()));
		entity.setTiempo_estimado_min(rutaEntrega.getTiempo_estimado_min());

		RutaEntregaJpa guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

}
