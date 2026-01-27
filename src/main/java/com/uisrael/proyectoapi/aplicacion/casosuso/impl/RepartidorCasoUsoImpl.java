package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IRepartidorCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.DetallePedido;
import com.uisrael.proyectoapi.dominio.entidades.Repartidor;
import com.uisrael.proyectoapi.dominio.repositorios.IRepartidorRepositorio;

public class RepartidorCasoUsoImpl implements IRepartidorCasoUso{

	//dependencias
	
	private final IRepartidorRepositorio repositorio;
	
	//constructor
	
	public RepartidorCasoUsoImpl(IRepartidorRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	@Override
	public Repartidor crear(Repartidor repartidor) {
		return repositorio.guardar(repartidor);
	}


	@Override
	public Repartidor obtenerPorId(int id) {
		return repositorio.buscarPorId(id)
				.orElseThrow(() -> 
		new RuntimeException("Repartidor no encontrado"));
	}

	@Override
	public List<Repartidor> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}
	
	@Override
	public Repartidor actualizar(int id, Repartidor repartidor) {
	    obtenerPorId(id);                
	    return repositorio.actualizar(id, repartidor); 
	}


}
