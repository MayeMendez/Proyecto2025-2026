package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ruta_entrega")
public class RutaEntregaJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ruta_entrega")
	private Integer id_ruta_entrega;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_zona_entrega", nullable = false)
	private ZonaEntregaJpa zona_entrega;

	@Column(name = "nombre_ruta", nullable = false, length = 100)
	private String nombre_ruta;

	@Column(name = "distancia_estimada_km", precision = 10, scale = 2)
	private BigDecimal distancia_estimada_km;

	@Column(name = "tiempo_estimado_min")
	private Integer tiempo_estimado_min;
}
