package com.uisrael.proyectoapi.dominio.entidades;

public final class Producto {

	private final int id_producto;
	private final String nombre_producto;
	private final String categoria;
	private final double precio_unitario;
	private final int stock_actual;
	private final String unidad_medida;
	private final boolean activo;
	
	public Producto(int id_producto, String nombre_producto, String categoria, double precio_unitario, int stock_actual, boolean activo) {
		this.id_producto = id_producto;
		this.nombre_producto = nombre_producto;
		this.categoria = categoria;
		this.precio_unitario = precio_unitario;
		this.stock_actual = stock_actual;
		this.unidad_medida ="FUNDA" ;
		this.activo = activo;
	}

	public int getId_producto() {
		return id_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public String getCategoria() {
		return categoria;
	}

	public double getPrecio_unitario() {
		return precio_unitario;
	}

	public int getStock_actual() {
		return stock_actual;
	}

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public boolean isActivo() {
		return activo;
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre_producto=" + nombre_producto + ", categoria="
				+ categoria + ", precio_unitario=" + precio_unitario + ", stock_actual=" + stock_actual
				+ ", unidad_medida=" + unidad_medida + ", activo=" + activo + "]";
	}
	
	 

	
}
