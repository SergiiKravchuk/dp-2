package com.example.dp2.shortener.service;

public interface UrlShortenerService {

  String shortenUrl(String url);
  String resolveUrl(String shortenUrlKey);
}
