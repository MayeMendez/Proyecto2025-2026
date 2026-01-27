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

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IRutaEntregaCasoUso;
import com.uisrael.proyectoapi.dominio.entidades.RutaEntrega;
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
		this.rutaEntregaCasoUso = rutaEntregaCasoUso;
		this.mapper = mapper;
	}

	@GetMapping
	public List<RutaEntregaResponseDTO> listar(){
		return rutaEntregaCasoUso.listar().stream().map(mapper::toResponseDTO).toList();
	}
	
	
    @GetMapping("/{id}")
    public RutaEntregaResponseDTO obtenerPorId(@PathVariable int id) {
        return mapper.toResponseDTO(rutaEntregaCasoUso.obtenerPorId(id));
    }
    
    @PostMapping
    public ResponseEntity<RutaEntrega> crear(@RequestBody RutaEntregaRequestDTO dto) {

        RutaEntrega ruta = new RutaEntrega(
            null,
            dto.getId_zona_entrega(),
            dto.getNombre_ruta(),
            dto.getDistancia_estimada_km(),
            dto.getTiempo_estimado_min()
        );

        return ResponseEntity.ok(rutaEntregaCasoUso.crear(ruta));
    }
	
    @PutMapping("/{id}")
    public RutaEntregaResponseDTO actualizar(
            @PathVariable int id,
            @Valid @RequestBody RutaEntregaRequestDTO request) {

        return mapper.toResponseDTO(rutaEntregaCasoUso.actualizar(id, mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {
        rutaEntregaCasoUso.eliminar(id);
    }
	
}
