package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

@Entity
public class ParametrosMonto {
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
    @JoinColumn(name = "idParametrosMonto")
    private Poliza poliza;

}
