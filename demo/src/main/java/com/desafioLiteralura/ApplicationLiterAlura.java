package com.desafioLiteralura;

import com.desafioLiteralura.principal.Principal;
import com.desafioLiteralura.repository.AutoresRepository;
import com.desafioLiteralura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationLiterAlura implements CommandLineRunner {

    @Autowired
    private LibroRepository repositorioLibro;
    @Autowired
    private AutoresRepository repositorioAutor;

    public static void main(String[] args) {
        // Inicia el contexto de Spring
        ApplicationContext context = SpringApplication.run(ApplicationLiterAlura.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        com.desafioLiteralura.principal.Principal principal = new com.desafioLiteralura.principal.Principal(repositorioAutor, repositorioLibro);
        principal.muestraElMenu();

        }
    }

