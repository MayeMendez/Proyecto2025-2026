package com.uisrael.proyectoapi.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IClienteCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.ClienteCasoUsoImpl;
import com.uisrael.proyectoapi.dominio.repositorios.IClienteRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.ClienteRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IClienteJpaRepositorio;

@Configuration
public class ClienteConfig {

	@Bean
	IClienteRepositorio clienteRepositorio(IClienteJpaRepositorio jpaRepositorio,IClienteJpaMapper mapper) {
		return new ClienteRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IClienteCasoUso clienteCasoUso(IClienteRepositorio repositorio) {
		return new ClienteCasoUsoImpl(repositorio);
	}
	
}
