package com.example.pruebacrudpro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 * Manejador global de excepciones para el API REST.
 * <p>
 * Utiliza {@link RestControllerAdvice} para interceptar excepciones en todos
 * los controladores
 * y devolver un objeto {@link ErrorResponse} con el código de estado HTTP
 * apropiado.
 * </p>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja excepciones de tipo {@link ResourceNotFoundException}.
     * 
     * @param ex La excepción capturada.
     * @return Respuesta con estado 404 (NOT_FOUND).
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(
                "Recurso no encontrado",
                ex.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Maneja errores de validación de campos (@Valid).
     * 
     * @param ex La excepción {@link MethodArgumentNotValidException}.
     * @return Respuesta con estado 400 (BAD_REQUEST) y detalles de los errores.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        String detalles = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorResponse error = new ErrorResponse(
                "Error de validación en los datos",
                detalles,
                LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Manejador genérico para cualquier otra excepción no controlada.
     * 
     * @param ex La excepción general.
     * @return Respuesta con estado 500 (INTERNAL_SERVER_ERROR).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex) {
        ErrorResponse error = new ErrorResponse(
                "Ocurrió un error inesperado",
                ex.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
