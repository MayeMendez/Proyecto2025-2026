package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RutaEntregaRequestDTO {

	@NotNull
	private Integer id_zona_entrega;


	@NotBlank
	private String nombre_ruta;


	@NotNull
	private Double distancia_estimada_km;


	@NotNull
	private Integer tiempo_estimado_min;
	
}
