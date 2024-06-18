package com.servicio.ventas.service;

import com.servicio.ventas.dto.Carrito_DTO;
import com.servicio.ventas.dto.Ventas_DTO;
import com.servicio.ventas.model.Venta;
import com.servicio.ventas.repository.ICarritoRepository;
import com.servicio.ventas.repository.IVentasRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServices implements IVentasServices {
    @Autowired
    ICarritoRepository carritoCRUD;
    @Autowired
    IVentasRepository ventasCRUD;

    @Override
    @CircuitBreaker(name = "CARRITO-SV", fallbackMethod = "fallbackMethod")
    public void save(Ventas_DTO ventas_dto) {
        if (ventas_dto != null){
            Carrito_DTO carrito = carritoCRUD.getCarrito(ventas_dto.getId_carrito());

            Venta venta = new Venta();
            venta.setVenta(carrito.getPrecio_total());
            venta.setFecha(ventas_dto.getFechaVenta());
            venta.setProductos(carrito.getLista_producto());

            ventasCRUD.save(venta);
        }
    }

    @Override
    public void edit(Ventas_DTO ventas_dto, int id) {
        if (ventas_dto != null){
            Carrito_DTO carrito = carritoCRUD.getCarrito(ventas_dto.getId_carrito());

            Venta venta = this.getVenta(id);

            venta.setVenta(carrito.getPrecio_total());
            venta.setFecha(ventas_dto.getFechaVenta());
            venta.setProductos(carrito.getLista_producto());

            ventasCRUD.save(venta);
        }
    }

    @Override
    public void delete(int id) {
        ventasCRUD.deleteById(id);
    }

    @Override
    public Venta getVenta(int id) {
        return ventasCRUD.findById(id).orElseThrow();
    }

    @Override
    public List<Venta> getAll() {
        return ventasCRUD.findAll();
    }
    @Override
    public void fallbackMethod(Ventas_DTO ventas_dto, Throwable throwable) {
        Venta venta = new Venta();
        venta.setFecha(null);
        venta.setProductos(null);
        venta.setVenta(0.0);
        ventasCRUD.save(venta);
    }
}
