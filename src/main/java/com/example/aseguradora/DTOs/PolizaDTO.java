package com.example.aseguradora.DTOs;

import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.enumeraciones.FormaPago;

import java.util.Date;
import java.util.List;


public class PolizaDTO {
    private int numeroPoliza;
    private EstadoPoliza estadoPoliza;
    private int sumaAsegurada;
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
    private List<Integer> idMedida;
    private int idKmPorAnio;
    private int idCantidadSiniestros;
    private Double prima;
    private Double descuento;
    private Double derechoEmision;
    private Double baseAnualPrima;
    private Integer numeroCliente;
    private Integer idValorPorcentualHijo;
    private String marca;

    public PolizaDTO(int numeroPoliza, Double premio, Date fechaInicio, Date fechaFin, Double montoTotal, String patente, String codigoMotor, Date ultimoDiaPago, int sumaAsegurada, String codigoChasis, Integer idLocalidad, Integer numeroCliente, Integer idModelo, Integer idTipoCobertura, Integer idCantidadSiniestros, Integer idKmPorAnio, Integer idValorPorcentualHijo, FormaPago formaPago, EstadoPoliza estadoPoliza) {
        this.numeroPoliza = numeroPoliza;
        this.premio = premio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.montoTotal = montoTotal;
        this.patente = patente;
        this.codigoMotor = codigoMotor;
        this.ultimoDiaPago = ultimoDiaPago;
        this.sumaAsegurada = sumaAsegurada;
        this.codigoChasis = codigoChasis;
        this.numeroCliente = numeroCliente;
        this.idLocalidad = idLocalidad;
        this.idModelo = idModelo;
        this.idTipoCobertura = idTipoCobertura;
        this.idCantidadSiniestros = idCantidadSiniestros;
        this.idKmPorAnio = idKmPorAnio;
        this.idValorPorcentualHijo = idValorPorcentualHijo;
        this.formaPago = formaPago;
        this.estadoPoliza = estadoPoliza;
    }

    public PolizaDTO() {

    }

    public Integer getNumeroCliente() {
        return numeroCliente;
    }

    public Integer getIdValorPorcentualHijo() {
        return idValorPorcentualHijo;
    }

    public int getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(int numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public EstadoPoliza getEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(EstadoPoliza estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public int getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(int sumaAsegurada) {
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

    public List<Integer> getIdMedidas() {
        return idMedida;
    }

    public void setIdMedidas(List<Integer> idMedidaLista) {
        this.idMedida = idMedidaLista;
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

    public void setnumeroCliente(int unNumeroCliente) {
        numeroCliente = unNumeroCliente;
    }

    public void setPremioYDerechos(PremioyDerechosDTO premioYDerechosDTO) {
        //polizaDTO.setPrima();
        //polizaDTO.setDescuento();
        //polizaDTO.setDerechoEmision();
        //polizaDTO.setBaseAnualPrima();
        montoTotal = premioYDerechosDTO.getMontoTotal();
        prima = (double) premioYDerechosDTO.getPrima();
        descuento = (double) premioYDerechosDTO.getDescuento();
        derechoEmision = (double) premioYDerechosDTO.getDerechoEmision();
        baseAnualPrima = (double) premioYDerechosDTO.getBaseAnualPrima();

    }
    //AUXILIARES PARA PRESENTAR

}
