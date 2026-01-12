package com.uisrael.proyectoapi.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.proyectoapi.infraestructura.persistencia.jpa.PedidoJpa;

public interface IPedidoJpaRepositorio extends JpaRepository<PedidoJpa, Integer> {

}
