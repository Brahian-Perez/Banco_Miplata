package com.banco.miplata.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "compra_tarjeta")
@Getter
@Setter
@NoArgsConstructor
public class CompraTarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarjeta", nullable = false)
    private TarjetaCredito tarjeta;

    @Column(name = "monto_original", nullable = false, precision = 14, scale = 2)
    private BigDecimal montoOriginal;

    @Column(name = "numero_cuotas", nullable = false)
    private Short numeroCuotas;

    @Column(name = "tasa_interes_mensual", nullable = false, precision = 5, scale = 4)
    private BigDecimal tasaInteresMensual = BigDecimal.ZERO;

    @Column(name = "cuota_mensual", nullable = false, precision = 14, scale = 2)
    private BigDecimal cuotaMensual;

    @Column(name = "interes_total", nullable = false, precision = 14, scale = 2)
    private BigDecimal interesTotal = BigDecimal.ZERO;

    @Column(name = "total_pagar", nullable = false, precision = 14, scale = 2)
    private BigDecimal totalPagar;

    @Column(name = "fecha_compra", nullable = false, updatable = false)
    private LocalDateTime fechaCompra;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movimiento", nullable = false, unique = true)
    private Movimiento movimiento;

    @PrePersist
    protected void onCreate() {
        this.fechaCompra = LocalDateTime.now();
    }
}
