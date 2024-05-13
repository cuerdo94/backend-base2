package com.example.backendbase2.helpers;

import java.util.HashMap;
import java.util.Map;
// import java.util.Optional;

public class ResponseApiHelper {

  static public Map<String, Object> mapRespuesta(Integer codigo, String mensaje, Object body) {
    Map<String, Object> errors = new HashMap<>();
    errors.put("codigo", codigo);
    errors.put("mensaje", mensaje);
    errors.put("body", body);
    return errors;
  }
}
