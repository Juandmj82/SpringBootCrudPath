package com.example.pruebacrudpro.exception;

import java.time.LocalDateTime;

/**
 * Record que representa la estructura estandarizada de las respuestas de error.
 * <p>
 * Se utiliza para devolver información clara al cliente cuando ocurre una
 * excepción.
 * </p>
 * 
 * @param mensaje  Un mensaje general sobre el error.
 * @param detalles Información adicional o específica sobre el error.
 * @param fecha    La fecha y hora en que ocurrió el error.
 */
public record ErrorResponse(String mensaje, String detalles, LocalDateTime fecha) {
}
