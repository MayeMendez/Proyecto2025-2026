package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IZonaEntregaCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.RutaEntrega;
import com.uisrael.proyectoapi.dominio.entidades.ZonaEntrega;
import com.uisrael.proyectoapi.dominio.repositorios.IZonaEntregaRepositorio;

public class ZonaEntregaCasoUsoImpl implements IZonaEntregaCasoUso{
	
	//dependencias
	
	private final IZonaEntregaRepositorio repositorio;
	
	//constructor

	public ZonaEntregaCasoUsoImpl(IZonaEntregaRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	@Override
	public ZonaEntrega crear(ZonaEntrega zonantrega) {
		return repositorio.guardar(zonantrega);
	}


	@Override
	public ZonaEntrega obtenerPorId(int id) {
		return repositorio.buscarPorId(id)
				.orElseThrow(() -> 
		new RuntimeException("Zona no encontrada"));
	}

	@Override
	public List<ZonaEntrega> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}

	@Override
	public ZonaEntrega actualizar(int id, ZonaEntrega zonaEntrega) {
	    obtenerPorId(id);                
	    return repositorio.actualizar(id, zonaEntrega); 
	}

}
