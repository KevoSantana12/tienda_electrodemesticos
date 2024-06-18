package com.servicio.carrito_de_compras.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductosDTO {
    private int id_producto;
    private String nombre;
    private double precio;
}
