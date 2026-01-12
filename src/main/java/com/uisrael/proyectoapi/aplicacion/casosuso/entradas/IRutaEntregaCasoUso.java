package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.RutaEntrega;

public interface IRutaEntregaCasoUso {

	RutaEntrega crear(RutaEntrega rutaEntrega);
	RutaEntrega obtenerPorId(int id);
	List<RutaEntrega> listar();
	void eliminar(int id);
	
}
