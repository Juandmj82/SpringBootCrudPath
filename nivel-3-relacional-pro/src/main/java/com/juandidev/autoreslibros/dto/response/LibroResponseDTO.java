package com.juandidev.autoreslibros.dto.response;

public record LibroResponseDTO(
                Long id,
                String titulo,
                String categoria,
                Integer paginas,
                Long autorId) {
}
