package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Cuota {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCuota")
    private int idCuota;
    @ManyToOne
    @JoinColumn(name = "numeroPoliza")
    private Poliza poliza;
    @Basic
    @Column(name = "fechaPago")
    private Date fechaPago;
    @Basic
    @Column(name = "ultimoDiaDePago")
    private Date ultimoDiaDePago;
    @Basic
    @Column(name = "importeOriginal")
    private Double importeOriginal;
    @Basic
    @Column(name = "importeFinal")
    private Double importeFinal;
    @Basic
    @Column(name = "numeroRecibo")
    private Integer numeroRecibo;

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

}
