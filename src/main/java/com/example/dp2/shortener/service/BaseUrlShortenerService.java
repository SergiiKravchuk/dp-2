package com.example.dp2.shortener.service;

import com.example.dp2.shortener.model.Url;
import com.example.dp2.shortener.repo.UrlRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class BaseUrlShortenerService implements UrlShortenerService {

  private final UrlRepo urlRepo;

  public BaseUrlShortenerService(UrlRepo urlRepo) {
    this.urlRepo = urlRepo;
  }

  @Override
  public String shortenUrl(String baseUrl) {
    String urlKey = RandomStringUtils.randomAlphanumeric(5);
    urlRepo.save(new Url(urlKey, baseUrl));
    return urlKey;
  }

  @Override
  public String resolveUrl(String shortenUrlKey) {
    return urlRepo.findById(shortenUrlKey).map(Url::getBaseUrl).orElseThrow();
  }


}
