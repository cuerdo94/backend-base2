package com.example.backendbase2.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.backendbase2.errors.exceptions.CustomException;
import com.example.backendbase2.helpers.CustomResponseHelp;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<Object> errorHttpsDogException(CustomException ex) {
    return CustomResponseHelp.dogRespuesta(ex.getErrorCode());
  }
}
