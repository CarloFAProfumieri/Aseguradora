package com.example.aseguradora.persistentes;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

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
    @Basic
    @Column(name = "numeroPoliza")
    private Integer numeroPoliza;

    public int getIdParametrosMonto() {
        return idParametrosMonto;
    }

    public void setIdParametrosMonto(int idParametrosMonto) {
        this.idParametrosMonto = idParametrosMonto;
    }

    public Double getDerechoEmision() {
        return derechoEmision;
    }

    public void setDerechoEmision(Double derechoEmision) {
        this.derechoEmision = derechoEmision;
    }

    public Double getPrima() {
        return prima;
    }

    public void setPrima(Double prima) {
        this.prima = prima;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getBaseAnualPrima() {
        return baseAnualPrima;
    }

    public void setBaseAnualPrima(Double baseAnualPrima) {
        this.baseAnualPrima = baseAnualPrima;
    }

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParametrosMonto that = (ParametrosMonto) o;
        return idParametrosMonto == that.idParametrosMonto && Objects.equals(derechoEmision, that.derechoEmision) && Objects.equals(prima, that.prima) && Objects.equals(descuento, that.descuento) && Objects.equals(baseAnualPrima, that.baseAnualPrima) && Objects.equals(numeroPoliza, that.numeroPoliza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParametrosMonto, derechoEmision, prima, descuento, baseAnualPrima, numeroPoliza);
    }
}
