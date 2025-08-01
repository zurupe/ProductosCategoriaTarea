package com.example.categoria.services;

import java.util.List;
import java.util.Optional;

import com.example.categoria.models.entities.Categoria;

public interface ICategoriaService {
    List<Categoria> getAllCategorias();
    Optional<Categoria> getCategoriaById(Long id);
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Long id, Categoria categoria);
    void deleteCategoria(Long id);
    
}
