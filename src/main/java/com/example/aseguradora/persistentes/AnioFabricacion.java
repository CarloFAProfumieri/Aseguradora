package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class AnioFabricacion {
    @Id
    @Column(name = "anio")
    private int anio;

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnioFabricacion that = (AnioFabricacion) o;
        return anio == that.anio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anio);
    }
}
