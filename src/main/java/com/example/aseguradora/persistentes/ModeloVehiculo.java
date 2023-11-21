package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class ModeloVehiculo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idModelo")
    private int idModelo;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "valorPorcentual")
    private Double valorPorcentual;
    @Basic
    @Column(name = "idMarca")
    private Integer idMarca;
    @Basic
    @Column(name = "anio")
    private Integer anio;

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
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

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeloVehiculo that = (ModeloVehiculo) o;
        return idModelo == that.idModelo && Objects.equals(nombre, that.nombre) && Objects.equals(valorPorcentual, that.valorPorcentual) && Objects.equals(idMarca, that.idMarca) && Objects.equals(anio, that.anio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idModelo, nombre, valorPorcentual, idMarca, anio);
    }
}
