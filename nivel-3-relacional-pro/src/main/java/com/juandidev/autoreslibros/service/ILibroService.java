package com.juandidev.autoreslibros.service;

import java.util.List;

import com.juandidev.autoreslibros.dto.request.LibroRequestDTO;
import com.juandidev.autoreslibros.dto.response.LibroResponseDTO;

public interface ILibroService {
List <LibroResponseDTO> listarLibros();

LibroResponseDTO crearLibro(LibroRequestDTO dto);

LibroResponseDTO buscarLibro(Long id);

LibroResponseDTO actualizarLibro(Long id, LibroRequestDTO dto);

void eliminarLibro(Long id);



}
