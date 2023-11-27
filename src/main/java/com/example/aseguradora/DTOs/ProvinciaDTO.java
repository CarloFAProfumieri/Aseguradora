package com.example.aseguradora.DTOs;

import com.example.aseguradora.persistentes.Localidad;
import com.example.aseguradora.persistentes.Provincia;

import java.util.List;

public class ProvinciaDTO implements Comparable<ProvinciaDTO> {
    private int idProvincia;
    private String nombre;

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }
    @Override
    public int compareTo(ProvinciaDTO otraProvincia) {
        // Implementa la lógica de comparación basada en el nombre de la provincia
        return this.nombre.compareTo(otraProvincia.nombre);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public List<LocalidadDTO> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<LocalidadDTO> localidades) {
        this.localidades = localidades;
    }

    private int idPais;
    private List<LocalidadDTO> localidades; //CONSULTA
    public String toString(){
        return nombre;
    }
}
