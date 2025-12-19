package com.uisrael.proyectoapi.dominio.entidades;

public final class DetallePedido {

	private final int id_detalle_pedido;
	private final int id_pedido;
	private final int id_producto;
	private final int cantidad;
	private final double precio_unitario;
	private final double subtotal;
	
	public DetallePedido(int id_detalle_pedido, int id_pedido, int id_producto, int cantidad, double precio_unitario,
			double subtotal) {
		super();
		this.id_detalle_pedido = id_detalle_pedido;
		this.id_pedido = id_pedido;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
		this.subtotal = subtotal;
	}
	public int getId_detalle_pedido() {
		return id_detalle_pedido;
	}
	public int getId_pedido() {
		return id_pedido;
	}
	public int getId_producto() {
		return id_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public double getPrecio_unitario() {
		return precio_unitario;
	}
	public double getSubtotal() {
		return subtotal;
	}
	@Override
	public String toString() {
		return "DetallePedido [id_detalle_pedido=" + id_detalle_pedido + ", id_pedido=" + id_pedido + ", id_producto="
				+ id_producto + ", cantidad=" + cantidad + ", precio_unitario=" + precio_unitario + ", subtotal="
				+ subtotal + "]";
	}


}
