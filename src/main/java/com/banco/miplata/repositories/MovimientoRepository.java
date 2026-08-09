package com.banco.miplata.repositories;

import com.banco.miplata.models.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    List<Movimiento> findByCuentaIdOrderByFechaHoraDesc(Long cuentaId);
    List<Movimiento> findByTarjetaIdOrderByFechaHoraDesc(Long tarjetaId);
    List<Movimiento> findByCuenta_UsuarioIdOrderByFechaHoraDesc(Long usuarioId);
    List<Movimiento> findByTarjeta_UsuarioIdOrderByFechaHoraDesc(Long usuarioId);
}
