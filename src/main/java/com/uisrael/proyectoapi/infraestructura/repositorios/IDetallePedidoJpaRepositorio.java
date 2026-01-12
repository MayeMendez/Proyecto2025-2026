package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.DetallePedidoJpa;

public interface IDetallePedidoJpaRepositorio extends JpaRepository<DetallePedidoJpa, Integer>{

}
