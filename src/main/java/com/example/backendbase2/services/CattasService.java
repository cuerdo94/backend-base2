package com.example.backendbase2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CattasService {
  private final String baseUrl = "https://cataas.com";

  @Autowired
  private RestTemplate restTemplate;

  public String obtenerGatoRandom() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "application/json");
    HttpEntity<String> entity = new HttpEntity<>(headers);
    String url = baseUrl + "/cat?json=true";
    return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

  }
}
