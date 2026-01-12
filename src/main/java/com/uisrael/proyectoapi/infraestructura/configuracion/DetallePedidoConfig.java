package com.uisrael.proyectoapi.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IDetallePedidoCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.DetallePedidoCasoUsoImpl;
import com.uisrael.proyectoapi.dominio.repositorios.IDetallePedidoRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.DetallePedidoRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IDetallePedidoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IDetallePedidoJpaRepositorio;

@Configuration
public class DetallePedidoConfig {

	@Bean
	IDetallePedidoRepositorio detallePedidoRepositorio(IDetallePedidoJpaRepositorio jpaRepositorio,IDetallePedidoJpaMapper mapper) {
		return new DetallePedidoRepositorioImpl(jpaRepositorio, mapper);
		
	}
	
	@Bean
	IDetallePedidoCasoUso detallePedidoCasoUso(IDetallePedidoRepositorio repositorio) {
		return new DetallePedidoCasoUsoImpl(repositorio);
	}
	
	
}
