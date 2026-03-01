package com.example.pruebacrudpro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Record que representa los datos necesarios para crear o actualizar un
 * Cliente.
 * <p>
 * Se utiliza para validar la entrada del cliente antes de que llegue a la
 * lógica de negocio.
 * </p>
 * 
 * @param nombre   El nombre del cliente, no puede estar en blanco.
 * @param email    El correo electrónico, debe ser un formato válido y no nulo.
 * @param telefono El número de teléfono, opcional pero con longitud mínima.
 */
public record ClienteRequestDTO(
        @NotBlank(message = "El nombre es obligatorio") @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres") String nombre,

        @NotBlank(message = "El email es obligatorio") @Email(message = "El formato del email no es válido") String email,

        @Size(min = 7, max = 15, message = "El teléfono debe tener entre 7 y 15 dígitos") String telefono) {
}
