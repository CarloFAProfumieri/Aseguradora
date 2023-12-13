package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
public class HistoriaModelo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idHistoriaModelo")
    private int idHistoriaModelo;
    @Basic
    @Column(name = "valorPorcentual")
    private Double valorPorcentual;
    @Basic
    @Column(name = "desde")
    private LocalDate desde;
    @Basic
    @Column(name = "hasta")
    private LocalDate hasta;
    @ManyToOne
    @JoinColumn(name = "nombreUsuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idModelo")
    private ModeloVehiculo modeloVehiculo;


    public int getIdHistoriaModelo() {
        return idHistoriaModelo;
    }

    public void setIdHistoriaModelo(int idHistoriaModelo) {
        this.idHistoriaModelo = idHistoriaModelo;
    }

    public Double getValorPorcentual() {
        return valorPorcentual;
    }

    public void setValorPorcentual(Double valorPorcentual) {
        this.valorPorcentual = valorPorcentual;
    }

    public LocalDate getDesde() {
        return desde;
    }

    public void setDesde(LocalDate desde) {
        this.desde = desde;
    }

    public LocalDate getHasta() {
        return hasta;
    }

    public void setHasta(LocalDate hasta) {
        this.hasta = hasta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ModeloVehiculo getModeloVehiculo() {
        return modeloVehiculo;
    }

    public void setModeloVehiculo(ModeloVehiculo modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }
}