package com.uisrael.proyectoapi.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IProductoCasoUso;
import com.uisrael.proyectoapi.aplicacion.casosuso.impl.ProductoCasoUsoImpl;
import com.uisrael.proyectoapi.dominio.repositorios.IProductoRepositorio;
import com.uisrael.proyectoapi.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.uisrael.proyectoapi.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.uisrael.proyectoapi.infraestructura.repositorios.IProductoJpaRepositorio;

@Configuration
public class ProductoConfig {

	@Bean
	IProductoRepositorio productoRepositorio(IProductoJpaRepositorio jpaRepositorio,IProductoJpaMapper mapper) {
		return new ProductoRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IProductoCasoUso productoCasoUso(IProductoRepositorio repositorio) {
		return new ProductoCasoUsoImpl(repositorio);
	}
	
	
}
