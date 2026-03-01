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

import com.juandidev.autoreslibros.dto.request.AutorRequestDTO;
import com.juandidev.autoreslibros.dto.response.AutorResponseDTO;
import com.juandidev.autoreslibros.service.IAutorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/autores")
@RequiredArgsConstructor
public class AutorController {

    private final IAutorService autorService;

    @GetMapping
    public List<AutorResponseDTO> listarAutores() {
        return autorService.listarAutores();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutorResponseDTO crearAutor(@Valid @RequestBody AutorRequestDTO dto) {
        return autorService.crearAutor(dto);
    }

    @GetMapping("/{id}")
    AutorResponseDTO buscarAutor(@PathVariable Long id) {
        return autorService.buscarAutor(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AutorResponseDTO actualizarAutor(@PathVariable Long id, @Valid @RequestBody AutorRequestDTO dto) {
        return autorService.actualizarAutor(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarAutor(@PathVariable Long id) {
        autorService.eliminarAutor(id);
    }

}
