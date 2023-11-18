package com.example.aseguradora;

public class Hijo {
    private Integer edad;
    private Character sexo;
    private String estadoCivil;

    public Hijo(Integer edad, Character sexo, String estadoCivil) {
        this.edad = edad;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

    public Integer getEdad() {
        return edad;
    }

    public Character getSexo() {
        return sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
}
