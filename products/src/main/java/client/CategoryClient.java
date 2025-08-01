package client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zurupe
 */

@FeignClient(name = "category", url = "c-app-categories:8003")
public interface CategoryClient{
    @GetMapping("/api/categories/{id}")
    CategoryDTO getCategory(@PathVariable("id") Long id);
}
