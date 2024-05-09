package com.example.dp2.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HttpClientService {

  @Value("${external.client.url}")
  private String address;
  private final RestClient restClient;

  public HttpClientService() {
    this.restClient = RestClient.create();
  }

  public HttpStatusCode sendMessage(PersonMood personMood) {
    ResponseEntity<Void> bodilessEntity = restClient.post()
      .uri(address)
      .contentType(MediaType.APPLICATION_JSON)
      .body(personMood.person)
      .retrieve()
      .toBodilessEntity();

    return bodilessEntity.getStatusCode();
  }

  public record PersonMood(Person person, String mood) {}
  public record Person(String firstName, String lastName) {}
}
