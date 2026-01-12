package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ZonaEntregaRequestDTO {

	//private int id_zona_entrega;
	@NotBlank
	private String nombre_zona;
	@NotBlank
	private String ciudad;
	@NotBlank
	private String provincia;
	
}
