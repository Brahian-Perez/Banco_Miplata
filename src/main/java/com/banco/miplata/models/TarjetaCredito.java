package com.banco.miplata.models;

import com.banco.miplata.enums.EstadoCuenta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tarjeta_credito")
@Getter
@Setter
@NoArgsConstructor
public class TarjetaCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column Long id;

    @Column(name = "numero_tarjeta", nullable = false, unique = true, length = 20)
    private String numeroTarjeta;

    @Column(name = "cupo", nullable = false, precision = 14, scale = 2)
    private BigDecimal cupo = new BigDecimal("1000000.00");

    @Column(name = "deuda",nullable = false, precision = 14, scale = 2)
    private BigDecimal deuda = BigDecimal.ZERO;

    @Column(name = "fecha_apertura", nullable = false, updatable = false)
    private LocalDateTime fechaApertura;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoCuenta estado = EstadoCuenta.ACTIVA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @PrePersist
    protected void onCreate() {
        this.fechaApertura = LocalDateTime.now();
    }

}
