package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CantidadSiniestros {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCantidadSiniestros")
    private int idCantidadSiniestros;

    @Basic
    @Column(name = "cantidad")
    private String cantidad;

    @Basic
    @Column(name = "valorPorcentual")
    private Double valorPorcentual;
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String descripcion) {
        this.cantidad = descripcion;
    }

    public int getIdCantidadSiniestros() {
        return idCantidadSiniestros;
    }

    public void setIdCantidadSiniestros(int idCantidadSiniestros) {
        this.idCantidadSiniestros = idCantidadSiniestros;
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
        CantidadSiniestros that = (CantidadSiniestros) o;
        return idCantidadSiniestros == that.idCantidadSiniestros && Objects.equals(valorPorcentual, that.valorPorcentual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCantidadSiniestros, valorPorcentual);
    }
}
