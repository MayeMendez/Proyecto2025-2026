package com.uisrael.proyectoapi.dominio.entidades;

public final class Repartidor {

	private final int id_repartidor;
	private final String nombres;
	private final String apellidos;
	private final String ci;
	private final String telefono;
	private final String email;
	private final String estado;
	
	public Repartidor(int id_repartidor, String nombres, String apellidos, String ci, String telefono, String email,
			String estado) {
		super();
		this.id_repartidor = id_repartidor;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.ci = ci;
		this.telefono = telefono;
		this.email = email;
		this.estado = estado;
	}

	public int getId_repartidor() {
		return id_repartidor;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getCi() {
		return ci;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Repartidor [id_repartidor=" + id_repartidor + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", ci=" + ci + ", telefono=" + telefono + ", email=" + email + ", estado=" + estado + "]";
	}

	
	
}
