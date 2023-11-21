package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class ValorPorcentualHijo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idValorPorcentualHijo")
    private int idValorPorcentualHijo;
    @Basic
    @Column(name = "valorFijoPorHijo")
    private Double valorFijoPorHijo;
    @Basic
    @Column(name = "cantidadHijos")
    private Integer cantidadHijos;

    public int getIdValorPorcentualHijo() {
        return idValorPorcentualHijo;
    }

    public void setIdValorPorcentualHijo(int idValorPorcentualHijo) {
        this.idValorPorcentualHijo = idValorPorcentualHijo;
    }

    public Double getValorFijoPorHijo() {
        return valorFijoPorHijo;
    }

    public void setValorFijoPorHijo(Double valorFijoPorHijo) {
        this.valorFijoPorHijo = valorFijoPorHijo;
    }

    public Integer getCantidadHijos() {
        return cantidadHijos;
    }

    public void setCantidadHijos(Integer cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValorPorcentualHijo that = (ValorPorcentualHijo) o;
        return idValorPorcentualHijo == that.idValorPorcentualHijo && Objects.equals(valorFijoPorHijo, that.valorFijoPorHijo) && Objects.equals(cantidadHijos, that.cantidadHijos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idValorPorcentualHijo, valorFijoPorHijo, cantidadHijos);
    }
}
