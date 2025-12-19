package com.uisrael.proyectoapi.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "pedido")
public class PedidoJpa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Integer id_pedido;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", nullable = false)
	private ClienteJpa cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ruta_entrega")
	private RutaEntregaJpa ruta_entrega;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_repartidor")
	private RepartidorJpa repartidor;

	@Column(name = "fecha_pedido", nullable = false)
	private LocalDateTime fecha_pedido;

	@Column(name = "fecha_entrega_programada")
	private LocalDate fecha_entrega_programada;

	@Column(name = "estado", nullable = false, length = 20)
	private String estado;

	@Column(name = "tipo_venta", nullable = false, length = 20)
	private String tipo_venta;

	@Column(name = "total_pedido", precision = 12, scale = 2)
	private BigDecimal total_pedido;

}
