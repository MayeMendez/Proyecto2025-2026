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
@Table(name = "detalle_pedido")
public class DetallePedidoJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_pedido")
	private Integer id_detalle_pedido;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido", nullable = false)
	private PedidoJpa pedido;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto", nullable = false)
	private ProductoJpa producto;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
	private BigDecimal precio_unitario;

	@Column(name = "subtotal", nullable = false, precision = 12, scale = 2)
	private BigDecimal subtotal;
}
