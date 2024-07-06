package com.gersonhdz.literalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gersonhdz.literalura.models.Autor;
import com.gersonhdz.literalura.principal.Principal;
import com.gersonhdz.literalura.repository.AutorRepository;
import com.gersonhdz.literalura.repository.LibroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroRepository,autorRepository);
		principal.menu();
	}
}
