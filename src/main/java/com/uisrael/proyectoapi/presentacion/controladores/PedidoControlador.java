package com.uisrael.proyectoapi.presentacion.controladores;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	// dependencias de la arquitectura

	public final IPedidoCasoUso pedidoCasoUso; // casos de uso
	public final IPedidoDTOMapper mapper;// mapeadores

	// constructor
	public PedidoControlador(IPedidoCasoUso pedidoCasoUso, IPedidoDTOMapper mapper) {
		this.pedidoCasoUso = pedidoCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<PedidoResponseDTO> listar() {
		return pedidoCasoUso.listar().stream().map(mapper::toResponseDTO).toList();
	}

	@GetMapping("/{id}")
	public PedidoResponseDTO obtenerPorId(@PathVariable int id) {
		return mapper.toResponseDTO(pedidoCasoUso.obtenerPorId(id));
	}

	@PostMapping
	public ResponseEntity<Pedido> crear(@RequestBody PedidoRequestDTO dto) {

	    Pedido pedido = new Pedido(
	        null,
	        dto.getId_cliente(),
	        dto.getId_ruta_entrega(),
	        dto.getId_repartidor(),
	        LocalDateTime.parse(dto.getFecha_pedido()),
	        dto.getFecha_entrega_programada() != null ? LocalDate.parse(dto.getFecha_entrega_programada()) : null,
	        dto.getEstado(),
	        dto.getTipo_venta(),
	        dto.getTotal_pedido()
	    );

	    return ResponseEntity.ok(pedidoCasoUso.crear(pedido));
	}

	@PutMapping("/{id}")
	public PedidoResponseDTO actualizar(@PathVariable int id, @Valid @RequestBody PedidoRequestDTO request) {

		return mapper.toResponseDTO(pedidoCasoUso.actualizar(id, mapper.toDomain(request)));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable int id) {
		pedidoCasoUso.eliminar(id);
	}

}
