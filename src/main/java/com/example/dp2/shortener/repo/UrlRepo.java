package com.example.dp2.shortener.repo;

import com.example.dp2.shortener.model.Url;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepo extends CrudRepository<Url, String> {
}
