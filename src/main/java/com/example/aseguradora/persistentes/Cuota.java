package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Cuota {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCuota")
    private int idCuota;
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
    @Column(name = "numeroPoliza")
    private Integer numeroPoliza;
    @Basic
    @Column(name = "numeroRecibo")
    private Integer numeroRecibo;

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getUltimoDiaDePago() {
        return ultimoDiaDePago;
    }

    public void setUltimoDiaDePago(Date ultimoDiaDePago) {
        this.ultimoDiaDePago = ultimoDiaDePago;
    }

    public Double getImporteOriginal() {
        return importeOriginal;
    }

    public void setImporteOriginal(Double importeOriginal) {
        this.importeOriginal = importeOriginal;
    }

    public Double getImporteFinal() {
        return importeFinal;
    }

    public void setImporteFinal(Double importeFinal) {
        this.importeFinal = importeFinal;
    }

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Integer getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(Integer numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuota cuota = (Cuota) o;
        return idCuota == cuota.idCuota && Objects.equals(fechaPago, cuota.fechaPago) && Objects.equals(ultimoDiaDePago, cuota.ultimoDiaDePago) && Objects.equals(importeOriginal, cuota.importeOriginal) && Objects.equals(importeFinal, cuota.importeFinal) && Objects.equals(numeroPoliza, cuota.numeroPoliza) && Objects.equals(numeroRecibo, cuota.numeroRecibo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCuota, fechaPago, ultimoDiaDePago, importeOriginal, importeFinal, numeroPoliza, numeroRecibo);
    }
}
