package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RutaEntregaRequestDTO {

	//private int id_ruta_entrega;
	//private int id_zona_entrega;
	@NotBlank
	private String nombre_ruta;
	@NotBlank
	private double distancia_estimada_km;
	@NotBlank
	private int tiempo_estimado_min;
	
}
