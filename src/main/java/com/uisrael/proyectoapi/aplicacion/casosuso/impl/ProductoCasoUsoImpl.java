package com.uisrael.proyectoapi.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IProductoCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Producto;
import com.uisrael.proyectoapi.dominio.repositorios.IProductoRepositorio;

public class ProductoCasoUsoImpl implements IProductoCasoUso{

	//dependencias
	
	private final IProductoRepositorio repositorio;
	
	//constructor
	
	public ProductoCasoUsoImpl(IProductoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	@Override
	public Producto crear(Producto producto) {
		return repositorio.guardar(producto);
	}



	@Override
	public Producto obtenerPorId(int id) {
		return repositorio.buscarPorId(id)
				.orElseThrow(() -> 
		new RuntimeException("Producto no encontrado"));
	}

	@Override
	public List<Producto> listar() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
	}

}
