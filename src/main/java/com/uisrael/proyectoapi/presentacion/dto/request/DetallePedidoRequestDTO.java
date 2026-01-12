package com.uisrael.proyectoapi.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DetallePedidoRequestDTO {

	
	//private int id_detalle_pedido;
	//private int id_pedido;
	//private int id_producto;
	@NotBlank
	private int cantidad;
	@NotBlank
	private double precio_unitario;
	@NotBlank
	private double subtotal;
	
	
}
