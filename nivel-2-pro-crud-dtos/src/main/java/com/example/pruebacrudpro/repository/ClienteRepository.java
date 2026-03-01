package com.example.pruebacrudpro.repository;

import com.example.pruebacrudpro.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad {@link Cliente}.
 * <p>
 * Proporciona métodos estándar para operaciones CRUD gracias a
 * {@link JpaRepository}.
 * </p>
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    /**
     * Busca un cliente por su correo electrónico.
     * 
     * @param email el email a buscar.
     * @return un Optional con el cliente si se encuentra.
     */
    java.util.Optional<Cliente> findByEmail(String email);
}
