package com.servicio.productos_sv.service;

import com.servicio.productos_sv.dto.Producto_DTO;
import com.servicio.productos_sv.model.Producto;

import java.util.List;

public interface IProducto_Service {
    public void saveProducto(Producto_DTO producto);
    public void deleteProducto(int id);
    public void editProducto(Producto_DTO producto, int id);
    public Producto getProducto(int id);
    public List<Producto> getProductos();
}
