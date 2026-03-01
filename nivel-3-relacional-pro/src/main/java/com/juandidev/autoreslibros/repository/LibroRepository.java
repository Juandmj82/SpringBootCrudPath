package com.juandidev.autoreslibros.repository;

import com.juandidev.autoreslibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
