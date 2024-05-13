package com.example.backendbase2.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendbase2.errors.exceptions.CustomException;
import com.example.backendbase2.models.ProductoModel;
import com.example.backendbase2.repositories.ProductoRepository;

@Service
public class ProductoService {
  @Autowired
  ProductoRepository productoRepository;

  public Optional<ProductoModel> obtener(Long id) {
    return productoRepository.findById(id);
  }

  public ProductoModel crear(ProductoModel producto) {
    producto.setId(null);
    return productoRepository.save(producto);
  }

  public ArrayList<ProductoModel> obtenerLista() {
    return (ArrayList<ProductoModel>) productoRepository.findAll();
  }

  public ProductoModel findById(Long id) throws CustomException {
    Optional<ProductoModel> producto = productoRepository.findById(id);
    if (producto.isEmpty()) {
      throw new CustomException("Producto no encontrado", 404);
    }
    return producto.get();
  }

  public ProductoModel actualizar(Long id, ProductoModel actualizacion) {

    ProductoModel producto = findById(id);

    if (actualizacion.getNombre() != null) {
      producto.setNombre(actualizacion.getNombre());
    }
    if (actualizacion.getDescripcion() != null) {
      producto.setDescripcion(actualizacion.getDescripcion());
    }
    if (actualizacion.getSku() != null) {
      producto.setSku(actualizacion.getSku());
    }
    if (actualizacion.getCodigoBarra() != null) {
      producto.setCodigoBarra(actualizacion.getCodigoBarra());
    }
    if (actualizacion.getMarca() != null) {
      producto.setMarca(actualizacion.getMarca());
    }
    if (actualizacion.getAlto() != 0.0) {
      producto.setAlto(actualizacion.getAlto());
    }
    if (actualizacion.getAncho() != 0.0) {
      producto.setAncho(actualizacion.getAncho());
    }
    if (actualizacion.getLargo() != 0.0) {
      producto.setLargo(actualizacion.getLargo());
    }
    if (actualizacion.getProfundidad() != 0.0) {
      producto.setProfundidad(actualizacion.getProfundidad());
    }
    if (actualizacion.getPeso() != 0.0) {
      producto.setPeso(actualizacion.getPeso());
    }
    if (actualizacion.getTipoMedida() != null) {
      producto.setTipoMedida(actualizacion.getTipoMedida());
    }
    if (actualizacion.getVolumenMts3() != 0.0) {
      producto.setVolumenMts3(actualizacion.getVolumenMts3());
    }

    return productoRepository.save(producto);
  }

  public void eliminar(long id) {
    ProductoModel producto = findById(id);
    productoRepository.delete(producto);
    throw new CustomException("Eliminado con exito", 200);
  }

  public boolean existeCodigoBarra(String codigoBarra) {
    return productoRepository.existsByCodigoBarra(codigoBarra);
  }

}
