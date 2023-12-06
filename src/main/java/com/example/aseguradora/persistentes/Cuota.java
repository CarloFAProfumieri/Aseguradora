package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Cuota {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCuota")
    private int idCuota;
    @ManyToOne
    @JoinColumn(name = "numeroPoliza")
    private Poliza poliza;
    @Basic // se registra al realizar el pago
    @Column(name = "fechaPago")
    private LocalDate fechaPago;
    @Basic
    @Column(name = "ultimoDiaDePago")
    private LocalDate ultimoDiaDePago;
    @Basic
    @Column(name = "importeOriginal")
    private Double importeOriginal;
    @Basic
    @Column(name = "importeFinal")
    private Double importeFinal;

    public Cuota() {

    }

    public Cuota(LocalDate diaDePago) {
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

}
