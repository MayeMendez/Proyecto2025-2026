package com.uisrael.proyectoapi.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IPedidoCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.PedidoCasoUsoImpl;
import com.uisrael.proyectoapi.dominio.repositorios.IPedidoRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.PedidoRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IPedidoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IPedidoJpaRepositorio;

@Configuration
public class PedidoConfig {

	@Bean
	IPedidoRepositorio pedidoRepositorio(IPedidoJpaRepositorio jpaRepositorio,IPedidoJpaMapper mapper) {
		return new PedidoRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IPedidoCasoUso pedidoCasoUso(IPedidoRepositorio repositorio) {
		return new PedidoCasoUsoImpl(repositorio);
	}
	
}
