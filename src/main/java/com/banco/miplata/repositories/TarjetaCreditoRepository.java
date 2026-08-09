package com.banco.miplata.repositories;

import com.banco.miplata.models.TarjetaCredito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Long> {

    Optional<TarjetaCredito> findByNumeroTarjeta(String numeroTarjeta);
    List<TarjetaCredito> findByUsuarioId(Long usuarioId);
}
