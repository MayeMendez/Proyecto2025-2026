package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IRutaEntregaCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.RutaEntregaRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.RutaEntregaResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IRutaEntregaDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/rutaEntrega")
public class RutaEntregaControlador {

	//dependencias de la arquitectura
	
	private final IRutaEntregaCasoUso rutaEntregaCasoUso; //casos de uso
	private final IRutaEntregaDTOMapper mapper; //mapeadores
	
	//constructor
	public RutaEntregaControlador(IRutaEntregaCasoUso rutaEntregaCasoUso, IRutaEntregaDTOMapper mapper) {
		super();
		this.rutaEntregaCasoUso = rutaEntregaCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<RutaEntregaResponseDTO> listar(){
		return rutaEntregaCasoUso.listar().stream().map(mapper::toResponseDTO).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RutaEntregaResponseDTO crear(@Valid @RequestBody RutaEntregaRequestDTO request) {
		return mapper.toResponseDTO(rutaEntregaCasoUso.crear(mapper.toDomain(request)));
	}
	
	
}
