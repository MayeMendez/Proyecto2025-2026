package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.beans.Transient;
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
@Table(name = "cliente")
public class ClienteJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer id_cliente;

	@Column(name = "tipo_cliente", nullable = false, length = 20)
	private String tipo_cliente;

	@Column(name = "razon_social", nullable = false, length = 150)
	private String razon_social;

	@Column(name = "nombre_comercial", length = 150)
	private String nombre_comercial;

	@Column(name = "identificacion", nullable = false, unique = true, updatable=false,length = 20)
	private String identificacion;

	@Column(name = "telefono", length = 20)
	private String telefono;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "direccion", nullable = false, length = 200)
	private String direccion;


}
