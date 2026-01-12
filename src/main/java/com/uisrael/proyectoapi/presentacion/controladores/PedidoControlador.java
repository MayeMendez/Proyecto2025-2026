package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IPedidoCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.Pedido;
import com.uisrael.proyectoapi.presentacion.dto.request.PedidoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.PedidoResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IPedidoDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedido")
public class PedidoControlador {

	//dependencias de la arquitectura
	
	public final IPedidoCasoUso pedidoCasoUso; //casos de uso
	public final IPedidoDTOMapper mapper;//mapeadores
	
	//constructor
	public PedidoControlador(IPedidoCasoUso pedidoCasoUso, IPedidoDTOMapper mapper) {
		super();
		this.pedidoCasoUso = pedidoCasoUso;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<PedidoResponseDTO> listar(){
		return pedidoCasoUso.listar().stream().map(mapper::toResponseDTO).toList();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoResponseDTO crear(@Valid @RequestBody PedidoRequestDTO request) {
		return mapper.toResponseDTO(pedidoCasoUso.crear(mapper.toDomain(request)));
	}
	
	
	
}
