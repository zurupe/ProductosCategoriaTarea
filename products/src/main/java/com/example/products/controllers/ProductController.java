package com.example.products.controllers;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.products.models.entities.Product;
import com.example.products.services.IProductService;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/products")
public class ProductController {
private final IProductService productService;
public ProductController(IProductService productService) {
this.productService = productService;
}
@GetMapping
public List<Product> getAllProducts() {
return productService.getAllProducts();
}
@GetMapping("/{id}")
public ResponseEntity<?> getProductById(@PathVariable Long id) {
return
productService.getProductById(id).map(ResponseEntity::ok).
orElse(ResponseEntity.notFound().build());
}
@PostMapping
public ResponseEntity<?> createProduct(@Valid @RequestBody Product
product) {
return ResponseEntity.status(HttpStatus.CREATED)
.body(productService.createProduct(product));
}
@PutMapping("/{id}")
public ResponseEntity<Product> update(@PathVariable Long id, 
@Valid @RequestBody Product p) {
try {
return ResponseEntity.ok(productService.updateProduct(id, 
p));
} catch (RuntimeException e) {
return ResponseEntity.notFound().build();
}
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
productService.deleteProduct(id);
return ResponseEntity.noContent().build();
}
}
