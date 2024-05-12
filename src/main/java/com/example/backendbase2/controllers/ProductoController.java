package com.example.backendbase2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.backendbase2.models.ProductoModel;
import com.example.backendbase2.services.ProductoService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO Implementar SPEC
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

  @Autowired
  private ProductoService productoService;

  @GetMapping
  public List<ProductoModel> obtenerLista() {
    return productoService.obtenerLista();
  }
  
  // TODO Implementar otras validaciones
  @PostMapping
  public ResponseEntity<?> crearProducto(@Valid @RequestBody ProductoModel producto,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      Map<String, String> errors = new HashMap<>();
      bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    ProductoModel nuevoProducto = productoService.guardar(producto);
    return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
  }
}
