package com.alugueltemporadaapi.service;

import com.alugueltemporadaapi.dto.ReservaRequestDTO;
import com.alugueltemporadaapi.dto.ReservaResponseDTO;
import com.alugueltemporadaapi.exception.ResourceNotFoundException;
import com.alugueltemporadaapi.mapper.ReservaMapper;
import com.alugueltemporadaapi.model.Reserva;
import com.alugueltemporadaapi.repository.ReservaRepository;
import com.alugueltemporadaapi.repository.ImovelRepository;
import com.alugueltemporadaapi.model.Imovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private ReservaMapper mapper;

    @Autowired
    private ImovelRepository imovelRepository;

    @Transactional(readOnly = true)
    public List<ReservaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ReservaResponseDTO buscar(Long id) {
        Reserva entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ReservaResponseDTO criar(ReservaRequestDTO dto) {
        Reserva entity = mapper.toEntity(dto);
        Imovel imovel = imovelRepository.findById(dto.getImovelId())
            .orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado com id: " + dto.getImovelId()));
        entity.setImovel(imovel);
        Reserva salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ReservaResponseDTO atualizar(Long id, ReservaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Reserva não encontrado com id: " + id);
        }
        Reserva entity = mapper.toEntity(dto);
        entity.setId(id);
        Imovel imovel = imovelRepository.findById(dto.getImovelId())
            .orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado com id: " + dto.getImovelId()));
        entity.setImovel(imovel);
        Reserva salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Reserva não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
