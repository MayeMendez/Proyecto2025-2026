package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Repartidor;

public interface IRepartidorRepositorio {

	Repartidor guardar(Repartidor repartidor);
	Optional<Repartidor> buscarPorId(int id);
	List<Repartidor> listarTodos();
	void eliminar(int id);
}
