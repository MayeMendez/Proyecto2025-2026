package com.uisrael.proyectoapi.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IRutaEntregaCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.RutaEntregaCasoUsoImpl;
import com.uisrael.proyectoapi.dominio.repositorios.IRutaEntregaRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.RutaEntregaRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IRutaEntregaJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IRutaEntregaJpaRepositorio;

@Configuration
public class RutaEntregaConfig {

	@Bean
	IRutaEntregaRepositorio rutaEntregaRepositorio(IRutaEntregaJpaRepositorio jpaRepositorio,IRutaEntregaJpaMapper mapper) {
		return new RutaEntregaRepositorioImpl(jpaRepositorio, mapper);
	
	}
	
	@Bean
	IRutaEntregaCasoUso rutaEntregaCasoUso(IRutaEntregaRepositorio repositorio) {
		return new RutaEntregaCasoUsoImpl(repositorio);
	}
	
	
}
