package com.example.aseguradora.DTOs;

import com.example.aseguradora.enumeraciones.FormaPago;
import com.example.aseguradora.persistentes.Cliente;
import com.example.aseguradora.persistentes.Poliza;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConfirmarPolizaDTO {
    private String titularSeguroApellido;
    private String titularSeguroNombre;
    private String vehiculoMarca;
    private String vehiculoModelo;
    private String vehiculoMotor;
    private String vehiculoChasis;
    private String vehiculoPatente;
    private LocalDate inicioCoberturaLocalDate;
    private LocalDate finalCoberturaLocalDate;
    private int sumaAsegurada;
    private Double premio;
    private int importePorDescuento;
    private FormaPago modalidadDePagoFormaPago;
    private List<LocalDate> ultimoDiaPagoLocalDateList;

    private List<Double> pagosPorCuotaList = new ArrayList<>();

    private Double montoTotal;

    private int idCliente;

    public ConfirmarPolizaDTO(PolizaDTO poliza, ClienteDTO cliente) {
        titularSeguroNombre = cliente.getNombre();
        titularSeguroApellido = cliente.getApellido();
        vehiculoMarca = poliza.getMarca();
        vehiculoModelo = poliza.getModelo();
        vehiculoMotor = poliza.getCodigoMotor();
        vehiculoChasis = poliza.getCodigoChasis();
        vehiculoPatente = poliza.getPatente();
        inicioCoberturaLocalDate = poliza.getFechaInicio();
        finalCoberturaLocalDate = poliza.getFechaFin();
        sumaAsegurada = poliza.getSumaAsegurada();
        premio = poliza.getPremio();
        importePorDescuento = 4231;
        modalidadDePagoFormaPago = poliza.getFormaPago();
        ultimoDiaPagoLocalDateList = poliza.getUltimoDiaPago();
        montoTotal = poliza.getMontoTotal();

        if (modalidadDePagoFormaPago.equals(FormaPago.SEMESTRAL)){
            pagosPorCuotaList.add(montoTotal);
        }

        if (modalidadDePagoFormaPago.equals(FormaPago.MENSUAL)){
            for(int i = 0;i<6;i++) {
                pagosPorCuotaList.add(montoTotal/6.0);
                if(i>0) {
                    ultimoDiaPagoLocalDateList.add(ultimoDiaPagoLocalDateList.getLast().plusMonths(1));
                }
            }
        }
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public int getIdCliente() {
        return idCliente;
    }

    public ConfirmarPolizaDTO() {

    }

    public List<Double> getPagosPorCuotaList() {
        return pagosPorCuotaList;
    }
    public void setPagosPorCuotaList(List<Double> pagosPorCuotaList) {
        this.pagosPorCuotaList = pagosPorCuotaList;
    }

    public String getTitularSeguroNombre() {
        return titularSeguroNombre;
    }

    public void setTitularSeguroNombre(String titularSeguroNombre) {
        this.titularSeguroNombre = titularSeguroNombre;
    }

    public String getTitularSeguroApellido() {
        return titularSeguroApellido;
    }

    public void setTitularSeguroApellido(String titularSeguroApellido) {
        this.titularSeguroApellido = titularSeguroApellido;
    }

    public String getVehiculoModelo() {
        return vehiculoModelo;
    }

    public void setVehiculoModelo(String vehiculoModelo) {
        this.vehiculoModelo = vehiculoModelo;
    }

    public String getVehiculoMarca() {
        return vehiculoMarca;
    }

    public void setVehiculoMarca(String vehiculoMarca) {
        this.vehiculoMarca = vehiculoMarca;
    }

    public String getVehiculoMotor() {
        return vehiculoMotor;
    }

    public void setVehiculoMotor(String vehiculoMotor) {
        this.vehiculoMotor = vehiculoMotor;
    }

    public String getVehiculoChasis() {
        return vehiculoChasis;
    }

    public void setVehiculoChasis(String vehiculoChasis) {
        this.vehiculoChasis = vehiculoChasis;
    }

    public String getVehiculoPatente() {
        return vehiculoPatente;
    }

    public void setVehiculoPatente(String vehiculoPatente) {
        this.vehiculoPatente = vehiculoPatente;
    }

    public LocalDate getInicioCoberturaLocalDate() {
        return inicioCoberturaLocalDate;
    }

    public void setInicioCoberturaLocalDate(LocalDate inicioCoberturaLocalDate) {
        this.inicioCoberturaLocalDate = inicioCoberturaLocalDate;
    }

    public LocalDate getFinalCoberturaLocalDate() {
        return finalCoberturaLocalDate;
    }

    public void setFinalCoberturaLocalDate(LocalDate finalCoberturaLocalDate) {
        this.finalCoberturaLocalDate = finalCoberturaLocalDate;
    }

    public int getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(int sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }

    public Double getPremio() {
        return premio;
    }

    public void setPremio(Double premio) {
        this.premio = premio;
    }

    public int getImportePorDescuento() {
        return importePorDescuento;
    }

    public void setImportePorDescuento(int importePorDescuento) {
        this.importePorDescuento = importePorDescuento;
    }

    public FormaPago getModalidadDePagoFormaPago() {
        return modalidadDePagoFormaPago;
    }

    public void setModalidadDePagoFormaPago(FormaPago modalidadDePagoFormaPago) {
        this.modalidadDePagoFormaPago = modalidadDePagoFormaPago;
    }

    public List<LocalDate> getUltimoDiaPagoLocalDateList() {
        return ultimoDiaPagoLocalDateList;
    }

    public void setUltimoDiaPagoLocalDateList(List<LocalDate> ultimoDiaPagoLocalDateList) {
        this.ultimoDiaPagoLocalDateList = ultimoDiaPagoLocalDateList;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }
}
