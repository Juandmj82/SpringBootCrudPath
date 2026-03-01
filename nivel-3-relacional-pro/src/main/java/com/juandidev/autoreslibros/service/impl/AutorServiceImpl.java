package com.juandidev.autoreslibros.service.impl;

import com.juandidev.autoreslibros.dto.request.AutorRequestDTO;
import com.juandidev.autoreslibros.dto.response.AutorResponseDTO;
import com.juandidev.autoreslibros.exception.ResourceNotFoundException;
import com.juandidev.autoreslibros.mapper.AutorMapper;
import com.juandidev.autoreslibros.model.Autor;
import com.juandidev.autoreslibros.repository.AutorRepository;
import com.juandidev.autoreslibros.service.IAutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements IAutorService {

    private final AutorRepository autorRepo;
    private final AutorMapper autorMapper;

    @Override
    public List<AutorResponseDTO> listarAutores() {
        return autorRepo.findAll().stream()
                .map(autorMapper::toResponseDTO)
                .toList();

    }

    @Override
    public AutorResponseDTO crearAutor(AutorRequestDTO dto) {
        // convertir el DTO a entidad
        Autor nuevoAutor = autorMapper.toEntity(dto);

        // guardar la entidad en la base de datos
        Autor autorGuardado = autorRepo.save(nuevoAutor);

        // convertir la entidad guardada en un DTO y lo retorna

        return autorMapper.toResponseDTO(autorGuardado);
    }

    @Override
    public AutorResponseDTO buscarAutor(Long id) {
        Autor autorEncontrado = buscarAutorPorId(id);
        return autorMapper.toResponseDTO(autorEncontrado);
    }

    @Override
    public AutorResponseDTO actualizarAutor(Long id, AutorRequestDTO dto) {
        Autor autorExistente = buscarAutorPorId(id);

        autorMapper.updateEntity(dto, autorExistente);

        // mapeamos los cambios guardamos la respuesta y retornamos

        Autor autorActualizado = autorRepo.save(autorExistente);
        return autorMapper.toResponseDTO(autorActualizado);
    }

    @Override
    public void eliminarAutor(Long id) {
        Autor autorExistente = buscarAutorPorId(id);
        autorRepo.delete(autorExistente);

    }

    // método privado

    Autor buscarAutorPorId(Long id) {
        return autorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado"));
    }
}
