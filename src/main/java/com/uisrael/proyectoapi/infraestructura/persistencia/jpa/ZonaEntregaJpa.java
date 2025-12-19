package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "zona_entrega")
public class ZonaEntregaJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_zona_entrega")
	private Integer id_zona_entrega;

	@Column(name = "nombre_zona", nullable = false, length = 100)
	private String nombre_zona;

	@Column(name = "ciudad", nullable = false, length = 100)
	private String ciudad;

	@Column(name = "provincia", nullable = false, length = 100)
	private String provincia;
}
