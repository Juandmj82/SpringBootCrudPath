package com.example.pruebacrudpro.exception;

/**
 * Excepción personalizada para cuando un recurso no es encontrado.
 * <p>
 * Se lanza típicamente cuando se busca un registro por ID y no existe.
 * </p>
 */
public class ResourceNotFoundException extends RuntimeException {
    /**
     * @param message Mensaje que describe qué recurso no se encontró.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
