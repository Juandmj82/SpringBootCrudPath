package com.juandidev.autoreslibros.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String titulo;

    @Column (nullable = false)
    private String categoria;

    @Column (nullable = false)
    private Integer  paginas;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;



}
