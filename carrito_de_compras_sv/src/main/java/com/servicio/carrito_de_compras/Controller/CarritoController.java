package com.servicio.carrito_de_compras.Controller;

import com.servicio.carrito_de_compras.dto.Carrito_DTO;
import com.servicio.carrito_de_compras.services.CarritoService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@Controller
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

}
