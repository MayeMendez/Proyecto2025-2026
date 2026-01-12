package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IDetallePedidoCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.DetallePedidoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.DetallePedidoResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IDetallePedidoDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detallePedido")
public class DetallePedidoControlador {
	
	//dependencias de la arquitectura
	
	private final IDetallePedidoCasoUso detallePedidoCasoUso;//casos de uso
	private final IDetallePedidoDTOMapper mapper; //mapeadores
	
	//constructor
	public DetallePedidoControlador(IDetallePedidoCasoUso detallePedidoCasoUso, IDetallePedidoDTOMapper mapper) {
		super();
		this.detallePedidoCasoUso = detallePedidoCasoUso;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<DetallePedidoResponseDTO> listar(){
		
		return detallePedidoCasoUso.listar().stream().map(mapper::toResponseDTO).toList();
		}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DetallePedidoResponseDTO crear(@Valid @RequestBody DetallePedidoRequestDTO request) {
		return mapper.toResponseDTO(detallePedidoCasoUso.crear(mapper.toDomain(request)));
	}
	
	
	

}
