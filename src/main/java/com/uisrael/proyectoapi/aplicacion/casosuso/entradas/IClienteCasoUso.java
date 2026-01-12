package com.uisrael.proyectoapi.aplicacion.casosuso.entradas;

import java.util.List;

import com.uisrael.proyectoapi.dominio.entidades.Cliente;

public interface IClienteCasoUso {

	Cliente crear(Cliente cliente);
	Cliente obtenerPorId(int id);
	List<Cliente> listar();
	void eliminar(int id);
	
}
