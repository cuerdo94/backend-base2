package com.example.backendbase2.helpers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class MapResponseHelper {

  public static ResponseEntity<?> errorMapeado(BindingResult bindingResult) {
    Map<String, String> errors = new HashMap<>();
    bindingResult.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

    return CustomResponseHelp.apiRespuesta(400, "Valide los campos",
        errors);

  }
}
