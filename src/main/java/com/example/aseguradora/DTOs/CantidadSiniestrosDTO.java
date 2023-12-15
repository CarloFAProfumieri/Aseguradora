package com.example.aseguradora.DTOs;

public class CantidadSiniestrosDTO {
    private int idCantidadSiniestros;
    private String cantidad;
    private Double valorPorcentual;

    public String toString(){
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public String getCantidad() {
        return cantidad;
    }

    public int getIdCantidadSiniestros() {
        return idCantidadSiniestros;
    }

    public void setIdCantidadSiniestros(int idCantidadSiniestros) {
        this.idCantidadSiniestros = idCantidadSiniestros;
    }

    public Double getValorPorcentual() {
        return valorPorcentual;
    }

    public void setValorPorcentual(Double valorPorcentual) {
        this.valorPorcentual = valorPorcentual;
    }

}
