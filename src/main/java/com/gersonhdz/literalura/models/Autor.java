package com.gersonhdz.literalura.models;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="autores")
public class  Autor {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaFallecimiento;
    @ManyToMany(mappedBy = "autores", fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(){}

    public Autor(DatosAutor datos) {
        this.nombre = datos.nombre();
        this.fechaNacimiento = datos.fechaNacimiento();
        this.fechaFallecimiento = datos.fechaFallecimiento();
        
    }
    
    @Override
    public String toString() {
        var nombreLibros = libros.stream().map(Libro::getTitulo).collect(Collectors.joining(", "));
        
    return 
    "|>-------AUTOR-------<|\n" +
    "  "+"Nombre: " + nombre + "\n" +
    "  "+"Fecha Nacimiento: " + fechaNacimiento + "\n" +
    "  "+"Fecha Fallecimiento: " + fechaFallecimiento + "\n" +
    "  "+"Libros: " + nombreLibros + "\n" +
    
    "|>-------------------<|" + "\n";
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }
    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    

}
