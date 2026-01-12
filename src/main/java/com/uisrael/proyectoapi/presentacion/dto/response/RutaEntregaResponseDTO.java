package com.uisrael.proyectoapi.presentacion.dto.response;

public class RutaEntregaResponseDTO {

	private int id_ruta_entrega;
	private int id_zona_entrega;
	private String nombre_ruta;
	private double distancia_estimada_km;
	private int tiempo_estimado_min;
	
	public int getId_ruta_entrega() {
		return id_ruta_entrega;
	}
	public void setId_ruta_entrega(int id_ruta_entrega) {
		this.id_ruta_entrega = id_ruta_entrega;
	}
	public int getId_zona_entrega() {
		return id_zona_entrega;
	}
	public void setId_zona_entrega(int id_zona_entrega) {
		this.id_zona_entrega = id_zona_entrega;
	}
	public String getNombre_ruta() {
		return nombre_ruta;
	}
	public void setNombre_ruta(String nombre_ruta) {
		this.nombre_ruta = nombre_ruta;
	}
	public double getDistancia_estimada_km() {
		return distancia_estimada_km;
	}
	public void setDistancia_estimada_km(double distancia_estimada_km) {
		this.distancia_estimada_km = distancia_estimada_km;
	}
	public int getTiempo_estimado_min() {
		return tiempo_estimado_min;
	}
	public void setTiempo_estimado_min(int tiempo_estimado_min) {
		this.tiempo_estimado_min = tiempo_estimado_min;
	}
	
	
}
