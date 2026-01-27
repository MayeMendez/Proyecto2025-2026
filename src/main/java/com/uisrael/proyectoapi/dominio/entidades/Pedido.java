package com.uisrael.proyectoapi.dominio.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class Pedido {

	private final Integer id_pedido;
	private final Integer id_cliente;
	private final Integer id_ruta_entrega;
	private final Integer id_repartidor;
	private final LocalDateTime fecha_pedido;
	private final LocalDate fecha_entrega_programada;
	private final String estado;
	private final String tipo_venta;
	private final Double total_pedido;
	public Integer getId_pedido() {
		return id_pedido;
	}
	public Integer getId_cliente() {
		return id_cliente;
	}
	public Integer getId_ruta_entrega() {
		return id_ruta_entrega;
	}
	public Integer getId_repartidor() {
		return id_repartidor;
	}
	public LocalDateTime getFecha_pedido() {
		return fecha_pedido;
	}
	public LocalDate getFecha_entrega_programada() {
		return fecha_entrega_programada;
	}
	public String getEstado() {
		return estado;
	}
	public String getTipo_venta() {
		return tipo_venta;
	}
	public Double getTotal_pedido() {
		return total_pedido;
	}
	public Pedido(Integer id_pedido, Integer id_cliente, Integer id_ruta_entrega, Integer id_repartidor,
			LocalDateTime fecha_pedido, LocalDate fecha_entrega_programada, String estado, String tipo_venta,
			Double total_pedido) {
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
	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", id_cliente=" + id_cliente + ", id_ruta_entrega=" + id_ruta_entrega
				+ ", id_repartidor=" + id_repartidor + ", fecha_pedido=" + fecha_pedido + ", fecha_entrega_programada="
				+ fecha_entrega_programada + ", estado=" + estado + ", tipo_venta=" + tipo_venta + ", total_pedido="
				+ total_pedido + "]";
	}
	
	
	
}
