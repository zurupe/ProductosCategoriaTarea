package com.example.categoria.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.categoria.models.entities.Categoria;
import com.example.categoria.repositories.ICategoriaRepository;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CategoriaServiceImpl implements ICategoriaService {
    
    private final ICategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(ICategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    
    
    
    
    @Override
    public List<Categoria> getAllCategorias() {
       return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> getCategoriaById(Long id) {
        return  categoriaRepository.findById(id);
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Long id, Categoria categoria) {
    if(!categoriaRepository.findById(id).isPresent()) {
        throw new IllegalArgumentException("Categoria with id " + id 
        + " does not exist.");
        }
        categoria.setId(id);
        return categoriaRepository.save(categoria);    
    }

    @Override
    public void deleteCategoria(Long id) {
        if(!categoriaRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("Categoria with id " + id 
            + " does not exist.");
            }
            categoriaRepository.deleteById(id);
    }

}
