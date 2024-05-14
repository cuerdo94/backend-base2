package com.example.backendbase2.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.backendbase2.models.ProductoModel;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoModel, Long> {

  public abstract Boolean existsByCodigoBarra(String codigoBarra);

  public abstract Page<ProductoModel> findAll(Pageable pageable);

}
