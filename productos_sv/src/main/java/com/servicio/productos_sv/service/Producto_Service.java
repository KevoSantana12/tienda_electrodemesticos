package com.servicio.productos_sv.service;

import com.servicio.productos_sv.dto.Producto_DTO;
import com.servicio.productos_sv.model.Producto;
import com.servicio.productos_sv.repository.Producto_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Producto_Service implements IProducto_Service {
    @Autowired
    Producto_Repository prodCRUD;

    @Override
    public void saveProducto(Producto_DTO producto){
        Producto productoSav = new Producto();
        productoSav.setNombre(producto.getNombre());
        productoSav.setPrecio(producto.getPrecio());

        prodCRUD.save(productoSav);
    }

    @Override
    public void deleteProducto(int id) {
        prodCRUD.deleteById(id);
    }

    @Override
    public void editProducto(Producto_DTO producto, int id) {
        Producto product = this.getProducto(id);
        product.setNombre(producto.getNombre());
        product.setPrecio(producto.getPrecio());

        prodCRUD.save(product);
    }

    @Override
    public Producto getProducto(int id) {
        return prodCRUD.getReferenceById(id);
    }

    @Override
    public List<Producto> getProductos() {
        return prodCRUD.findAll();
    }
}
