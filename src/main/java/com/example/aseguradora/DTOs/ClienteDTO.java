package com.example.aseguradora.DTOs;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class ClienteDTO {
    private int numeroCliente;
    private int tipoDocumentoId;
    private int numeroDocumento;
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;
    public ClienteDTO(int numeroCliente, int tipoDocumento, int numeroDocumento, String apellido, String nombre) {
        this.numeroCliente = numeroCliente;
        this.tipoDocumentoId = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public ClienteDTO() {

    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public void setTipoDocumento(int tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public int getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroClienteString() {
        return String.valueOf(numeroCliente);
    }

    public String getNumeroDocumentoString() {
        return String.valueOf(numeroDocumento);
    }

    public void setFechaNacimiento(LocalDate unaFechaNacimiento) {
        fechaNacimiento = unaFechaNacimiento;
    }
    public LocalDate getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    public int getEdadConductor() {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(this.fechaNacimiento, fechaActual);
        return periodo.getYears();
    }
}
