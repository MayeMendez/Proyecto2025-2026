package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Producto;

public interface IProductoCasoUso {

	Producto crear(Producto producto);
	Producto obtenerPorId(int id);
	List<Producto> listar();
	void eliminar(int id);
	
}
