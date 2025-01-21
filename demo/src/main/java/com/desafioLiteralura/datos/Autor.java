package com.desafioLiteralura.datos;

import com.desafioLiteralura.service.DatosAutor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreAutor;

    @Column(name = "birth_year")
    private Integer fechaDeNacimiento;

    @Column(name = "death_year")
    private Integer fechaFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Libro> libro = new ArrayList<>(); // Inicializa la lista aquí

    public Autor(DatosAutor datosAutor) {
        this.nombreAutor = datosAutor.nombreAutor();
        this.fechaDeNacimiento = datosAutor.fechaDeNacimiento()!= null ? datosAutor.fechaDeNacimiento() : 0;
        this.fechaFallecimiento = datosAutor.fechaFallecimiento()!= null ? datosAutor.fechaDeNacimiento() : 0;
    }

    public Autor() {
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

        @Override
   public String toString() {
        String fechaDeNacimientoNew = (fechaDeNacimiento != 0) ? String.valueOf(fechaDeNacimiento) : "Fecha no disponible";
        String fechaFallecimientoNew = (fechaFallecimiento != 0) ? String.valueOf(fechaFallecimiento) : "Aún vive";

        return "Autor: " + nombreAutor + "Nacido: " + fechaDeNacimientoNew + "Fallecido: " + fechaFallecimientoNew;

    }

}
