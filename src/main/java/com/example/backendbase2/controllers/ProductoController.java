package com.example.backendbase2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.backendbase2.helpers.CustomResponseHelp;
import com.example.backendbase2.helpers.MapResponseHelper;
import com.example.backendbase2.models.ProductoModel;
import com.example.backendbase2.services.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Productos")
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

  @Autowired
  private ProductoService productoService;

  @Operation(summary = "Listar productos")
  @GetMapping
  public ResponseEntity<?> obtenerLista(@RequestParam(defaultValue = "0") int numeroPagina,
      @RequestParam(defaultValue = "10") int cantidadItems) {
    return CustomResponseHelp.apiRespuesta(200, "Producto",
        productoService.obtenerLista(numeroPagina,
            cantidadItems));
  }

  @Operation(summary = "Crear productos")
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

  @Operation(summary = "Obtener producto")
  @GetMapping("/{id}")
  public ResponseEntity<?> obtenerProductoId(@PathVariable Long id) {
    ProductoModel producto = productoService.findById(id);
    return CustomResponseHelp.apiRespuesta(200, "Producto",
        producto);
  }

  @Operation(summary = "Actualizar producto")
  @PutMapping("/{id}")
  public ResponseEntity<?> actualizarProducto(@PathVariable Long id,
      @Valid @RequestBody ProductoModel productoDetails,
      BindingResult bindingResult) {
    return CustomResponseHelp.apiRespuesta(200, "Actualización exitosa",
        productoService.actualizar(id, productoDetails));
  }

  @Operation(summary = "Eliminar producto")
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProducto(@PathVariable Long id) {
    productoService.eliminar(id);
    return CustomResponseHelp.dogRespuesta(200);
  }

  @Operation(summary = "Validar si existe código de barra")
  @GetMapping("/existe/{codigobarra}")
  public ResponseEntity<?> existe(@PathVariable String codigobarra) {
    return CustomResponseHelp.apiRespuesta(200, "Actualización exitosa",
        productoService.existeCodigoBarra(codigobarra));
  }

}
