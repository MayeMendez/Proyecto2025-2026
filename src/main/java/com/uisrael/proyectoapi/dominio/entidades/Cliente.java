package com.uisrael.proyectoapi.dominio.entidades;

public final class Cliente {

	private final int id_cliente;
	private final String tipo_cliente;
	private final String razon_social;
	private final String nombre_comercial;
	private final String identificacion;
	private final String telefono;
	private final String email;
	private final String direccion;
	
	public Cliente(int id_cliente, String tipo_cliente, String razon_social, String nombre_comercial,
			String identificacion, String telefono, String email, String direccion) {
		super();
		this.id_cliente = id_cliente;
		this.tipo_cliente = tipo_cliente;
		this.razon_social = razon_social;
		this.nombre_comercial = nombre_comercial;
		this.identificacion = identificacion;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public String getTipo_cliente() {
		return tipo_cliente;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public String getNombre_comercial() {
		return nombre_comercial;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getDireccion() {
		return direccion;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", tipo_cliente=" + tipo_cliente + ", razon_social=" + razon_social
				+ ", nombre_comercial=" + nombre_comercial + ", identificacion=" + identificacion + ", telefono="
				+ telefono + ", email=" + email + ", direccion=" + direccion + "]";
	}

	
	
}
