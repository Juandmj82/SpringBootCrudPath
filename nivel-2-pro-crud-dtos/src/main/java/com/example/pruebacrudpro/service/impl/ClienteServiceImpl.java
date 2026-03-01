package com.example.pruebacrudpro.service.impl;

import com.example.pruebacrudpro.dto.ClienteRequestDTO;
import com.example.pruebacrudpro.dto.ClienteResponseDTO;
import com.example.pruebacrudpro.exception.ResourceNotFoundException;
import com.example.pruebacrudpro.mapper.ClienteMapper;
import com.example.pruebacrudpro.model.Cliente;
import com.example.pruebacrudpro.repository.ClienteRepository;
import com.example.pruebacrudpro.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación de los servicios de negocio para la gestión de Clientes.
 * <p>
 * Implementa el patrón Service de Spring y utiliza inyección de dependencias
 * mediante constructor gracias a {@link RequiredArgsConstructor}.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<ClienteResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public ClienteResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ClienteResponseDTO save(ClienteRequestDTO dto) {
        Cliente entity = mapper.toEntity(dto);
        Cliente saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ClienteResponseDTO update(Long id, ClienteRequestDTO dto) {
        Cliente existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con id: " + id));

        // El mapper actualiza la entidad existente sin tocar su ID
        mapper.updateEntity(dto, existing);

        Cliente updated = repository.save(existing);
        return mapper.toResponseDTO(updated);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar, cliente no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }
}
