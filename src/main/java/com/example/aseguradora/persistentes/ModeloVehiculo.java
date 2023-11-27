package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
