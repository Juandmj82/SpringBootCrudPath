package com.juandidev.autoreslibros.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AutorRequestDTO(

        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(min = 4, max = 20, message = "El nombre debe estar entre 4 y 20 caracteres")
        String nombre,

        @NotBlank(message = "El apellido no puede estar vacío")
        String apellido
) {
}
