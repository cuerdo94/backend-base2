package com.example.backendbase2.models.validations;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.backendbase2.services.ProductoService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String> {

  @Autowired
  private ProductoService productoService;

  @Override
  public void initialize(UniqueValue constraintAnnotation) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return !productoService.existeCodigoBarra(value);
  }
}
