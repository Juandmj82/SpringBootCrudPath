package com.example.pruebacrudpro.mapper;

import com.example.pruebacrudpro.dto.ClienteRequestDTO;
import com.example.pruebacrudpro.dto.ClienteResponseDTO;
import com.example.pruebacrudpro.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * Interface de MapStruct para el mapeo automático entre {@link Cliente} y sus
 * DTOs.
 * <p>
 * El parámetro {@code componentModel = "spring"} permite que MapStruct genere
 * una implementación que sea un Bean de Spring manejado, facilitando su
 * inyección.
 * </p>
 */
@Mapper(componentModel = "spring")
public interface ClienteMapper {

    /**
     * Convierte una entidad {@link Cliente} a un {@link ClienteResponseDTO}.
     * 
     * @param entity La entidad de la base de datos.
     * @return El DTO de respuesta para el cliente API.
     */
    ClienteResponseDTO toResponseDTO(Cliente entity);

    /**
     * Convierte un {@link ClienteRequestDTO} a una entidad {@link Cliente}.
     * <p>
     * Se ignora el ID porque las nuevas entidades aún no lo tienen asignado.
     * </p>
     * 
     * @param dto El DTO de entrada.
     * @return La entidad lista para ser persistida.
     */
    @Mapping(target = "id", ignore = true)
    Cliente toEntity(ClienteRequestDTO dto);

    /**
     * Actualiza una instancia existente de {@link Cliente} con los datos del DTO.
     * <p>
     * Se utiliza {@link MappingTarget} para indicar que la entidad pasada como
     * segundo
     * parámetro será modificada en lugar de crear una nueva.
     * </p>
     * 
     * @param dto    Los nuevos datos.
     * @param entity La entidad actual persistida.
     */
    @Mapping(target = "id", ignore = true)
    void updateEntity(ClienteRequestDTO dto, @MappingTarget Cliente entity);
}
