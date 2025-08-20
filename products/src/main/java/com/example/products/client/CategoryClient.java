package com.example.products.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-service", url = "${CATEGORIES_SERVICE_URL:http://localhost:8003}")
public interface CategoryClient {
    @GetMapping("/api/categoria")
    List<CategoryDTO> getAllCategories();

    @GetMapping("/api/categoria/{id}")
    CategoryDTO getCategoryById(@PathVariable("id") Long id);
}
