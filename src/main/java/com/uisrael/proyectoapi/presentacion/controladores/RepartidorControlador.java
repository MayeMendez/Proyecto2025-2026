package com.uisrael.proyectoapi.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IRepartidorCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.RepartidorRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.RepartidorResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IRepartidorDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/repartidor")
public class RepartidorControlador {

	//dependencias de la arquitectura
	
	private final IRepartidorCasoUso repartidorCasoUso; //casos de uso
	private final IRepartidorDTOMapper mapper; //mapeadores
	
	//constructor
	public RepartidorControlador(IRepartidorCasoUso repartidoCasoUso, IRepartidorDTOMapper mapper) {
		this.repartidorCasoUso = repartidoCasoUso;
		this.mapper = mapper;
	}
	
	@GetMapping
	public List<RepartidorResponseDTO> listar(){
		return repartidorCasoUso.listar().stream().map(mapper::toResponseDTO).toList();
	}
	
    @GetMapping("/{id}")
    public RepartidorResponseDTO obtenerPorId(@PathVariable int id) {
        return mapper.toResponseDTO(repartidorCasoUso.obtenerPorId(id));
    }
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RepartidorResponseDTO crear(@Valid @RequestBody RepartidorRequestDTO request) {
		return mapper.toResponseDTO(repartidorCasoUso.crear(mapper.toDomain(request)));
	}
	
    @PutMapping("/{id}")
    public RepartidorResponseDTO actualizar(
            @PathVariable int id,
            @Valid @RequestBody RepartidorRequestDTO request) {

        return mapper.toResponseDTO(repartidorCasoUso.actualizar(id, mapper.toDomain(request)));
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {
        repartidorCasoUso.eliminar(id);
    }
	
}
