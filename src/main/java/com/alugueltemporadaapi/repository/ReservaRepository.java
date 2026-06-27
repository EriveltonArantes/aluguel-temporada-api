package com.alugueltemporadaapi.repository;

import com.alugueltemporadaapi.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
