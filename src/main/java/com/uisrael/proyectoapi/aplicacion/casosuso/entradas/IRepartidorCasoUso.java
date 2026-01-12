package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Repartidor;

public interface IRepartidorCasoUso {

	Repartidor crear(Repartidor repartidor);
	Repartidor obtenerPorId(int id);
	List<Repartidor> listar();
	void eliminar(int id);
	
}
