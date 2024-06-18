package com.servicio.carrito_de_compras.Controller;

import com.servicio.carrito_de_compras.dto.Carrito_DTO;
import com.servicio.carrito_de_compras.model.Carrito;
import com.servicio.carrito_de_compras.services.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carrito")
public class CarritoController {
    @Autowired
    CarritoService carCRUD;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carrito_DTO carrito){
        try {
            carCRUD.save(carrito);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario creado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el usuario");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        try {
            carCRUD.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuario eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario");
        }
    }

    @GetMapping("/get/all")
    public List<Carrito> getAll(){
        try {
            return carCRUD.getAll();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/get/{id}")
    public Carrito getCarrito(@PathVariable int id){
        try {
            return carCRUD.getCarrito(id);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> edit(@PathVariable int id, @RequestBody Carrito_DTO carrito_dto){
        try {
            carCRUD.edit(carrito_dto, id);
            return ResponseEntity.status(HttpStatus.OK).body("Carrito editado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al editar el usuario");
        }
    }
}
