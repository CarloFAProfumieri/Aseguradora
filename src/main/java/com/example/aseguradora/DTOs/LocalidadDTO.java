package com.example.aseguradora.DTOs;

import com.example.aseguradora.persistentes.Localidad;

public class LocalidadDTO implements Comparable<LocalidadDTO> {
    private int idLocalidad;
    private int idProvincia;
    private String nombre;
    private double valorPorcentual;
    @Override
    public String toString(){
        return nombre;
    }
    public int compareTo(LocalidadDTO otraLocalidad) {
        return this.nombre.compareTo(otraLocalidad.nombre);
    }
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

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }
}
