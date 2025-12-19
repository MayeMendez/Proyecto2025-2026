package com.uisrael.proyectoapi.dominio.entidades;

public final class Pedido {

	private final int id_pedido;
	private final int id_cliente;
	private final int id_ruta_entrega;
	private final int id_repartidor;
	private final String fecha_pedido;
	private final String fecha_entrega_programada;
	private final String estado;
	private final String tipo_venta;
	private final double total_pedido;
	
	public Pedido(int id_pedido, int id_cliente, int id_ruta_entrega, int id_repartidor, String fecha_pedido,
			String fecha_entrega_programada, String estado, String tipo_venta, double total_pedido) {
		super();
		this.id_pedido = id_pedido;
		this.id_cliente = id_cliente;
		this.id_ruta_entrega = id_ruta_entrega;
		this.id_repartidor = id_repartidor;
		this.fecha_pedido = fecha_pedido;
		this.fecha_entrega_programada = fecha_entrega_programada;
		this.estado = estado;
		this.tipo_venta = tipo_venta;
		this.total_pedido = total_pedido;
	}
	public int getId_pedido() {
		return id_pedido;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public int getId_ruta_entrega() {
		return id_ruta_entrega;
	}
	public int getId_repartidor() {
		return id_repartidor;
	}
	public String getFecha_pedido() {
		return fecha_pedido;
	}
	public String getFecha_entrega_programada() {
		return fecha_entrega_programada;
	}
	public String getEstado() {
		return estado;
	}
	public String getTipo_venta() {
		return tipo_venta;
	}
	public double getTotal_pedido() {
		return total_pedido;
	}
	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", id_cliente=" + id_cliente + ", id_ruta_entrega=" + id_ruta_entrega
				+ ", id_repartidor=" + id_repartidor + ", fecha_pedido=" + fecha_pedido + ", fecha_entrega_programada="
				+ fecha_entrega_programada + ", estado=" + estado + ", tipo_venta=" + tipo_venta + ", total_pedido="
				+ total_pedido + "]";
	}


	
}
