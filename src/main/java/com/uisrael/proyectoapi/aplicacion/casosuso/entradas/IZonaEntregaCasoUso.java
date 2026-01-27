package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.ZonaEntrega;

public interface IZonaEntregaCasoUso {

	ZonaEntrega crear(ZonaEntrega zonaEntrega);
	ZonaEntrega obtenerPorId(int id);
	List<ZonaEntrega> listar();
	ZonaEntrega actualizar(int id,ZonaEntrega zonaEntrega);
	void eliminar(int id);
	
}
