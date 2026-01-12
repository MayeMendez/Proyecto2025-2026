package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IProductoCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.ProductoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.ProductoResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IProductoDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/producto")
public class ProductoControlador {
	
	//dependencias de la arquitectura

	private final IProductoCasoUso productoCasoUso ;//casos de uso
	private final IProductoDTOMapper mapper ; //mapeadores
	
	//constructor
	public ProductoControlador(IProductoCasoUso productoCasoUso, IProductoDTOMapper mapper) {
		super();
		this.productoCasoUso = productoCasoUso;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<ProductoResponseDTO> listar(){
		return productoCasoUso.listar().stream().map(mapper::toResponseDTO).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoResponseDTO crear(@Valid @RequestBody ProductoRequestDTO request) {
		return mapper.toResponseDTO(productoCasoUso.crear(mapper.toDomain(request)));
	}
	
	
}
