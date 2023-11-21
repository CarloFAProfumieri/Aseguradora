package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Profesion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProfesion")
    private int idProfesion;
    @Basic
    @Column(name = "nombre")
    private String nombre;

    public int getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(int idProfesion) {
        this.idProfesion = idProfesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesion profesion = (Profesion) o;
        return idProfesion == profesion.idProfesion && Objects.equals(nombre, profesion.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfesion, nombre);
    }
}
