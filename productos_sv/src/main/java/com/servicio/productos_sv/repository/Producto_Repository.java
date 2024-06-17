package com.servicio.productos_sv.repository;

import com.servicio.productos_sv.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Producto_Repository extends JpaRepository<Producto, Integer> {
}
