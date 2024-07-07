package com.gersonhdz.literalura.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gersonhdz.literalura.models.Autor;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    
    Optional<Autor> findByNombre(String nombre);
    List <Autor> findAll();

    @Query("SELECT a FROM Autor a WHERE :fecha BETWEEN a.fechaNacimiento AND COALESCE(a.fechaFallecimiento, :fecha)")
List<Autor> findAutoresByFecha(@Param("fecha") Integer fecha);

}
