package com.example.aseguradora.DTOs;

import java.sql.Date;
import java.sql.Time;

public class PagoDTO {
    private int numeroRecibo;
    private int numeroPoliza;
    private Date fecha;
    private Time hora;
    private Double recargo;
    private Double bonificacion;
    private String nombreUsuario;
    private CuotaDTO[] cuotas;

    public PagoDTO(int numeroRecibo, int numeroPoliza, Date fecha, Time hora, Double recargo, Double bonificacion, String nombreUsuario, CuotaDTO[] cuotas) {
        this.numeroRecibo = numeroRecibo;
        this.numeroPoliza = numeroPoliza;
        this.fecha = fecha;
        this.hora = hora;
        this.recargo = recargo;
        this.bonificacion = bonificacion;
        this.nombreUsuario = nombreUsuario;
        this.cuotas = cuotas;
    }

    public int getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(int numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public int getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(int numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
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

    public Double getRecargo() {
        return recargo;
    }

    public void setRecargo(Double recargo) {
        this.recargo = recargo;
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

    public CuotaDTO[] getCuotas() {
        return cuotas;
    }

    public void setCuotas(CuotaDTO[] cuotas) {
        this.cuotas = cuotas;
    }
}
