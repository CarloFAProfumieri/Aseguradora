package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class KmPorAnio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idKmPorAnio")
    private int idKmPorAnio;

    @Basic
    @Column(name = "limiteSuperior")
    private Integer limiteSuperior;
    @Basic
    @Column(name = "limiteInferior")
    private Integer limiteInferior;
    @Basic
    @Column(name = "KmPorAnio")
    private Integer kmPorAnio;
    @Basic
    @Column(name = "valorPorcentual")
    private Double valorPorcentual;

    public int getIdKmPorAnio() {
        return idKmPorAnio;
    }

    public void setIdKmPorAnio(int idKmPorAnio) {
        this.idKmPorAnio = idKmPorAnio;
    }

    public Integer getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(Integer limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public Integer getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(Integer limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public Integer getKmPorAnio() {
        return kmPorAnio;
    }

    public void setKmPorAnio(Integer kmPorAnio) {
        this.kmPorAnio = kmPorAnio;
    }

    public Double getValorPorcentual() {
        return valorPorcentual;
    }

    public void setValorPorcentual(Double valorPorcentual) {
        this.valorPorcentual = valorPorcentual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KmPorAnio kmPorAnio1 = (KmPorAnio) o;
        return idKmPorAnio == kmPorAnio1.idKmPorAnio && Objects.equals(limiteSuperior, kmPorAnio1.limiteSuperior) && Objects.equals(limiteInferior, kmPorAnio1.limiteInferior) && Objects.equals(kmPorAnio, kmPorAnio1.kmPorAnio) && Objects.equals(valorPorcentual, kmPorAnio1.valorPorcentual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKmPorAnio, limiteSuperior, limiteInferior, kmPorAnio, valorPorcentual);
    }
}
