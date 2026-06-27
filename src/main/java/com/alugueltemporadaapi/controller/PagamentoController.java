package com.alugueltemporadaapi.controller;

import com.alugueltemporadaapi.dto.PagamentoRequestDTO;
import com.alugueltemporadaapi.dto.PagamentoResponseDTO;
import com.alugueltemporadaapi.service.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Pagamento", description = "Gerenciamento de pagamentos")
@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @Operation(summary = "Listar todos os Pagamento")
    @GetMapping
    public List<PagamentoResponseDTO> listar(@RequestParam(required = false) String formaPagamento, @RequestParam(required = false) Long reservaId) {
        List<PagamentoResponseDTO> resultado = service.listar();
        if (formaPagamento != null && !formaPagamento.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getFormaPagamento() != null &&
                item.getFormaPagamento().toLowerCase().contains(formaPagamento.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (reservaId != null) {
            resultado = resultado.stream().filter(item -> reservaId.equals(item.getReservaId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Pagamento por ID")
    @GetMapping("/{id}")
    public PagamentoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Pagamento")
    @PostMapping
    public ResponseEntity<PagamentoResponseDTO> criar(@Valid @RequestBody PagamentoRequestDTO pagamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(pagamento));
    }

    @Operation(summary = "Atualizar Pagamento")
    @PutMapping("/{id}")
    public PagamentoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PagamentoRequestDTO pagamento) {
        return service.atualizar(id, pagamento);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Pagamento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
