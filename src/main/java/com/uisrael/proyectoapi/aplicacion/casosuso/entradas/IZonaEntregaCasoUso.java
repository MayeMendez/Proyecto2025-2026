package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.ZonaEntrega;

public interface IZonaEntregaCasoUso {

	ZonaEntrega crear(ZonaEntrega zonantrega);
	ZonaEntrega obtenerPorId(int id);
	List<ZonaEntrega> listar();
	void eliminar(int id);
	
}
