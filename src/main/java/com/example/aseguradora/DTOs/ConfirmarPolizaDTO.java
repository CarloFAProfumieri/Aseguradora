package com.example.aseguradora.DTOs;

import com.example.aseguradora.enumeraciones.FormaPago;
import com.example.aseguradora.persistentes.Cliente;
import com.example.aseguradora.persistentes.Poliza;

import java.time.LocalDate;
import java.util.List;

public class ConfirmarPolizaDTO {
    private String numeroPoliza;
    private String titularSeguroNombre;
    private String titularSeguroApellido;
    private String vehiculoModelo;
    private String vehiculoMarca;
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
    private Double montoTotal;
    public ConfirmarPolizaDTO(Poliza poliza, Cliente cliente) {
        numeroPoliza = poliza.getNumeroPoliza();
        vehiculoMarca = poliza.getMarcaString();
        vehiculoModelo = poliza.getModelo().getNombre();
        vehiculoMotor = poliza.getCodigoMotor();
        vehiculoChasis = poliza.getCodigoChasis();
        vehiculoPatente = poliza.getPatente();
        inicioCoberturaLocalDate = poliza.getFechaInicio();
        finalCoberturaLocalDate = poliza.getFechaFin();
        sumaAsegurada = poliza.getSumaAsegurada();
        premio = poliza.getPremio();
        //importePorDescuento = poliza.getImportePorDescuento();!!!!!!!
        modalidadDePagoFormaPago = poliza.getFormaPago();
        ultimoDiaPagoLocalDateList = poliza.getUltimoDiaPago();
        montoTotal = poliza.getMontoTotal();
    }
}
