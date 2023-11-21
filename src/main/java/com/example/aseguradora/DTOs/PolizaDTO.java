package com.example.aseguradora.DTOs;

import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.enumeraciones.FormaPago;

import java.sql.Date;

public class PolizaDTO {
    private String numeroPoliza;
    private EstadoPoliza estadoPoliza;
    private Double sumaAsegurada;
    private Date fechaInicio;
    private Date fechaFin;
    private FormaPago formaPago;
    private Double premio;
    private Date ultimoDiaPago;
    private String patente;
    private String codigoMotor;
    private Double montoTotal;
    private String codigoChasis;
    private int idTipoCobertura;
    private int anio;
    private int idModelo;
    private int idLocalidad;
    private int[] idMedida;
    private int idKmPorAnio;
    private int idCantidadSiniestros;
    private Double prima;
    private Double descuento;
    private Double derechoEmision;
    private Double baseAnualPrima;

    public PolizaDTO(String numeroPoliza, EstadoPoliza estadoPoliza, Double sumaAsegurada, Date fechaInicio, Date fechaFin, FormaPago formaPago, Double premio, Date ultimoDiaPago, String patente, String codigoMotor, Double montoTotal, String codigoChasis, int idTipoCobertura, int anio, int idModelo, int idLocalidad, int[] idMedida, int idKmPorAnio, int idCantidadSiniestros, Double prima, Double descuento, Double derechoEmision, Double baseAnualPrima) {
        this.numeroPoliza = numeroPoliza;
        this.estadoPoliza = estadoPoliza;
        this.sumaAsegurada = sumaAsegurada;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.formaPago = formaPago;
        this.premio = premio;
        this.ultimoDiaPago = ultimoDiaPago;
        this.patente = patente;
        this.codigoMotor = codigoMotor;
        this.montoTotal = montoTotal;
        this.codigoChasis = codigoChasis;
        this.idTipoCobertura = idTipoCobertura;
        this.anio = anio;
        this.idModelo = idModelo;
        this.idLocalidad = idLocalidad;
        this.idMedida = idMedida;
        this.idKmPorAnio = idKmPorAnio;
        this.idCantidadSiniestros = idCantidadSiniestros;
        this.prima = prima;
        this.descuento = descuento;
        this.derechoEmision = derechoEmision;
        this.baseAnualPrima = baseAnualPrima;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public EstadoPoliza getEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(EstadoPoliza estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public Double getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(Double sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Double getPremio() {
        return premio;
    }

    public void setPremio(Double premio) {
        this.premio = premio;
    }

    public Date getUltimoDiaPago() {
        return ultimoDiaPago;
    }

    public void setUltimoDiaPago(Date ultimoDiaPago) {
        this.ultimoDiaPago = ultimoDiaPago;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getCodigoMotor() {
        return codigoMotor;
    }

    public void setCodigoMotor(String codigoMotor) {
        this.codigoMotor = codigoMotor;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getCodigoChasis() {
        return codigoChasis;
    }

    public void setCodigoChasis(String codigoChasis) {
        this.codigoChasis = codigoChasis;
    }

    public int getIdTipoCobertura() {
        return idTipoCobertura;
    }

    public void setIdTipoCobertura(int idTipoCobertura) {
        this.idTipoCobertura = idTipoCobertura;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public int[] getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(int[] idMedida) {
        this.idMedida = idMedida;
    }

    public int getIdKmPorAnio() {
        return idKmPorAnio;
    }

    public void setIdKmPorAnio(int idKmPorAnio) {
        this.idKmPorAnio = idKmPorAnio;
    }

    public int getIdCantidadSiniestros() {
        return idCantidadSiniestros;
    }

    public void setIdCantidadSiniestros(int idCantidadSiniestros) {
        this.idCantidadSiniestros = idCantidadSiniestros;
    }

    public Double getPrima() {
        return prima;
    }

    public void setPrima(Double prima) {
        this.prima = prima;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getDerechoEmision() {
        return derechoEmision;
    }

    public void setDerechoEmision(Double derechoEmision) {
        this.derechoEmision = derechoEmision;
    }

    public Double getBaseAnualPrima() {
        return baseAnualPrima;
    }

    public void setBaseAnualPrima(Double baseAnualPrima) {
        this.baseAnualPrima = baseAnualPrima;
    }
}
