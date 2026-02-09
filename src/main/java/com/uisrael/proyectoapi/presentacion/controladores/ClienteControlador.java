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

import com.uisrael.proyectoapi.aplicacion.casosuso.entradas.IClienteCasoUso;
import com.uisrael.proyectoapi.presentacion.dto.request.ClienteRequestDTO;
import com.uisrael.proyectoapi.presentacion.dto.response.ClienteResponseDTO;
import com.uisrael.proyectoapi.presentacion.mapeadores.IClienteDTOMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteControlador {

	//dependencias de la arquitectura
	
	private final IClienteCasoUso clienteCasoUso; //casos de uso
	private final IClienteDTOMapper mapper; //mapeadores
	
	//constructor
	public ClienteControlador(IClienteCasoUso clienteCasoUso, IClienteDTOMapper mapper) {
		this.clienteCasoUso = clienteCasoUso;
		this.mapper = mapper;
	}
	
	 //Listar
	@GetMapping
	public List<ClienteResponseDTO> listar(){
		return clienteCasoUso.listar().stream().map(mapper::toResponseDTO).toList();
	}
	
	 //Listar por ID
    @GetMapping("/{id}")
    public ClienteResponseDTO obtenerPorId(@PathVariable int id) {
        return mapper.toResponseDTO(clienteCasoUso.obtenerPorId(id));
    }
	
    //Crear 
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponseDTO crear(@Valid @RequestBody ClienteRequestDTO request) {
		return mapper.toResponseDTO(clienteCasoUso.crear(mapper.toDomain(request)));
	}
	
	//Actualizar 
	@PutMapping("/{id}")
    public ClienteResponseDTO actualizar(
            @PathVariable int id,
            @Valid @RequestBody ClienteRequestDTO request) {

        return mapper.toResponseDTO(
                clienteCasoUso.actualizar(id, mapper.toDomain(request))
        );
    }
	
	//Eliminar 
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id) {
        clienteCasoUso.eliminar(id);
    }
	
	//Existente consumidor final
	 @GetMapping("/existe/{identificacion}")
	    public ResponseEntity<Boolean> existe(@PathVariable String identificacion) {
	        return ResponseEntity.ok(
	                clienteCasoUso.existePorIdentificacion(identificacion)
	        );
	    }

}
