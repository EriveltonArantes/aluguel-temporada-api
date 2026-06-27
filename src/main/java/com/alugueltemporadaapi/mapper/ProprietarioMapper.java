package com.alugueltemporadaapi.mapper;

import com.alugueltemporadaapi.dto.ProprietarioRequestDTO;
import com.alugueltemporadaapi.dto.ProprietarioResponseDTO;
import com.alugueltemporadaapi.model.Proprietario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProprietarioMapper {

    Proprietario toEntity(ProprietarioRequestDTO dto);

    ProprietarioResponseDTO toResponseDTO(Proprietario entity);
}
