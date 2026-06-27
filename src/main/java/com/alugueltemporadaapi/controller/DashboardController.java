package com.alugueltemporadaapi.controller;

import com.alugueltemporadaapi.model.Proprietario;
import com.alugueltemporadaapi.model.Imovel;
import com.alugueltemporadaapi.model.Reserva;
import com.alugueltemporadaapi.model.Pagamento;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.alugueltemporadaapi.repository.ProprietarioRepository proprietarioRepository;

    @Autowired
    private com.alugueltemporadaapi.repository.ImovelRepository imovelRepository;

    @Autowired
    private com.alugueltemporadaapi.repository.ReservaRepository reservaRepository;

    @Autowired
    private com.alugueltemporadaapi.repository.PagamentoRepository pagamentoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalProprietario", proprietarioRepository.count());
        resumo.put("totalImovel", imovelRepository.count());
        resumo.put("somaPrecoDiariaImovel", imovelRepository.findAll().stream().filter(e -> e.getPrecoDiaria() != null).mapToDouble(e -> e.getPrecoDiaria()).sum());
        resumo.put("totalReserva", reservaRepository.count());
        resumo.put("somaValorTotalReserva", reservaRepository.findAll().stream().filter(e -> e.getValorTotal() != null).mapToDouble(e -> e.getValorTotal()).sum());
        resumo.put("graficoReserva", reservaRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalPagamento", pagamentoRepository.count());
        resumo.put("somaValorPagamento", pagamentoRepository.findAll().stream().map(e -> e.getValor()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoPagamento", pagamentoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
