package com.uisrael.proyectoapi.dominio.entidades;

public final class ZonaEntrega {

	private final int id_zona_entrega;
	private final String nombre_zona;
	private final String ciudad;
	private final String provincia;
	
	public ZonaEntrega(int id_zona_entrega, String nombre_zona, String ciudad, String provincia) {
		super();
		this.id_zona_entrega = id_zona_entrega;
		this.nombre_zona = nombre_zona;
		this.ciudad = ciudad;
		this.provincia = provincia;
	}

	public int getId_zona_entrega() {
		return id_zona_entrega;
	}

	public String getNombre_zona() {
		return nombre_zona;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	@Override
	public String toString() {
		return "ZonaEntrega [id_zona_entrega=" + id_zona_entrega + ", nombre_zona=" + nombre_zona + ", ciudad=" + ciudad
				+ ", provincia=" + provincia + "]";
	}

	
	
}
