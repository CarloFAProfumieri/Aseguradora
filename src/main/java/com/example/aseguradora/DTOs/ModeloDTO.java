package com.example.aseguradora.DTOs;

public class ModeloDTO implements Comparable<ModeloDTO>{
    private int idModelo;

    private String nombre;

    private int idMarca;

    private int valorPorcentual;
    private MarcaDTO marca;//?
    private int anio;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getValorPorcentual() {
        return valorPorcentual;
    }
    @Override
    public int compareTo(ModeloDTO other) {
        // Implement comparison logic based on your requirements
        return this.nombre.compareTo(other.nombre);
    }

    public void setValorPorcentual(int valorPorcentual) {
        this.valorPorcentual = valorPorcentual;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
