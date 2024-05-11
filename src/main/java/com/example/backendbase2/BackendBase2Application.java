package com.example.backendbase2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.backendbase2.configs.RestTemplateConfig;

@Import(RestTemplateConfig.class)
@SpringBootApplication
public class BackendBase2Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendBase2Application.class, args);
	}

}
