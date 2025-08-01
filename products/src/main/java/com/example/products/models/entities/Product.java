package com.example.products.models.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "products")
public class Product {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long id;
@NotBlank
private String name;
@NotBlank
private String description;
@NotNull
@DecimalMin(value = "0.01")
private Double price;

long categoryId;
public Product() {
}
public Product(String name, String description, Double price, long categoryId) {
this.name = name;
this.description = description;
this.price = price;
this.categoryId = categoryId;
}
//getter and setter methods
public Long getCategoryId() {
return categoryId;
}
public void setCategoryId(Long categoryId) {
this.categoryId = categoryId;
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getDescription() {
return description;
}
public void setDescription(String description) {
this.description = description;
}
public Double getPrice() {
return price;
}
public void setPrice(Double price) {
this.price = price;
}
}
