package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
public class HistoriaHijos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idHistoriaHijos")
    private int idHistoriaHijos;
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
    @JoinColumn(name = "idValorPorcentualHijo")
    private ValorPorcentualHijo valorPorcentualHijo;


    public int getIdHistoriaHijos() {
        return idHistoriaHijos;
    }

    public void setIdHistoriaHijos(int idHistoriaHijos) {
        this.idHistoriaHijos = idHistoriaHijos;
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

    public ValorPorcentualHijo getValorPorcentualHijo() {
        return valorPorcentualHijo;
    }

    public void setValorPorcentualHijo(ValorPorcentualHijo valorPorcentualHijo) {
        this.valorPorcentualHijo = valorPorcentualHijo;
    }
}