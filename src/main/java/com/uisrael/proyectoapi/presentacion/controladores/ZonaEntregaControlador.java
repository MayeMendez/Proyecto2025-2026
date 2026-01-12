package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IZonaEntregaCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.ZonaEntregaRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.ZonaEntregaResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IZonaEntregaDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/zonaEntrega")
public class ZonaEntregaControlador {
	
	//dependencias de la arquitectura
	
	private final IZonaEntregaCasoUso zonaEntregaCasoUso;//casos de uso
	private final IZonaEntregaDTOMapper mapper; //mapeadores
	
	//constructor
	public ZonaEntregaControlador(IZonaEntregaCasoUso zonaEntregaCasoUso, IZonaEntregaDTOMapper mapper) {
		super();
		this.zonaEntregaCasoUso = zonaEntregaCasoUso;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<ZonaEntregaResponseDTO> listar()
	{
		return zonaEntregaCasoUso.listar().stream().map(mapper::toResponseDTO).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ZonaEntregaResponseDTO crear(@Valid @RequestBody ZonaEntregaRequestDTO request ) {
		return mapper.toResponseDTO(zonaEntregaCasoUso.crear(mapper.toDomain(request)));
	}
	
	
}
