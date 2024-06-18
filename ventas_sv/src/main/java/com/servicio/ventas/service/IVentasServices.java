package com.servicio.ventas.service;

import com.servicio.ventas.dto.Ventas_DTO;
import com.servicio.ventas.model.Venta;
import java.util.List;

public interface IVentasServices {
    public void save(Ventas_DTO ventas_dto);
    public void edit(Ventas_DTO ventas_dto, int id);
    public void delete(int id);
    public Venta getVenta(int id);
    public List<Venta> getAll();
    public void fallbackMethod(Ventas_DTO ventas_dto, Throwable throwable);
}
