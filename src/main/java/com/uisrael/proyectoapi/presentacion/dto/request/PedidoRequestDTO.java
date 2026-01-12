package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PedidoRequestDTO {

	//private int id_pedido;
	//private int id_cliente;
	//private int id_ruta_entrega;
	//private int id_repartidor;
	@NotBlank
	private String fecha_pedido;
	@NotBlank
	private String fecha_entrega_programada;
	@NotBlank
	private String estado;
	@NotBlank
	private String tipo_venta;
	@NotBlank
	private double total_pedido;
	
	
	
}
