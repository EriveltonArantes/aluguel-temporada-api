package com.alugueltemporadaapi.mapper;

import com.alugueltemporadaapi.dto.ImovelRequestDTO;
import com.alugueltemporadaapi.dto.ImovelResponseDTO;
import com.alugueltemporadaapi.model.Imovel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImovelMapper {

    @Mapping(target = "proprietario", ignore = true)
    Imovel toEntity(ImovelRequestDTO dto);

    @Mapping(target = "proprietarioId", source = "proprietario.id")
    ImovelResponseDTO toResponseDTO(Imovel entity);
}
