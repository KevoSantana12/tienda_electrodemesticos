package com.servicio.carrito_de_compras.services;

import com.servicio.carrito_de_compras.dto.Carrito_DTO;
import com.servicio.carrito_de_compras.model.Carrito;

import java.util.List;

public interface ICarritoService {
    public void save(Carrito_DTO carrito_dto);
    public void delete(int id);
    public void edit(Carrito_DTO carrito, int id);
    public List<Carrito> getAll();
    public Carrito getCarrito(int id);
    public void fallbackMethod(Carrito_DTO carrito_dto, Throwable throwable);
}
