package com.juandidev.autoreslibros.mapper;

import com.juandidev.autoreslibros.dto.request.AutorRequestDTO;
import com.juandidev.autoreslibros.dto.response.AutorResponseDTO;
import com.juandidev.autoreslibros.dto.response.LibroResponseDTO;
import com.juandidev.autoreslibros.model.Autor;
import com.juandidev.autoreslibros.model.Libro;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-28T20:34:57-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260128-0750, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class AutorMapperImpl implements AutorMapper {

    @Autowired
    private LibroMapper libroMapper;

    @Override
    public Autor toEntity(AutorRequestDTO request) {
        if ( request == null ) {
            return null;
        }

        Autor autor = new Autor();

        autor.setApellido( request.apellido() );
        autor.setNombre( request.nombre() );

        return autor;
    }

    @Override
    public AutorResponseDTO toResponseDTO(Autor autor) {
        if ( autor == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String apellido = null;
        List<LibroResponseDTO> libros = null;

        id = autor.getId();
        nombre = autor.getNombre();
        apellido = autor.getApellido();
        libros = libroListToLibroResponseDTOList( autor.getLibros() );

        AutorResponseDTO autorResponseDTO = new AutorResponseDTO( id, nombre, apellido, libros );

        return autorResponseDTO;
    }

    @Override
    public void updateEntity(AutorRequestDTO dto, Autor autorActualizar) {
        if ( dto == null ) {
            return;
        }

        autorActualizar.setApellido( dto.apellido() );
        autorActualizar.setNombre( dto.nombre() );
    }

    protected List<LibroResponseDTO> libroListToLibroResponseDTOList(List<Libro> list) {
        if ( list == null ) {
            return null;
        }

        List<LibroResponseDTO> list1 = new ArrayList<LibroResponseDTO>( list.size() );
        for ( Libro libro : list ) {
            list1.add( libroMapper.toResponseDTO( libro ) );
        }

        return list1;
    }
}
