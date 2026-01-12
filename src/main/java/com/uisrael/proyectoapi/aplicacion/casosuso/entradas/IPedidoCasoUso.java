package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Pedido;

public interface IPedidoCasoUso {

	Pedido crear(Pedido pedido);
	Pedido obtenerPorId(int id);
	List<Pedido> listar();
	void eliminar(int id);
}
