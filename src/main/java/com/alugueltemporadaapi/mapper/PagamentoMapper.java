package com.alugueltemporadaapi.mapper;

import com.alugueltemporadaapi.dto.PagamentoRequestDTO;
import com.alugueltemporadaapi.dto.PagamentoResponseDTO;
import com.alugueltemporadaapi.model.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {

    @Mapping(target = "reserva", ignore = true)
    Pagamento toEntity(PagamentoRequestDTO dto);

    @Mapping(target = "reservaId", source = "reserva.id")
    PagamentoResponseDTO toResponseDTO(Pagamento entity);
}
