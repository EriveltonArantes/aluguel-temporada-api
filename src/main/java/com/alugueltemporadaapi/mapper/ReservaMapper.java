package com.alugueltemporadaapi.mapper;

import com.alugueltemporadaapi.dto.ReservaRequestDTO;
import com.alugueltemporadaapi.dto.ReservaResponseDTO;
import com.alugueltemporadaapi.model.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(target = "imovel", ignore = true)
    Reserva toEntity(ReservaRequestDTO dto);

    @Mapping(target = "imovelId", source = "imovel.id")
    ReservaResponseDTO toResponseDTO(Reserva entity);
}
