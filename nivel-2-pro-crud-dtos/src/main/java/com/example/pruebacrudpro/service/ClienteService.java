package com.example.pruebacrudpro.service;

import com.example.pruebacrudpro.dto.ClienteRequestDTO;
import com.example.pruebacrudpro.dto.ClienteResponseDTO;

import java.util.List;

/**
 * Interface que define los servicios de negocio para la gestión de
 * {@link Cliente}.
 * <p>
 * Se encarga de desacoplar el controlador de la lógica de negocio y de la
 * persistencia.
 * </p>
 */
public interface ClienteService {

    /**
     * Obtiene la lista completa de clientes.
     * 
     * @return Una lista de {@link ClienteResponseDTO}.
     */
    List<ClienteResponseDTO> findAll();

    /**
     * Busca un cliente por su identificador único.
     * 
     * @param id El identificador del cliente.
     * @return El {@link ClienteResponseDTO} si se encuentra.
     */
    ClienteResponseDTO findById(Long id);

    /**
     * Crea un nuevo cliente en el sistema.
     * 
     * @param dto Los datos del cliente a crear.
     * @return El {@link ClienteResponseDTO} del cliente guardado.
     */
    ClienteResponseDTO save(ClienteRequestDTO dto);

    /**
     * Actualiza los datos de un cliente existente.
     * 
     * @param id  El identificador del cliente a actualizar.
     * @param dto Los nuevos datos.
     * @return El {@link ClienteResponseDTO} con los datos actualizados.
     */
    ClienteResponseDTO update(Long id, ClienteRequestDTO dto);

    /**
     * Elimina un cliente del sistema.
     * 
     * @param id El identificador del cliente a eliminar.
     */
    void delete(Long id);
}
