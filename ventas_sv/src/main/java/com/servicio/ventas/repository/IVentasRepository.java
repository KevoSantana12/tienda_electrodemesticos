package com.servicio.ventas.repository;

import com.servicio.ventas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentasRepository extends JpaRepository <Venta , Integer> {
}
