package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.DetallePedido;

public interface IDetallePedidoCasoUso {

	DetallePedido crear(DetallePedido detallePedido);
	DetallePedido obtenerPorId(int id);
	DetallePedido actualizar(int id,DetallePedido detallePedido);
	List<DetallePedido> listar();
	void eliminar(int id);
	
}
