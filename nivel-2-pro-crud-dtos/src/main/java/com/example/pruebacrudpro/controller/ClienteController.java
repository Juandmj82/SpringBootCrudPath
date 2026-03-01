package com.example.pruebacrudpro.controller;

import com.example.pruebacrudpro.dto.ClienteRequestDTO;
import com.example.pruebacrudpro.dto.ClienteResponseDTO;
import com.example.pruebacrudpro.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de Clientes.
 * <p>
 * Expone los endpoints bajo la ruta {@code /api/v1/clientes}.
 * Implementa las operaciones CRUD básicas delegando la lógica al
 * {@link ClienteService}.
 * </p>
 */
@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    /**
     * Obtiene todos los clientes.
     * 
     * @return Lista de clientes con estado 200 (OK).
     */
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Obtiene un cliente por su ID.
     * 
     * @param id El identificador del cliente.
     * @return El cliente encontrado con estado 200 (OK).
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * Crea un nuevo cliente.
     * 
     * @param dto Los datos del cliente validos mediante {@link Valid}.
     * @return El cliente creado con estado 201 (CREATED).
     */
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> create(@Valid @RequestBody ClienteRequestDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    /**
     * Actualiza un cliente existente.
     * 
     * @param id  El identificador del cliente.
     * @param dto Los nuevos datos válidos.
     * @return El cliente actualizado con estado 200 (OK).
     */
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    /**
     * Elimina un cliente por su ID.
     * 
     * @param id El identificador del cliente.
     * @return Respuesta vacía con estado 204 (NO_CONTENT).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
