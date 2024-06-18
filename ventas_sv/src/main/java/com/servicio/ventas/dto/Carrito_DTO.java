package com.servicio.ventas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Carrito_DTO {
    private int id_carrillo;
    private double precio_total;
    private String[] lista_producto;
}
