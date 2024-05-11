package com.example.backendbase2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class HolaMundo {

  @GetMapping("")
  public String saludar() {
    return "Hola Mundo";
  }

}
