package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class MedidaSeguridad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMedida")
    private int idMedida;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "valorPorcentual")
    private Double valorPorcentual;

    public int getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(int idMedida) {
        this.idMedida = idMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        MedidaSeguridad that = (MedidaSeguridad) o;
        return idMedida == that.idMedida && Objects.equals(nombre, that.nombre) && Objects.equals(valorPorcentual, that.valorPorcentual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedida, nombre, valorPorcentual);
    }
}
