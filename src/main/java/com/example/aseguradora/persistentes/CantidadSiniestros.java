package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CantidadSiniestros {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCantidadSiniestros")
    private int idCantidadSiniestros;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "valorPorcentual")
    private Double valorPorcentual;
    @Basic
    @Column(name = "cantidad")
    private Integer cantidad;

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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CantidadSiniestros that = (CantidadSiniestros) o;
        return idCantidadSiniestros == that.idCantidadSiniestros && Objects.equals(valorPorcentual, that.valorPorcentual) && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCantidadSiniestros, valorPorcentual, cantidad);
    }
}
