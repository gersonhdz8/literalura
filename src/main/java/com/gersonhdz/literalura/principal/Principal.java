package com.gersonhdz.literalura.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.gersonhdz.literalura.models.Autor;
import com.gersonhdz.literalura.models.DatosAutor;
import com.gersonhdz.literalura.models.DatosLibro;
import com.gersonhdz.literalura.models.Libro;
import com.gersonhdz.literalura.repository.AutorRepository;
import com.gersonhdz.literalura.repository.LibroRepository;
import com.gersonhdz.literalura.services.ConexionApi;
import com.gersonhdz.literalura.services.ConvertirDatos;


public class Principal {

    private  Scanner teclado = new Scanner(System.in);
    private  ConexionApi api = new ConexionApi();
    private final String URL_BASE = "https://gutendex.com/books/";
    private final String URL_BASE_PAGE = "https://gutendex.com/books/?page=";
    private final String URL_BASE_WORD = "https://gutendex.com/books/?search=";
    private ConvertirDatos conversor = new ConvertirDatos();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;
    
    public Principal(LibroRepository libroRepository, AutorRepository autorRepository ) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void menu() {

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo 
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en determinado año
                    5 - Listar libros por idioma

                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;        
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }  
    }

    public DatosLibro getDatosLibro(){        
        
        System.out.println("Escribe el nombre del libro que deseas buscar: ");
        var tituloLibro = teclado.nextLine();
        JsonNode jsonResponse = api.obtenerDatos(URL_BASE_WORD + tituloLibro.replace(" ","+"));
        System.out.println();
        var result = jsonResponse.get("results").get(0);   
        DatosLibro datosBook = conversor.jsonToClass(result, DatosLibro.class);
        return datosBook;
    }
    

    public void buscarLibroPorTitulo(){

        DatosLibro datosLibro= getDatosLibro();
        List<Autor> autores = new ArrayList<>();

        datosLibro.autor().forEach(autor->{

            Optional <Autor> autorExistente = autorRepository.findByNombre(autor.nombre());
            Autor autorDB;
            if (autorExistente.isPresent()) {
                autorDB = autorExistente.get(); 
            }
            else{
                autorDB = new Autor(autor); 
                autorRepository.save(autorDB);              
            }
            autores.add(autorDB);         

        });

        Optional <Libro> libroExistente = libroRepository.findByTitulo(datosLibro.titulo());
        
        Libro libro;
        if (libroExistente.isPresent()) {
            libro = libroExistente.get();            
        }
        else{
            libro = new Libro(datosLibro,autores);
            
        }
        libroRepository.save(libro);
        
        System.out.println(libro);       

    }

    public void listarLibrosRegistrados(){

        System.out.println(libroRepository.findAll());
        
    } 

    public void listarAutoresRegistrados(){
        
    } 

    public void listarAutoresVivos(){
        
    } 

    public void listarLibrosPorIdioma(){
        
    } 

}
