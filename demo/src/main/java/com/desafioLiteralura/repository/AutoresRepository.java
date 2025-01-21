package com.desafioLiteralura.repository;

import com.desafioLiteralura.datos.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AutoresRepository extends JpaRepository<Autor, Long> {
    Autor findBynombreAutorIgnoreCase(String nombreAutor);

    List<Autor> findByFechaDeNacimientoLessThanEqualAndFechaFallecimientoGreaterThanEqual(int anoInicial, int anoFinal);
}
