package com.example.backendbase2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.backendbase2.helpers.CustomResponseHelp;
import com.example.backendbase2.helpers.MapResponseHelper;
import com.example.backendbase2.models.ProductoModel;
import com.example.backendbase2.services.ProductoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

  @Autowired
  private ProductoService productoService;

  @GetMapping
  public ResponseEntity<?> obtenerLista() {
    return CustomResponseHelp.apiRespuesta(200, "Producto",
        productoService.obtenerLista());
  }

  @PostMapping
  public ResponseEntity<?> crearProducto(@Valid @RequestBody ProductoModel producto,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return MapResponseHelper.errorMapeado(bindingResult);
    }

    ProductoModel nuevoProducto = productoService.crear(producto);
    return CustomResponseHelp.apiRespuesta(201, "Actualización exitosa",
        nuevoProducto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> obtenerProductoId(@PathVariable Long id) {
    ProductoModel producto = productoService.findById(id);
    return CustomResponseHelp.apiRespuesta(200, "Producto",
        producto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> actualizarProducto(@PathVariable Long id,
      @Valid @RequestBody ProductoModel productoDetails,
      BindingResult bindingResult) {
    return CustomResponseHelp.apiRespuesta(200, "Actualización exitosa",
        productoService.actualizar(id, productoDetails));
  }

  @DeleteMapping("/{id}")
  public void deleteProducto(@PathVariable Long id) {
    productoService.eliminar(id);
  }

  @GetMapping("/existe/{codigobarra}")
  public ResponseEntity<?> existe(@PathVariable String codigobarra) {
    return CustomResponseHelp.apiRespuesta(200, "Actualización exitosa",
        productoService.existeCodigoBarra(codigobarra));
  }

}
