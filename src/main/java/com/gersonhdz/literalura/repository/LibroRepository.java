package com.gersonhdz.literalura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gersonhdz.literalura.models.Libro;
import java.util.List;


public interface LibroRepository extends JpaRepository<Libro,Long> {
    
    Optional<Libro> findByTitulo(String titulo);
    List<Libro> findAll();

    @Query(value = "SELECT * FROM libros l WHERE :lang = ANY(l.idioma)", nativeQuery = true)
    List<Libro> findLibrosByIdioma(@Param("lang") String lang);
}
