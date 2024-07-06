package com.gersonhdz.literalura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gersonhdz.literalura.models.Libro;
import java.util.List;


public interface LibroRepository extends JpaRepository<Libro,Long> {
    
    Optional<Libro> findByTitulo(String titulo);
    List<Libro> findAll();
}
