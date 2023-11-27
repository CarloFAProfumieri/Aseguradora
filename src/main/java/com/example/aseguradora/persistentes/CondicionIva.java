package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class CondicionIva {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCondicion")
    private int idCondicion;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    public int getIdCondicion() {
        return idCondicion;
    }

    @OneToMany(mappedBy = "condicionIVA")
    private List<Cliente> clienteList;

    public void setIdCondicion(int idCondicion) {
        this.idCondicion = idCondicion;
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
        CondicionIva that = (CondicionIva) o;
        return idCondicion == that.idCondicion && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCondicion, nombre);
    }
}
