package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequestDTO {

	
	//private int id_cliente;
	@NotBlank
	private String tipo_cliente;
	@NotBlank
	private String razon_social;
	@NotBlank
	private String nombre_comercial;
	@NotBlank
	private String identificacion;
	@NotBlank
	private String telefono;
	@NotBlank
	private String email;
	@NotBlank
	private String direccion;
	
}
