package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.RutaEntrega;

public interface IRutaEntregaRepositorio {

	RutaEntrega guardar(RutaEntrega rutaEntrega);
	Optional<RutaEntrega> buscarPorId(int id);
	List<RutaEntrega> listarTodos();
	void eliminar(int id);
}
