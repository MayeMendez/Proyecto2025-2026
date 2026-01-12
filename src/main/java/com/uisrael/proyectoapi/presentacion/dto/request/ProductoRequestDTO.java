package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductoRequestDTO {

	
	//private int id_producto;
	@NotBlank
	private String nombre_producto;
	@NotBlank
	private String categoria;
	@NotBlank
	private double precio_unitario;
	@NotBlank
	private int stock_actual;
	@NotBlank
	private String unidad_medida;
	@NotBlank
	private boolean activo;
	
}
