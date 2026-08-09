package com.banco.miplata.models;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuenta_ahorros")
@DiscriminatorValue("AHORROS")
@PrimaryKeyJoinColumn(name = "id_cuenta")
public class CuentaAhorros extends Cuenta{

    @Column(name = "tasa_interes_mensual", nullable = false, precision = 5, scale = 4)
    private BigDecimal tasaInteresMensual = new BigDecimal("0.0150");

    @Column(name = "fecha_ultimo_interes")
    private LocalDateTime fechaUltimoInteres;

    public BigDecimal getTasaInteresMensual(){
        return tasaInteresMensual;
    }

    public void setTasaInteresMensual (BigDecimal tasaInteresMensual){
        this.tasaInteresMensual=tasaInteresMensual;
    }

    public LocalDateTime getFechaUltimoInteres (){
        return fechaUltimoInteres;
    }

    public void setFechaUltimoInteres(LocalDateTime fechaUltimoInteres){
        this.fechaUltimoInteres = fechaUltimoInteres;
    }

}
