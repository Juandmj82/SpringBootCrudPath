package com.example.pruebacrudpro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa a un Cliente en la base de datos.
 * <p>
 * Se utilizan anotaciones de Lombok para reducir el código boilerplate.
 * Las validaciones de negocio se delegan al DTO para mantener esta clase
 * enfocada
 * únicamente en la persistencia.
 * </p>
 */
@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    /**
     * Identificador único del cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre completo del cliente.
     * Se marca como no nulo a nivel de base de datos.
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Correo electrónico único del cliente.
     * Se marca como único y no nulo a nivel de base de datos.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Número de teléfono del cliente.
     */
    private String telefono;
}
