package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class ProductoJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Integer id_producto;

	@Column(name = "nombre_producto", nullable = false, length = 150)
	private String nombre_producto;

	@Column(name = "categoria", nullable = false, length = 100)
	private String categoria;

	@Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
	private BigDecimal precio_unitario;

	@Column(name = "stock_actual", nullable = false)
	private Integer stock_actual;

	@Column(name = "unidad_medida", nullable = false, length = 20)
	private String unidad_medida;

	@Column(name = "activo", nullable = false)
	private Boolean activo;
}
