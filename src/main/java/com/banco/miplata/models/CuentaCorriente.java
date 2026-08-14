package com.banco.miplata.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cuenta_corriente")
@DiscriminatorValue("CORRIENTE")
@PrimaryKeyJoinColumn(name ="id_cuenta")

public class CuentaCorriente extends Cuenta {

    @Column(name = "porcentaje_sobregiro", nullable = false, precision = 5, scale = 4)
    private BigDecimal porcentajeSobregiro = new BigDecimal("0.2000");

    public BigDecimal getPorcentajeSobregiro() {
        return porcentajeSobregiro;
    }

    public void setPorcentajeSobregiro(BigDecimal porcentajeSobregiro) {
        this.porcentajeSobregiro = porcentajeSobregiro;
    }
}
