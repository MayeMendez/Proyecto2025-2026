package com.uisrael.proyectoapi.dominio.entidades;

public final class RutaEntrega {

	private final int id_ruta_entrega;
	private final int id_zona_entrega;
	private final String nombre_ruta;
	private final double distancia_estimada_km;
	private final int tiempo_estimado_min;
	
	public RutaEntrega(int id_ruta_entrega, int id_zona_entrega, String nombre_ruta, double distancia_estimada_km,
			int tiempo_estimado_min) {
		super();
		this.id_ruta_entrega = id_ruta_entrega;
		this.id_zona_entrega = id_zona_entrega;
		this.nombre_ruta = nombre_ruta;
		this.distancia_estimada_km = distancia_estimada_km;
		this.tiempo_estimado_min = tiempo_estimado_min;
	}

	public int getId_ruta_entrega() {
		return id_ruta_entrega;
	}

	public int getId_zona_entrega() {
		return id_zona_entrega;
	}

	public String getNombre_ruta() {
		return nombre_ruta;
	}

	public double getDistancia_estimada_km() {
		return distancia_estimada_km;
	}

	public int getTiempo_estimado_min() {
		return tiempo_estimado_min;
	}

	@Override
	public String toString() {
		return "RutaEntrega [id_ruta_entrega=" + id_ruta_entrega + ", id_zona_entrega=" + id_zona_entrega
				+ ", nombre_ruta=" + nombre_ruta + ", distancia_estimada_km=" + distancia_estimada_km
				+ ", tiempo_estimado_min=" + tiempo_estimado_min + "]";
	}

	
	
}
