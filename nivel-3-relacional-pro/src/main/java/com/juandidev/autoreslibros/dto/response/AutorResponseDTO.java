package com.juandidev.autoreslibros.dto.response;


import java.util.List;

public record AutorResponseDTO(
        Long id,
        String nombre,
        String apellido,
        List<LibroResponseDTO> libros
) {
}
