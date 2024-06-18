package com.servicio.ventas.repository;

import com.servicio.ventas.dto.Carrito_DTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
@FeignClient(name = "CARRITO-SERV")
@LoadBalancerClient(name = "CARRITO-SERV")
public interface ICarritoRepository {
    @GetMapping("/carrito/get/{id}")
    public Carrito_DTO getCarrito(@PathVariable int id);
}
