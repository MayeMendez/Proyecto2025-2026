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
@Table(name = "repartidor")
public class RepartidorJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_repartidor")
	private Integer id_repartidor;

	@Column(name = "nombres", nullable = false, length = 100)
	private String nombres;

	@Column(name = "apellidos", nullable = false, length = 100)
	private String apellidos;

	@Column(name = "ci", nullable = false, unique = true, length = 20)
	private String ci;

	@Column(name = "telefono", length = 20)
	private String telefono;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "estado", length = 20)
	private String estado;

}
