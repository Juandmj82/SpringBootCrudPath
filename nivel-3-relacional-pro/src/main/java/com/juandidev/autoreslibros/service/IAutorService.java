package com.juandidev.autoreslibros.service;

import java.util.List;

import com.juandidev.autoreslibros.dto.request.AutorRequestDTO;
import com.juandidev.autoreslibros.dto.response.AutorResponseDTO;

public interface IAutorService {
    List<AutorResponseDTO> listarAutores();

    AutorResponseDTO crearAutor(AutorRequestDTO dto);

    AutorResponseDTO buscarAutor(Long id);

    AutorResponseDTO actualizarAutor(Long id, AutorRequestDTO dto);

    void eliminarAutor(Long id);

}
