package com.example.aseguradora.DTOs;

public class DatosPolCU18DTO {
    private int numeroCliente;
    private int numeroPoliza;
    private String nombre;
    private String apellido;
    private int idTipoDoc;
    private int numeroDocumento;
    private int idUltCuota;

    public DatosPolCU18DTO(int numeroCliente, int numeroPoliza, String nombre, String apellido, int idTipoDoc, int numeroDocumento, int idUltCuota) {
        this.numeroCliente = numeroCliente;
        this.numeroPoliza = numeroPoliza;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idTipoDoc = idTipoDoc;
        this.numeroDocumento = numeroDocumento;
        this.idUltCuota = idUltCuota;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public void setNumeroPoliza(int numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setIdTipoDoc(int idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setIdUltCuota(int idUltCuota) {
        this.idUltCuota = idUltCuota;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public int getNumeroPoliza() {
        return numeroPoliza;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getIdTipoDoc() {
        return idTipoDoc;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public int getIdUltCuota() {
        return idUltCuota;
    }
}
