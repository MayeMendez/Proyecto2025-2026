package com.uisrael.proyectoapi.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.DetallePedidoJpa;

public interface IDetallePedidoJpaRepositorio extends JpaRepository<DetallePedidoJpa, Integer> {

	@Query(value = """
			SELECT *
			FROM detalle_pedido
			WHERE id_pedido = :idPedido
			ORDER BY id_detalle_pedido ASC
			LIMIT 1
			""", nativeQuery = true)
	Optional<DetallePedidoJpa> buscarPrimeroPorIdPedido(@Param("idPedido") Integer idPedido);
}
