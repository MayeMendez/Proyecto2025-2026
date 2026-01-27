package com.uisrael.proyectoapi.presentacion.dto.request;
import lombok.Data;

@Data
public class DetallePedidoRequestDTO {

	private Integer id_pedido;
	private Integer id_producto;
	private Integer cantidad;
	private Double precio_unitario;
	private Double subtotal;
	
}
