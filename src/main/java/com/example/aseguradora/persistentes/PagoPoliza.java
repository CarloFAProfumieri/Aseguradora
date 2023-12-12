package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
public class PagoPoliza {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numeroRecibo")
    private int numeroRecibo;
    @Basic
    @Column(name = "fecha")
    private LocalDate fecha;
    @Basic
    @Column(name = "hora")
    private Time hora;
    @Basic
    @Column(name = "recargoMora")
    private Double recargoMora;
    @Basic
    @Column(name = "bonificacion")
    private Double bonificacion;
    @ManyToOne
    @JoinColumn(name = "nombreUsuario")
    private Usuario nombreUsuario;
    @OneToMany(mappedBy = "pagoPoliza")
    private List<Cuota> cuotas;


    public int getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(int numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Double getRecargoMora() {
        return recargoMora;
    }

    public void setRecargoMora(Double recargoMora) {
        this.recargoMora = recargoMora;
    }

    public Double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(Double bonificacion) {
        this.bonificacion = bonificacion;
    }

    public Usuario getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(Usuario nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }
}