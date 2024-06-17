package com.servicio.productos_sv.controller;
import com.servicio.productos_sv.dto.Producto_DTO;
import com.servicio.productos_sv.model.Producto;
import com.servicio.productos_sv.service.Producto_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    Producto_Service prodCRUD;
    @PostMapping("/save")
    public ResponseEntity<String> saveProducto(@RequestBody Producto_DTO productoDto){
        try {
            prodCRUD.saveProducto(productoDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Producto creado de manera exitosa");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable int id){
        try {
            prodCRUD.deleteProducto(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Problemas al eliminar el usuario");
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editProducto(@PathVariable int id, @RequestBody Producto_DTO productoEdit){
        try {
            prodCRUD.editProducto(productoEdit, id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Producto editado de manera exitosa");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al editar");
        }
    }

    @GetMapping("/get/{id}")
    public Producto getProducto(@PathVariable int id){
        try {
            return prodCRUD.getProducto(id);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/get/all")
    public List<Producto> getAll(){
        return prodCRUD.getProductos();
    }
}
