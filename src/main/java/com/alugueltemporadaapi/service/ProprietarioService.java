package com.alugueltemporadaapi.service;

import com.alugueltemporadaapi.dto.ProprietarioRequestDTO;
import com.alugueltemporadaapi.dto.ProprietarioResponseDTO;
import com.alugueltemporadaapi.exception.ResourceNotFoundException;
import com.alugueltemporadaapi.mapper.ProprietarioMapper;
import com.alugueltemporadaapi.model.Proprietario;
import com.alugueltemporadaapi.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProprietarioService {

    @Autowired
    private ProprietarioRepository repository;

    @Autowired
    private ProprietarioMapper mapper;

    @Transactional(readOnly = true)
    public List<ProprietarioResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProprietarioResponseDTO buscar(Long id) {
        Proprietario entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Proprietario não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ProprietarioResponseDTO criar(ProprietarioRequestDTO dto) {
        Proprietario entity = mapper.toEntity(dto);
        Proprietario salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ProprietarioResponseDTO atualizar(Long id, ProprietarioRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Proprietario não encontrado com id: " + id);
        }
        Proprietario entity = mapper.toEntity(dto);
        entity.setId(id);
        Proprietario salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Proprietario não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
