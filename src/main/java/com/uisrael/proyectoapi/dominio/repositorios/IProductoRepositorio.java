package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.proyectoapi.dominio.entidades.Producto;

public interface IProductoRepositorio {

	Producto guardar(Producto producto);
	Optional<Producto> buscarPorId(int id);
	List<Producto> listarTodos();
	void eliminar(int id);
	Producto actualizar(int id, Producto producto);

}
