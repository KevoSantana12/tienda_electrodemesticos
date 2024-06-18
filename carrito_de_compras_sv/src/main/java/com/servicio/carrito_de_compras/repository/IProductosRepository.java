package com.servicio.carrito_de_compras.repository;

import com.servicio.carrito_de_compras.dto.ProductosDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@FeignClient(name = "producto_serv")
public interface IProductosRepository {

    @GetMapping("/productos/get/all")
    public List<ProductosDTO> getProductos();
    @GetMapping("/productos/get/{id}")
    public ProductosDTO getProducto(@PathVariable int id);

}