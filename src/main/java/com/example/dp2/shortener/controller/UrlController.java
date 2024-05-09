package com.example.dp2.shortener.controller;

import com.example.dp2.shortener.service.UrlShortenerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/shortUrl")
public class UrlController {

  private final UrlShortenerService urlShortenerService;

  public UrlController(UrlShortenerService urlShortenerService) {
    this.urlShortenerService = urlShortenerService;
  }


  @PostMapping()
  public ResponseEntity<String> shortenUrl(@RequestBody UrlRequest urlRequest) {
    String shortenUrlKey = urlShortenerService.shortenUrl(urlRequest.url());

    var result = ServletUriComponentsBuilder.fromCurrentRequest().path("/{shortenUrlKey}").buildAndExpand(shortenUrlKey).toUri();
    return ResponseEntity
      .created(result)
      .build();
  }


  @GetMapping("/{shortenUrlKey}")
  public ResponseEntity<String> getBaseUrl(@PathVariable String shortenUrlKey) {
    String baseUrl = urlShortenerService.resolveUrl(shortenUrlKey);

    return ResponseEntity
      .status(302)
      .header("Location", baseUrl)
      .build();
  }
}
