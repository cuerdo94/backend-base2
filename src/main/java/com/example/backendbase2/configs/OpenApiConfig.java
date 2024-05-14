package com.example.backendbase2.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Prueba Backend", version = " 1.0.0", description = "Prueba tècnica"))
public class OpenApiConfig {

}
