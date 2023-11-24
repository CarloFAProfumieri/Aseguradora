package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Localidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idLocalidad")
    private int idLocalidad;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "valorPorcentual")
    private double valorPorcentual;
    @Basic
    @Column(name = "idProvincia")
    private Integer idProvincia;

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getValorPorcentual() {
        return valorPorcentual;
    }

    public void setValorPorcentual(double valorPorcentual) {
        this.valorPorcentual = valorPorcentual;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localidad localidad = (Localidad) o;
        return idLocalidad == localidad.idLocalidad && Double.compare(valorPorcentual, localidad.valorPorcentual) == 0 && Objects.equals(nombre, localidad.nombre) && Objects.equals(idProvincia, localidad.idProvincia);
    }
    public String toString(){
        return nombre;
    }
    @Override
    public int hashCode() {
        return Objects.hash(idLocalidad, nombre, valorPorcentual, idProvincia);
    }
}
