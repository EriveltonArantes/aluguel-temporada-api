package com.alugueltemporadaapi.repository;

import com.alugueltemporadaapi.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
