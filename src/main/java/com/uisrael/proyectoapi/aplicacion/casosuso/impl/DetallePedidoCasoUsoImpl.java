package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IDetallePedidoCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.DetallePedido;
import com.uisrael.proyectoapi.dominio.repositorios.IDetallePedidoRepositorio;

public class DetallePedidoCasoUsoImpl implements IDetallePedidoCasoUso{

	//dependencias
	
	private final IDetallePedidoRepositorio repositorio;
	
	//constructor
	public DetallePedidoCasoUsoImpl(IDetallePedidoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}


	@Override
	public DetallePedido crear(DetallePedido detallePedido) {
		return repositorio.guardar(detallePedido);
	}


	@Override
	public DetallePedido obtenerPorId(int id) {
		return repositorio.buscarPorId(id)
				.orElseThrow(() -> 
		new RuntimeException("Detalle no encontrado"));
	}

	@Override
	public List<DetallePedido> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}

	
	
}
