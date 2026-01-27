package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IPedidoCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Pedido;
import com.uisrael.proyectoapi.dominio.repositorios.IPedidoRepositorio;

public class PedidoCasoUsoImpl implements IPedidoCasoUso{
	
	//dependencias
	
	private final IPedidoRepositorio repositorio;
	
	//constructor
	public PedidoCasoUsoImpl(IPedidoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	
	@Override
	public Pedido crear(Pedido pedido) {
		return repositorio.guardar(pedido);
	}



	@Override
	public Pedido obtenerPorId(int id) {
		return repositorio.buscarPorId(id)
				.orElseThrow(() -> 
		new RuntimeException("Pedido no encontrado"));
	}

	@Override
	public List<Pedido> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}


	@Override
	public Pedido actualizar(int id, Pedido pedido) {
	    obtenerPorId(id);                
	    return repositorio.actualizar(id, pedido); 
	}


}
