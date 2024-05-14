package com.example.backendbase2.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CattasService {
  private final String baseUrl = "https://cataas.com";

  @Autowired
  private RestTemplate restTemplate;

  public ResponseEntity<byte[]> obtenerGatoRandom() {

    String url = baseUrl + "/cat";
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Collections.singletonList(MediaType.IMAGE_JPEG));
    ResponseEntity<byte[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers),
        byte[].class);
    return responseEntity;

  }
}
