package com.alugueltemporadaapi.service;

import com.alugueltemporadaapi.dto.PagamentoRequestDTO;
import com.alugueltemporadaapi.dto.PagamentoResponseDTO;
import com.alugueltemporadaapi.exception.ResourceNotFoundException;
import com.alugueltemporadaapi.mapper.PagamentoMapper;
import com.alugueltemporadaapi.model.Pagamento;
import com.alugueltemporadaapi.repository.PagamentoRepository;
import com.alugueltemporadaapi.repository.ReservaRepository;
import com.alugueltemporadaapi.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private PagamentoMapper mapper;

    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional(readOnly = true)
    public List<PagamentoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PagamentoResponseDTO buscar(Long id) {
        Pagamento entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Pagamento não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public PagamentoResponseDTO criar(PagamentoRequestDTO dto) {
        Pagamento entity = mapper.toEntity(dto);
        Reserva reserva = reservaRepository.findById(dto.getReservaId())
            .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrado com id: " + dto.getReservaId()));
        entity.setReserva(reserva);
        Pagamento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public PagamentoResponseDTO atualizar(Long id, PagamentoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Pagamento não encontrado com id: " + id);
        }
        Pagamento entity = mapper.toEntity(dto);
        entity.setId(id);
        Reserva reserva = reservaRepository.findById(dto.getReservaId())
            .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrado com id: " + dto.getReservaId()));
        entity.setReserva(reserva);
        Pagamento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Pagamento não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
