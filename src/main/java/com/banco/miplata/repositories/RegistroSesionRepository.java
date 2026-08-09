package com.banco.miplata.repositories;

import com.banco.miplata.models.RegistroSesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroSesionRepository extends JpaRepository<RegistroSesion, Long> {

    List<RegistroSesion> findByUsuarioIdOrderByFechaHoraDesc(Long usuarioId);
}