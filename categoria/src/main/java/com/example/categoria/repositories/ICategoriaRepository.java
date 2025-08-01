package com.example.categoria.repositories;

import com.example.categoria.models.entities.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends CrudRepository<Categoria, Long>{

}
