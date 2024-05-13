package com.example.backendbase2.models.validations;

import com.example.backendbase2.services.ProductoService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String>, ApplicationContextAware {

  private ProductoService productoService;

  @Override
  public void setApplicationContext(@SuppressWarnings("null") ApplicationContext applicationContext) {
    productoService = applicationContext.getBean(ProductoService.class);
  }

  @Override
  public void initialize(UniqueValue constraintAnnotation) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    if (productoService == null) {
      return true;
    }
    return !productoService.existeCodigoBarra(value);
  }
}
