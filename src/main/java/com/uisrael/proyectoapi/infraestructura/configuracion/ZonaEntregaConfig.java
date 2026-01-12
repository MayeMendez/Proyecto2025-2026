package com.uisrael.proyectoapi.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IZonaEntregaCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.ZonaEntregaCasoUsoImpl;
import com.uisrael.proyectoapi.dominio.repositorios.IZonaEntregaRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.ZonaEntregaRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IZonaEntregaJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IZonaEntregaJpaRepositorio;

@Configuration
public class ZonaEntregaConfig {

	@Bean
	IZonaEntregaRepositorio zonaEntregaRepositorio(IZonaEntregaJpaRepositorio jpaRepositorio,IZonaEntregaJpaMapper mapper) {
		return new ZonaEntregaRepositorioImpl(jpaRepositorio, mapper);
		
	}
	
	@Bean
	IZonaEntregaCasoUso zonaEntregaCasoUso(IZonaEntregaRepositorio repositorio) {
		return new ZonaEntregaCasoUsoImpl(repositorio);
	}
	
	
}
