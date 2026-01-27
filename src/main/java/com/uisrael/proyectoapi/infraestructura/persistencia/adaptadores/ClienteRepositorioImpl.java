package com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Cliente;
import com.uisrael.proyectoapi.dominio.repositorios.IClienteRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.ClienteJpa;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IClienteJpaRepositorio;

public class ClienteRepositorioImpl implements IClienteRepositorio{

	//dependencias
	private final IClienteJpaRepositorio jpaRepositorio;
	private final IClienteJpaMapper entityMapper;
	
	//constructor
	public ClienteRepositorioImpl(IClienteJpaRepositorio jpaRepositorio, IClienteJpaMapper entityMapper) {
	
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}
	
	
	@Override
	public Cliente guardar(Cliente cliente) {
		ClienteJpa entity = entityMapper.toEntityCrear(cliente);
		ClienteJpa guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}


	@Override
	public Optional<Cliente> buscarPorId(int id) {
		return jpaRepositorio.findById(id).map(entityMapper::toDomain);
	}

	@Override
	public List<Cliente> listarTodos() {
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
	public Cliente actualizar(int id, Cliente cliente) {

	    ClienteJpa entity = jpaRepositorio.findById(id)
	        .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

	    entity.setTipo_cliente(cliente.getTipo_cliente());
	    entity.setRazon_social(cliente.getRazon_social());
	    entity.setNombre_comercial(cliente.getNombre_comercial());
	    entity.setTelefono(cliente.getTelefono());
	    entity.setEmail(cliente.getEmail());
	    entity.setDireccion(cliente.getDireccion());

	  
	    // entity.setIdentificacion(...); 

	    ClienteJpa guardado = jpaRepositorio.save(entity);
	    return entityMapper.toDomain(guardado);
	}

	

}
