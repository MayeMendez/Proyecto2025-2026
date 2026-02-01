package com.uisrael.proyectoapi.presentacion.controladores;

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

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IDetallePedidoCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.DetallePedido;
import com.uisrael.proyectoapi.presentacion.dto.request.DetallePedidoRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.DetallePedidoResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IDetallePedidoDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detallePedido")
public class DetallePedidoControlador {

	private final IDetallePedidoCasoUso detallePedidoCasoUso;
	private final IDetallePedidoDTOMapper mapper;

	public DetallePedidoControlador(IDetallePedidoCasoUso detallePedidoCasoUso, IDetallePedidoDTOMapper mapper) {
		this.detallePedidoCasoUso = detallePedidoCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<DetallePedidoResponseDTO> listar() {
		return detallePedidoCasoUso.listar().stream().map(mapper::toResponseDTO).toList();
	}

	@GetMapping("/{id}")
	public DetallePedidoResponseDTO obtenerPorId(@PathVariable int id) {
		return mapper.toResponseDTO(detallePedidoCasoUso.obtenerPorId(id));
	}

	@PostMapping
	public ResponseEntity<DetallePedido> crear(@RequestBody DetallePedidoRequestDTO dto) {

		DetallePedido det = new DetallePedido(null, dto.getId_pedido(), dto.getId_producto(), dto.getCantidad(),
				dto.getPrecio_unitario(), dto.getSubtotal());

		return ResponseEntity.ok(detallePedidoCasoUso.crear(det));
	}

	@PutMapping("/{id}")
	public DetallePedidoResponseDTO actualizar(@PathVariable int id,
			@Valid @RequestBody DetallePedidoRequestDTO request) {
		return mapper.toResponseDTO(detallePedidoCasoUso.actualizar(id, mapper.toDomain(request)));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable int id) {
		detallePedidoCasoUso.eliminar(id);
	}
}
