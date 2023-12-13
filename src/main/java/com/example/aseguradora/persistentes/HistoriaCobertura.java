package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
public class HistoriaCobertura {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idHistoriaCobertura")
    private int idHistoriaCobertura;
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
    @JoinColumn(name = "idTipo")
    private TipoCobertura tipoCobertura;


    public int getIdHistoriaCobertura() {
        return idHistoriaCobertura;
    }

    public void setIdHistoriaCobertura(int idHistoriaCobertura) {
        this.idHistoriaCobertura = idHistoriaCobertura;
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

    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }
}