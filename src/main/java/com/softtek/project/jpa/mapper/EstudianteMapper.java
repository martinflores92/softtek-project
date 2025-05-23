package com.softtek.project.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.softtek.project.jpa.dto.EstudianteDTO;
import com.softtek.project.jpa.model.Estudiante;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {
    Estudiante toEntity(EstudianteDTO dto);
    EstudianteDTO toDto(Estudiante entity);
    void actualizarEntidadDesdeDto(EstudianteDTO dto, @MappingTarget Estudiante entidad);

}