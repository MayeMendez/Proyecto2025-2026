package com.uisrael.proyectoapi.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IRepartidorCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.RepartidorCasoUsoImpl;
import com.uisrael.proyectoapi.dominio.repositorios.IRepartidorRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.RepartidorRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IRepartidorJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IRepartidorJpaRepositorio;

@Configuration
public class RepartidorConfig {

	@Bean
	IRepartidorRepositorio repartidorRepositorio(IRepartidorJpaRepositorio jpaRepositorio,IRepartidorJpaMapper mapper) {
		return new RepartidorRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IRepartidorCasoUso repartidorCasoUso(IRepartidorRepositorio repositorio) {
		return new RepartidorCasoUsoImpl(repositorio);
	}
	
	
	
	
}
