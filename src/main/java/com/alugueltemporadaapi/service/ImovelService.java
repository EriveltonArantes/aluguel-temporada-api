package com.alugueltemporadaapi.service;

import com.alugueltemporadaapi.dto.ImovelRequestDTO;
import com.alugueltemporadaapi.dto.ImovelResponseDTO;
import com.alugueltemporadaapi.exception.ResourceNotFoundException;
import com.alugueltemporadaapi.mapper.ImovelMapper;
import com.alugueltemporadaapi.model.Imovel;
import com.alugueltemporadaapi.repository.ImovelRepository;
import com.alugueltemporadaapi.repository.ProprietarioRepository;
import com.alugueltemporadaapi.model.Proprietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ImovelService {

    @Autowired
    private ImovelRepository repository;

    @Autowired
    private ImovelMapper mapper;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @Transactional(readOnly = true)
    public List<ImovelResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ImovelResponseDTO buscar(Long id) {
        Imovel entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ImovelResponseDTO criar(ImovelRequestDTO dto) {
        Imovel entity = mapper.toEntity(dto);
        Proprietario proprietario = proprietarioRepository.findById(dto.getProprietarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Proprietario não encontrado com id: " + dto.getProprietarioId()));
        entity.setProprietario(proprietario);
        Imovel salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ImovelResponseDTO atualizar(Long id, ImovelRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Imovel não encontrado com id: " + id);
        }
        Imovel entity = mapper.toEntity(dto);
        entity.setId(id);
        Proprietario proprietario = proprietarioRepository.findById(dto.getProprietarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Proprietario não encontrado com id: " + dto.getProprietarioId()));
        entity.setProprietario(proprietario);
        Imovel salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Imovel não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
