package com.example.backendbase2.helpers;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomResponseHelp {

  static public ResponseEntity<Object> dogRespuesta(int status) {

    RestTemplate restTemplate = new RestTemplate();
    String imageUrl = "https://http.dog/" + status + ".jpg";
    try {
      ResponseEntity<byte[]> responseEntity = restTemplate.exchange(imageUrl, HttpMethod.GET, null, byte[].class);

      if (responseEntity.getStatusCode().is2xxSuccessful()) {
        try {
          HttpHeaders headers = new HttpHeaders();
          headers.setContentType(MediaType.IMAGE_JPEG);
          return new ResponseEntity<>(responseEntity.getBody(), headers, HttpStatusCode.valueOf(status));
        } catch (Exception e) {
        }
      }
    } catch (Exception e) {
    }

    return ResponseEntity.notFound().build();
  }

  static public ResponseEntity<Object> apiRespuesta(int status, String mensaje, Object body) {
    return new ResponseEntity<>(ResponseApiHelper.mapRespuesta(status, mensaje, body), HttpStatusCode.valueOf(status));
  }

}
