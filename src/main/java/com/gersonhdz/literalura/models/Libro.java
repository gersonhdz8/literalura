package com.gersonhdz.literalura.models;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)    
    private String titulo;    
    private List<String> idioma;
    private Integer descargas; 
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "libro_autor",
        joinColumns = @JoinColumn(name = "libro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )    
    private List<Autor> autores;

    

    

    public Libro(){}
    
    public Libro(DatosLibro datosLibro, List<Autor> datosAutor) {
        this.titulo = datosLibro.titulo();        
        this.idioma = datosLibro.idioma();
        this.descargas = datosLibro.descargas();
        this.autores= datosAutor;
    }
    @Override
    public String toString() {
        var nombreAutores = autores.stream().map(Autor::getNombre).collect(Collectors.joining(", "));
        var idiomas = idioma.stream().collect(Collectors.joining(", ")); 
    return
    "|>-------LIBRO-------<|        \n" +
    "  "+"Titulo: " + titulo + "\n" +
    "  "+"Idioma: " + idiomas + "\n" +
    "  "+"Descargas: " + descargas + "\n" + 
    "  "+"Autores: " + nombreAutores + "\n" +
    "|>-------------------<|" + "\n";

    }

    public Long getId() {
        return id;
    }    

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public List<String> getIdioma() {
        return idioma;
    }
    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }
    public Integer getDescargas() {
        return descargas;
    }
    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    public List<Autor> getAutor() {
        return autores;
    }

    public void setAutor(List<Autor> autor) {
        this.autores = autor;
    }

}
