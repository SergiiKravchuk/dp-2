package com.example.dp2.shortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
public class Url {

  @Id
  private String urlKey;

  private String baseUrl;

  public Url(String urlKey, String baseUrl) {
    this.urlKey = urlKey;
    this.baseUrl = baseUrl;
  }

  public Url() {
  }

  public String getUrlKey() {
    return urlKey;
  }

  public String getBaseUrl() {
    return baseUrl;
  }
}
