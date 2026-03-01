package com.juandidev.autoreslibros.mapper;

import com.juandidev.autoreslibros.dto.request.LibroRequestDTO;
import com.juandidev.autoreslibros.dto.response.LibroResponseDTO;
import com.juandidev.autoreslibros.model.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LibroMapper {

    // El autorId del Request NO se mapea aquí directamente a la entidad
    // ya que la entidad requiere un objeto 'Autor' completo.
    // Eso se suele manejar en el Service buscando el autor en DB.
    @Mapping(target = "autor", ignore = true)
    Libro toEntity(LibroRequestDTO request);

    // Mapeamos el ID del autor desde el objeto anidado al campo plano Long
    @Mapping(target = "autorId", source = "autor.id")
    LibroResponseDTO toResponseDTO(Libro libro);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "autor", ignore = true)
    void updateEntity(LibroRequestDTO dto, @MappingTarget Libro libroActualizar);
}
