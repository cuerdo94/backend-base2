package com.example.backendbase2.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendbase2.models.ProductoModel;
import com.example.backendbase2.repositories.ProductoRepository;

@Service
public class ProductoService {
  @Autowired
  ProductoRepository productoRepository;

  public Optional<ProductoModel> obtener(Long id) {
    return productoRepository.findById(id);
  }

  public ProductoModel guardar(ProductoModel producto) {
    return productoRepository.save(producto);
  }

  public ArrayList<ProductoModel> obtenerLista() {
    return (ArrayList<ProductoModel>) productoRepository.findAll();
  }

}
