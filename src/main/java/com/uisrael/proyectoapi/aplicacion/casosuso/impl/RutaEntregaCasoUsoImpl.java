package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IRutaEntregaCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Repartidor;
import com.uisrael.proyectoapi.dominio.entidades.RutaEntrega;
import com.uisrael.proyectoapi.dominio.repositorios.IRutaEntregaRepositorio;

public class RutaEntregaCasoUsoImpl implements IRutaEntregaCasoUso{

	//dependencias
	
	private final IRutaEntregaRepositorio repositorio;
	
	//constructor
	public RutaEntregaCasoUsoImpl(IRutaEntregaRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	
	@Override
	public RutaEntrega crear(RutaEntrega rutaEntrega) {
		return repositorio.guardar(rutaEntrega);
	}



	@Override
	public RutaEntrega obtenerPorId(int id) {
		return repositorio.buscarPorId(id)
				.orElseThrow(() -> 
		new RuntimeException("Ruta de entrega no encontrado"));
	}

	@Override
	public List<RutaEntrega> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}


	@Override
	public RutaEntrega actualizar(int id, RutaEntrega rutaEntrega) {
	    obtenerPorId(id);                
	    return repositorio.actualizar(id, rutaEntrega); 
	}

}
