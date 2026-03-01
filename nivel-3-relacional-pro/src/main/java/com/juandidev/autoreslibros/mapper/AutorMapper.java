package com.juandidev.autoreslibros.mapper;

import com.juandidev.autoreslibros.dto.request.AutorRequestDTO;
import com.juandidev.autoreslibros.dto.response.AutorResponseDTO;
import com.juandidev.autoreslibros.model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { LibroMapper.class })
public interface AutorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "libros", ignore = true)
    Autor toEntity(AutorRequestDTO request);

    // MapStruct detectará automáticamente LibroMapper para convertir la lista de
    // libros
    AutorResponseDTO toResponseDTO(Autor autor);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "libros", ignore = true)
    void updateEntity(AutorRequestDTO dto, @org.mapstruct.MappingTarget Autor autorActualizar);
}
