package com.example.aseguradora.DTOs;

public class AnioDTO implements Comparable<AnioDTO>{
    private int anio;

    public int getAnio() {
        return anio;
    }
    @Override
    public int compareTo(AnioDTO other) {
        return Integer.compare(other.anio, this.anio);
    }
    @Override
    public String toString() {
        return String.valueOf(anio);
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
