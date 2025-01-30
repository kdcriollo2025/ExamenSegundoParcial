package com.arquitectura.examen.segundoparcial.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;


import com.arquitectura.examen.segundoparcial.controller.dto.SegundoParcialDTO;
import com.arquitectura.examen.segundoparcial.model.SegundoParcial;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SegundoParcialMapperNew {

    SegundoParcialDTO toDTO(SegundoParcial model);
    
    SegundoParcial toModel(SegundoParcialDTO dto);
    
}
