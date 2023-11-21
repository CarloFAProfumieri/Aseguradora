package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
public class PagoPoliza {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numeroRecibo")
    private int numeroRecibo;
    @Basic
    @Column(name = "fecha")
    private Date fecha;
    @Basic
    @Column(name = "hora")
    private Time hora;
    @Basic
    @Column(name = "recargoMora")
    private Double recargoMora;
    @Basic
    @Column(name = "bonificacion")
    private Double bonificacion;
    @Basic
    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    public int getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(int numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoPoliza that = (PagoPoliza) o;
        return numeroRecibo == that.numeroRecibo && Objects.equals(fecha, that.fecha) && Objects.equals(hora, that.hora) && Objects.equals(recargoMora, that.recargoMora) && Objects.equals(bonificacion, that.bonificacion) && Objects.equals(nombreUsuario, that.nombreUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroRecibo, fecha, hora, recargoMora, bonificacion, nombreUsuario);
    }
}
