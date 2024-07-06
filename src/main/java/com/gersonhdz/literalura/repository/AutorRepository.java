package com.gersonhdz.literalura.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gersonhdz.literalura.models.Autor;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    
    Optional<Autor> findByNombre(String nombre);

}
