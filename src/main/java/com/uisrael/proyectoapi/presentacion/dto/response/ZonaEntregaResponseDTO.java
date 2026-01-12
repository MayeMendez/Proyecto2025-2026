package com.uisrael.proyectoapi.presentacion.dto.response;

public class ZonaEntregaResponseDTO {

	private int id_zona_entrega;
	private String nombre_zona;
	private String ciudad;
	private String provincia;
	
	public int getId_zona_entrega() {
		return id_zona_entrega;
	}
	public void setId_zona_entrega(int id_zona_entrega) {
		this.id_zona_entrega = id_zona_entrega;
	}
	public String getNombre_zona() {
		return nombre_zona;
	}
	public void setNombre_zona(String nombre_zona) {
		this.nombre_zona = nombre_zona;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
}
