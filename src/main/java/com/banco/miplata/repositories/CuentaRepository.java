package com.banco.miplata.repositories;

import com.banco.miplata.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);
    List<Cuenta> findByUsuarioId(Long usuarioId);
}

