package com.juandidev.autoreslibros.service.impl;

import com.juandidev.autoreslibros.dto.request.LibroRequestDTO;
import com.juandidev.autoreslibros.dto.response.LibroResponseDTO;
import com.juandidev.autoreslibros.exception.ResourceNotFoundException;
import com.juandidev.autoreslibros.mapper.LibroMapper;
import com.juandidev.autoreslibros.model.Autor;
import com.juandidev.autoreslibros.model.Libro;
import com.juandidev.autoreslibros.repository.AutorRepository;
import com.juandidev.autoreslibros.repository.LibroRepository;
import com.juandidev.autoreslibros.service.ILibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementación de la lógica de negocio para la entidad Libro.
 * Maneja la persistencia y la conversión entre Entidades y DTOs.
 */
@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements ILibroService {

    private final LibroRepository libroRepo;
    private final AutorRepository autorRepo;
    private final LibroMapper libroMapper;

    @Override
    @Transactional(readOnly = true)
    public List<LibroResponseDTO> listarLibros() {
        return libroRepo.findAll().stream()
                .map(libroMapper::toResponseDTO)
                .toList();
    }

    @Override
    @Transactional
    public LibroResponseDTO crearLibro(LibroRequestDTO dto) {
        // En un Record de Java 21, el autorId se obtiene con dto.autorId()
        Autor autor = autorRepo.findById(dto.autorId())
                .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado con ID: " + dto.autorId()));

        Libro nuevoLibro = libroMapper.toEntity(dto);
        nuevoLibro.setAutor(autor); // Vinculamos el libro con su autor real

        Libro libroGuardado = libroRepo.save(nuevoLibro);
        return libroMapper.toResponseDTO(libroGuardado);
    }

    @Override
    @Transactional(readOnly = true)
    public LibroResponseDTO buscarLibro(Long id) {
        Libro libro = buscarLibroPorId(id);
        return libroMapper.toResponseDTO(libro);
    }

    @Override
    @Transactional
    public LibroResponseDTO actualizarLibro(Long id, LibroRequestDTO dto) {
        Libro libroExistente = buscarLibroPorId(id);

        // Si el ID del autor cambió en el request, debemos actualizar la relación
        // manualmente
        // ya que el mapper ignora el objeto 'Autor' para evitar conflictos.
        if (!libroExistente.getAutor().getId().equals(dto.autorId())) {
            Autor nuevoAutor = autorRepo.findById(dto.autorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado con ID: " + dto.autorId()));
            libroExistente.setAutor(nuevoAutor);
        }

        // Usamos el mapper para actualizar el resto de campos (título, categoría,
        // páginas)
        libroMapper.updateEntity(dto, libroExistente);

        Libro libroActualizado = libroRepo.save(libroExistente);
        return libroMapper.toResponseDTO(libroActualizado);
    }

    @Override
    @Transactional
    public void eliminarLibro(Long id) {
        Libro libro = buscarLibroPorId(id);
        libroRepo.delete(libro);
    }

    /**
     * Método auxiliar para buscar un libro o lanzar excepción si no existe.
     */
    private Libro buscarLibroPorId(Long id) {
        return libroRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado con ID: " + id));
    }
}
