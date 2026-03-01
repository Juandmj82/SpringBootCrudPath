package com.juandidev.autoreslibros.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LibroRequestDTO(

                @NotBlank(message = "El título no puede estar vacío") String titulo,

                @NotBlank(message = "La categoría es obligatoria") String categoria,

                @NotNull(message = "El número de páginas no puede ser nulo") @Positive(message = "El número de páginas debe ser un número positivo") Integer paginas,

                @NotNull(message = "El ID del autor es obligatorio") Long autorId) {
}
