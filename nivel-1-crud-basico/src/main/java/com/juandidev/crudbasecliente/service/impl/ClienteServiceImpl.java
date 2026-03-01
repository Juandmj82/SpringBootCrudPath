package com.juandidev.crudbasecliente.service.impl;

import com.juandidev.crudbasecliente.model.Cliente;
import com.juandidev.crudbasecliente.repository.ClienteRepository;
import com.juandidev.crudbasecliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    @Override
    @Transactional
    public Cliente crear(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    @Transactional
    public Cliente actualizar(Long id, Cliente clienteRequest) {
        Cliente clienteExistente = buscarPorId(id);

        // Explicit mapping to avoid overwriting ID
        clienteExistente.setNombre(clienteRequest.getNombre());
        clienteExistente.setApellido(clienteRequest.getApellido());
        clienteExistente.setEmail(clienteRequest.getEmail());
        clienteExistente.setTelefono(clienteRequest.getTelefono());

        return repository.save(clienteExistente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Cliente cliente = buscarPorId(id);
        repository.delete(cliente);
    }
}
