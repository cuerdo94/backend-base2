package com.example.backendbase2.models.validations;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
  String message() default "Ya existe un registro con este valor";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
