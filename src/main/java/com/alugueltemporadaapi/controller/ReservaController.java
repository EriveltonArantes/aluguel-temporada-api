package com.alugueltemporadaapi.controller;

import com.alugueltemporadaapi.dto.ReservaRequestDTO;
import com.alugueltemporadaapi.dto.ReservaResponseDTO;
import com.alugueltemporadaapi.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Reserva", description = "Gerenciamento de reservas")
@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @Operation(summary = "Listar todos os Reserva")
    @GetMapping
    public List<ReservaResponseDTO> listar(@RequestParam(required = false) String nomeHospede, @RequestParam(required = false) Long imovelId) {
        List<ReservaResponseDTO> resultado = service.listar();
        if (nomeHospede != null && !nomeHospede.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNomeHospede() != null &&
                item.getNomeHospede().toLowerCase().contains(nomeHospede.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (imovelId != null) {
            resultado = resultado.stream().filter(item -> imovelId.equals(item.getImovelId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Reserva por ID")
    @GetMapping("/{id}")
    public ReservaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Reserva")
    @PostMapping
    public ResponseEntity<ReservaResponseDTO> criar(@Valid @RequestBody ReservaRequestDTO reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(reserva));
    }

    @Operation(summary = "Atualizar Reserva")
    @PutMapping("/{id}")
    public ReservaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ReservaRequestDTO reserva) {
        return service.atualizar(id, reserva);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Reserva")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
