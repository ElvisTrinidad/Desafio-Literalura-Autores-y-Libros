package com.desafioLiteralura.repository;

import com.desafioLiteralura.datos.Autor;
import com.desafioLiteralura.datos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTituloIgnoreCase(String titulo);
    List<Libro> findByIdiomaContaining(String idiomas);
    List<Libro> findByAutor(Autor autor);
}

