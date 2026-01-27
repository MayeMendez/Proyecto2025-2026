package com.uisrael.proyectoapi.dominio.repositorios;

import java.util.List;
import java.util.Optional;
import com.uisrael.proyectoapi.dominio.entidades.ZonaEntrega;

public interface IZonaEntregaRepositorio {

	ZonaEntrega guardar(ZonaEntrega zonaEntrega);
	Optional<ZonaEntrega> buscarPorId(int id);
	List<ZonaEntrega> listarTodos();
	ZonaEntrega actualizar(int id, ZonaEntrega zonaEntrega);
	void eliminar(int id);
}
