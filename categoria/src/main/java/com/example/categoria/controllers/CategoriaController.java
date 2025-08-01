package com.example.categoria.controllers;
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
import com.example.categoria.models.entities.Categoria;
import com.example.categoria.services.ICategoriaService;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    private final ICategoriaService categoriaService;

    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    @GetMapping
    public List<Categoria> getAllCategorias(){
        return categoriaService.getAllCategorias();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<?> createCategoria(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.createCategoria(categoria));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @Valid @RequestBody Categoria c) {
        try {
            return ResponseEntity.ok(categoriaService.updateCategoria(id, c));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }

  }

