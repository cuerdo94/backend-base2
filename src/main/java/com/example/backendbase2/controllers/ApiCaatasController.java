package com.example.backendbase2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendbase2.services.CattasService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
@Tag(name = "Prueba Random")
public class ApiCaatasController {

  @Autowired
  CattasService cattasService;

  @Operation(summary = "Gato Random service cattas")
  @GetMapping(value = "/random-gato")
  public ResponseEntity<byte[]> obtenerGatoRandom() {

    ResponseEntity<byte[]> responseEntity = cattasService.obtenerGatoRandom();
    if (responseEntity.getStatusCode().is2xxSuccessful()) {
      try {
        return responseEntity;
      } catch (Exception e) {
      }
    }
    return ResponseEntity.notFound().build();

  }

}
