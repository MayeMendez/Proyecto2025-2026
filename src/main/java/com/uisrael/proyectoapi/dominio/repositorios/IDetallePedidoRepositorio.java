package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.DetallePedido;

public interface IDetallePedidoRepositorio {

	DetallePedido guardar(DetallePedido detallePedido);
	Optional<DetallePedido> buscarPorId(int id);
	List<DetallePedido> listarTodos();
	void eliminar(int id);
}
