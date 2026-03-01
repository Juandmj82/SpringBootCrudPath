package com.example.pruebacrudpro.dto;

/**
 * Record que representa la información de un Cliente enviada hacia el cliente
 * API.
 * <p>
 * Este objeto incluye el identificador único y oculta campos sensibles
 * o internos de la base de datos si fuera necesario.
 * </p>
 * 
 * @param id       Identificador único del cliente.
 * @param nombre   Nombre completo del cliente.
 * @param email    Correo electrónico del cliente.
 * @param telefono Número de teléfono del cliente.
 */
public record ClienteResponseDTO(
        Long id,
        String nombre,
        String email,
        String telefono) {
}
