package com.example.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.products.models.entities.Product;
@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {
    // This interface will automatically provide CRUD operations for Product entities
    // Additional query methods can be defined here if needed
}
