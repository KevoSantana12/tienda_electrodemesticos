package com.servicio.carrito_de_compras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carrillo;
    private double precio_total;
    @ElementCollection(fetch = FetchType.EAGER)
    private String[] lista_producto;
}
