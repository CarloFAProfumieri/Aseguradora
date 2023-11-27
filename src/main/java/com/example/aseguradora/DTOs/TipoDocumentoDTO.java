package com.example.aseguradora.DTOs;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;

public class TipoDocumentoDTO {
    private int idTipoDocumento;
    private String nombre;

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString(){
        return nombre;
    }
}
