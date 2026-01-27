package com.uisrael.proyectoapi.presentacion.dto.request;
import lombok.Data;

@Data
public class PedidoRequestDTO {

	private Integer id_cliente;
	private Integer id_ruta_entrega;
	private Integer id_repartidor; 
	private String fecha_pedido; 
	private String fecha_entrega_programada; 
	private String estado;
	private String tipo_venta;
	private Double total_pedido; 
}