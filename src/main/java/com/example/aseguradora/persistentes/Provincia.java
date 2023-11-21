package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Provincia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProvincia")
    private int idProvincia;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "idPais")
    private Integer idPais;

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return idProvincia == provincia.idProvincia && Objects.equals(nombre, provincia.nombre) && Objects.equals(idPais, provincia.idPais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProvincia, nombre, idPais);
    }
}
