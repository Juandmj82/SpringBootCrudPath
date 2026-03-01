package com.juandidev.autoreslibros.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.juandidev.autoreslibros.dto.request.LibroRequestDTO;
import com.juandidev.autoreslibros.dto.response.LibroResponseDTO;
import com.juandidev.autoreslibros.service.ILibroService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/libros")
@RequiredArgsConstructor
public class LibroController {

    private final ILibroService libroService;

    @GetMapping
    public List<LibroResponseDTO> listarLibros() {
        return libroService.listarLibros();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LibroResponseDTO crearLibro(@Valid @RequestBody LibroRequestDTO dto) {
        return libroService.crearLibro(dto);

    }

    @GetMapping("/{id}")
    public LibroResponseDTO buscarLibro(@PathVariable Long id) {
        return libroService.buscarLibro(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LibroResponseDTO actualizarLibro(@PathVariable Long id, @Valid @RequestBody LibroRequestDTO dto) {
        return libroService.actualizarLibro(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }

}
