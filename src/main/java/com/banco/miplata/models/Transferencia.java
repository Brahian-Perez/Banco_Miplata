package com.banco.miplata.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transferencia")
@Getter
@Setter
@NoArgsConstructor
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transferencia")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_origen", nullable = false)
    private Cuenta cuentaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_destino",nullable = false)
    private Cuenta cuentaDestino;

    @Column(name = "monto", nullable = false, precision = 14, scale = 2)
    private BigDecimal monto;

    @Column(name = "fecha_hora", nullable = false, updatable = false)
    private LocalDateTime fechaHora;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movimiento_origen", nullable = false, unique = true)
    private Movimiento movimientoOrigen;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movimiento_destino", nullable = false, unique = true)
    private Movimiento movimientoDestino;

    @PrePersist
    protected void onCreate() {
        this.fechaHora = LocalDateTime.now();
    }

}
