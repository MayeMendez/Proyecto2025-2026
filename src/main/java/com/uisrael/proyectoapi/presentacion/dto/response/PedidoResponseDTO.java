package com.uisrael.proyectoapi.presentacion.dto.response;

public class PedidoResponseDTO {

	private int id_pedido;
	private int id_cliente;
	private int id_ruta_entrega;
	private int id_repartidor;
	private String fecha_pedido;
	private String fecha_entrega_programada;
	private String estado;
	private String tipo_venta;
	private double total_pedido;

	
	private Integer id_detalle_pedido;

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_ruta_entrega() {
		return id_ruta_entrega;
	}

	public void setId_ruta_entrega(int id_ruta_entrega) {
		this.id_ruta_entrega = id_ruta_entrega;
	}

	public int getId_repartidor() {
		return id_repartidor;
	}

	public void setId_repartidor(int id_repartidor) {
		this.id_repartidor = id_repartidor;
	}

	public String getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(String fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public String getFecha_entrega_programada() {
		return fecha_entrega_programada;
	}

	public void setFecha_entrega_programada(String fecha_entrega_programada) {
		this.fecha_entrega_programada = fecha_entrega_programada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo_venta() {
		return tipo_venta;
	}

	public void setTipo_venta(String tipo_venta) {
		this.tipo_venta = tipo_venta;
	}

	public double getTotal_pedido() {
		return total_pedido;
	}

	public void setTotal_pedido(double total_pedido) {
		this.total_pedido = total_pedido;
	}

	
	public Integer getId_detalle_pedido() {
		return id_detalle_pedido;
	}

	public void setId_detalle_pedido(Integer id_detalle_pedido) {
		this.id_detalle_pedido = id_detalle_pedido;
	}
}
