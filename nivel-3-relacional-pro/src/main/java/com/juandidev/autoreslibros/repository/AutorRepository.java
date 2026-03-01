package com.juandidev.autoreslibros.repository;

import com.juandidev.autoreslibros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
