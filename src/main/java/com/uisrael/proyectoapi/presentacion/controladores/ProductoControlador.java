package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
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
		this.productoCasoUso = productoCasoUso;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<ProductoResponseDTO> listar(){
		return productoCasoUso.listar().stream().map(mapper::toResponseDTO).toList();
	}
	
	
	 @GetMapping("/{id}")
	 public ProductoResponseDTO obtenerPorId(@PathVariable int id) {
	        return mapper.toResponseDTO(productoCasoUso.obtenerPorId(id));
	 }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoResponseDTO crear(@Valid @RequestBody ProductoRequestDTO request) {
		return mapper.toResponseDTO(productoCasoUso.crear(mapper.toDomain(request)));
	}
	
	@PutMapping("/{id}")
    public ProductoResponseDTO actualizar(
            @PathVariable int id,
            @Valid @RequestBody ProductoRequestDTO request) {

        return mapper.toResponseDTO(productoCasoUso.actualizar(id, mapper.toDomain(request)));
    }

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
	    try {
	        productoCasoUso.eliminar(id);
	        return ResponseEntity.noContent().build();
	    } catch (DataIntegrityViolationException e) {
	        return ResponseEntity
	                .status(HttpStatus.CONFLICT)
	                .body("No se puede eliminar el producto porque está asociado a pedidos.");
	    }
	}

	  
	
}
