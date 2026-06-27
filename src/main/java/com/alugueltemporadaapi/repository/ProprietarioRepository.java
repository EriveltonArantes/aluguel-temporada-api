package com.alugueltemporadaapi.repository;

import com.alugueltemporadaapi.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {
}
