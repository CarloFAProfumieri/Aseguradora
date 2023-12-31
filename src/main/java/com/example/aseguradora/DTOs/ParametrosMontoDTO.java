package com.example.aseguradora.DTOs;

public class ParametrosMontoDTO {
    private int derechoEmision;
    private int prima;
    private int descuento;
    private int baseAnualPrima;
    private Double montoTotal;
    private int premio;
    public int getPrima() {
        return prima;
    }

    public void setPrima(int prima) {
        this.prima = prima;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getDerechoEmision() {
        return derechoEmision;
    }

    public void setDerechoEmision(int derechoEmision) {
        this.derechoEmision = derechoEmision;
    }

    public int getBaseAnualPrima() {
        return baseAnualPrima;
    }

    public void setBaseAnualPrima(int baseAnualPrima) {
        this.baseAnualPrima = baseAnualPrima;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }


    public void setPremio(int unPremio) {
        premio = unPremio;
    }
    public int getPremio(){
        return premio;
    }
}
