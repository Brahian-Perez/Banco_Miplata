package com.banco.miplata.repositories;

import com.banco.miplata.models.CompraTarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraTarjetaRepository extends JpaRepository<CompraTarjeta, Long> {

    List<CompraTarjeta> findByTarjetaIdOrderByFechaCompraDesc(Long tarjetaId);
}