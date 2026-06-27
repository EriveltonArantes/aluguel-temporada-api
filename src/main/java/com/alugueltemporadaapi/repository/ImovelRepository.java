package com.alugueltemporadaapi.repository;

import com.alugueltemporadaapi.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
