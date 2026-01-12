package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RepartidorRequestDTO {

	//private int id_repartidor;
	@NotBlank
	private String nombres;
	@NotBlank
	private String apellidos;
	@NotBlank
	private String ci;
	@NotBlank
	private String telefono;
	@NotBlank
	private String email;
	@NotBlank
	private String estado;
	
}
