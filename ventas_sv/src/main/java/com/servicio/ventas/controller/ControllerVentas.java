package com.servicio.ventas.controller;

import com.servicio.ventas.dto.Ventas_DTO;
import com.servicio.ventas.model.Venta;
import com.servicio.ventas.service.VentasServices;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/ventas")
public class ControllerVentas {
    @Autowired
    VentasServices ventasCRUD;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Ventas_DTO ventas_dto){
        try {
            ventasCRUD.save(ventas_dto);
            return ResponseEntity.status(HttpStatus.SC_ACCEPTED).body("venta agregada");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body("Venta no agreda correctamente");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            ventasCRUD.delete(id);
            return ResponseEntity.status(HttpStatus.SC_ACCEPTED).body("venta eliminada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body("Venta no eliminada");
        }
    }

    @GetMapping("/get/{id}")
    public Venta getVenta(@PathVariable int id){
        return ventasCRUD.getVenta(id);
    }

    @GetMapping("/get/all")
    public List<Venta> getAll(){
        return ventasCRUD.getAll();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> edit(@RequestBody Ventas_DTO ventas_dto, @PathVariable int id){
        try {
            ventasCRUD.edit(ventas_dto, id);
            return ResponseEntity.status(HttpStatus.SC_ACCEPTED).body("Usuario Editado");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body("Error al editar el usuario");
        }
    }
}
