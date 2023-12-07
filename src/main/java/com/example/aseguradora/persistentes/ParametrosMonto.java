package com.example.aseguradora.persistentes;

import com.example.aseguradora.DTOs.PolizaDTO;
import jakarta.persistence.*;

@Entity
public class ParametrosMonto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idParametrosMonto")
    private int idParametrosMonto;
    @Basic
    @Column(name = "derechoEmision")
    private Double derechoEmision;
    @Basic
    @Column(name = "prima")
    private Double prima;
    @Basic
    @Column(name = "descuento")
    private Double descuento;
    @Basic
    @Column(name = "baseAnualPrima")
    private Double baseAnualPrima;
    @OneToOne
    @JoinColumn(name = "numeropoliza")
    private Poliza poliza;

    public ParametrosMonto(PolizaDTO datosPolizaDTO, Poliza unaPoliza) {
        derechoEmision = datosPolizaDTO.getDerechoEmision();
        prima = datosPolizaDTO.getPrima();
        descuento = datosPolizaDTO.getDescuento();
        baseAnualPrima = datosPolizaDTO.getBaseAnualPrima();
        poliza = unaPoliza;
    }

    public ParametrosMonto() {
    }
}
