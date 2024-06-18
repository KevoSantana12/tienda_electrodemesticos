package com.servicio.carrito_de_compras.repository;

import com.servicio.carrito_de_compras.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoRepository extends JpaRepository<Carrito, Integer> {
}
