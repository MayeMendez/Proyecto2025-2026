package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Repartidor;
import com.uisrael.proyectoapi.dominio.repositorios.IRepartidorRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.RepartidorJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IRepartidorJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IRepartidorJpaRepositorio;

public class RepartidorRepositorioImpl implements IRepartidorRepositorio {

	// dependencias

	private final IRepartidorJpaRepositorio jpaRepositorio;
	private final IRepartidorJpaMapper entityMapper;

	// constructor
	public RepartidorRepositorioImpl(IRepartidorJpaRepositorio jpaRepositorio, IRepartidorJpaMapper entityMapper) {

		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Repartidor guardar(Repartidor rep) {

	    RepartidorJpa entity = new RepartidorJpa();

	    entity.setNombres(rep.getNombres());
	    entity.setApellidos(rep.getApellidos());
	    entity.setCi(rep.getCi());
	    entity.setTelefono(rep.getTelefono());
	    entity.setEmail(rep.getEmail());
	    entity.setEstado(rep.getEstado());

	    RepartidorJpa guardado = jpaRepositorio.save(entity);
	    return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Repartidor> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Repartidor> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int id) {
		jpaRepositorio.deleteById(id);

	}

	@Override
	public Repartidor actualizar(int id, Repartidor repartidor) {

		RepartidorJpa entity = jpaRepositorio.findById(id)
				.orElseThrow(() -> new RuntimeException("Repartidor no encontrado"));

		entity.setNombres(repartidor.getNombres());
		entity.setApellidos(repartidor.getApellidos());
		entity.setTelefono(repartidor.getTelefono());
		entity.setEmail(repartidor.getEmail());
		entity.setEstado(repartidor.getEstado());

		// entity.setCi(...);

		RepartidorJpa guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

}
