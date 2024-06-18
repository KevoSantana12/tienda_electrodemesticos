package com.servicio.carrito_de_compras.services;

import com.servicio.carrito_de_compras.dto.Carrito_DTO;
import com.servicio.carrito_de_compras.dto.ProductosDTO;
import com.servicio.carrito_de_compras.model.Carrito;
import com.servicio.carrito_de_compras.repository.ICarritoRepository;
import com.servicio.carrito_de_compras.repository.IProductosRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService implements ICarritoService{
    @Autowired
    ICarritoRepository carCRUD;

    @Autowired
    IProductosRepository prodCRUD;

    @CircuitBreaker(name = "Productos", fallbackMethod = "fallbackMethod")
    @Retry(name="Productos")
    @Override
    public void save(Carrito_DTO carrito_dto) {
        double precioTotal = 0;

        if (!carrito_dto.getIdProductos().isEmpty()) {
            String[] productos = new String[carrito_dto.getIdProductos().size()];

            for (int i = 0; i < carrito_dto.getIdProductos().size(); i++){
                ProductosDTO producto = prodCRUD.getProducto(carrito_dto.getIdProductos().get(i));

                if (producto != null){
                    productos[i] = producto.getNombre();
                    precioTotal += producto.getPrecio();
                }
            }

            Carrito carrito = new Carrito();
            carrito.setLista_producto(productos);
            carrito.setPrecio_total(precioTotal);

            carCRUD.save(carrito);
        }
    }

    @Override
    public void delete(int id) {
        carCRUD.deleteById(id);
    }

    @Override
    public void edit(Carrito_DTO carrito, int idCarrito){
        Carrito carritoEdit = this.getCarrito(idCarrito);

        if (!carrito.getIdProductos().isEmpty()) {
            String[] productos = new String[carrito.getIdProductos().size()];
            double precioTotal = 0;

            for (int i = 0; i < carrito.getIdProductos().size(); i++){
                ProductosDTO producto = prodCRUD.getProducto(carrito.getIdProductos().get(i));

                if (producto != null){
                    productos[i] = producto.getNombre();
                    precioTotal += producto.getPrecio();
                }
            }

            carritoEdit.setLista_producto(productos);
            carritoEdit.setPrecio_total(precioTotal);

            carCRUD.save(carritoEdit);
        }
    }

    @Override
    public List<Carrito> getAll(){
        return carCRUD.findAll();
    }
    @Override
    public Carrito getCarrito(int id){
        return carCRUD.findById(id).orElseThrow();
    }
    @Override
    public void fallbackMethod(Carrito_DTO carrito_dto, Throwable throwable){
        Carrito carrito = new Carrito();
        carrito.setLista_producto(null);
        carrito.setPrecio_total(0);
        carCRUD.save(carrito);
    }
}
