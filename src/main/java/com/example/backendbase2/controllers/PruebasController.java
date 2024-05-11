package com.example.backendbase2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendbase2.services.CattasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class PruebasController {

  @Autowired
  CattasService cattasService;

  @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<String> test1() {
    return ResponseEntity.ok(cattasService.obtenerGatoRandom());
  }

}
