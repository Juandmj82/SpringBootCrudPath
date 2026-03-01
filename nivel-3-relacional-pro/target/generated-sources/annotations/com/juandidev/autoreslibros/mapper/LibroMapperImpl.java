package com.juandidev.autoreslibros.mapper;

import com.juandidev.autoreslibros.dto.request.LibroRequestDTO;
import com.juandidev.autoreslibros.dto.response.LibroResponseDTO;
import com.juandidev.autoreslibros.model.Autor;
import com.juandidev.autoreslibros.model.Libro;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-28T20:34:57-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260128-0750, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class LibroMapperImpl implements LibroMapper {

    @Override
    public Libro toEntity(LibroRequestDTO request) {
        if ( request == null ) {
            return null;
        }

        Libro libro = new Libro();

        libro.setCategoria( request.categoria() );
        libro.setPaginas( request.paginas() );
        libro.setTitulo( request.titulo() );

        return libro;
    }

    @Override
    public LibroResponseDTO toResponseDTO(Libro libro) {
        if ( libro == null ) {
            return null;
        }

        Long autorId = null;
        Long id = null;
        String titulo = null;
        String categoria = null;
        Integer paginas = null;

        autorId = libroAutorId( libro );
        id = libro.getId();
        titulo = libro.getTitulo();
        categoria = libro.getCategoria();
        paginas = libro.getPaginas();

        LibroResponseDTO libroResponseDTO = new LibroResponseDTO( id, titulo, categoria, paginas, autorId );

        return libroResponseDTO;
    }

    @Override
    public void updateEntity(LibroRequestDTO dto, Libro libroActualizar) {
        if ( dto == null ) {
            return;
        }

        libroActualizar.setCategoria( dto.categoria() );
        libroActualizar.setPaginas( dto.paginas() );
        libroActualizar.setTitulo( dto.titulo() );
    }

    private Long libroAutorId(Libro libro) {
        Autor autor = libro.getAutor();
        if ( autor == null ) {
            return null;
        }
        return autor.getId();
    }
}
