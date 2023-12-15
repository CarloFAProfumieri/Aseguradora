package com.example.aseguradora.DTOs;

import com.example.aseguradora.enumeraciones.Sexo;

import java.time.LocalDate;
import java.time.Period;

public class HijoDTO {
    private int idHijo;
    private LocalDate fechaNacimiento;
    private Sexo sexo;
    private int estadoCivilId;

    private int edad;

    //solo para visualizacion
    private String estadoCivil;

    @Override
    public String toString() {
        return "id: " + String.valueOf(idHijo)+ "- " + "fecha de nacimiento: "+fechaNacimiento.toString() + " sexo: " + sexo + " estado civil:"+ estadoCivil + " id: "+String.valueOf(estadoCivilId) + "Edad:"+String.valueOf(edad);
    }

    public HijoDTO(LocalDate fechaNacimiento, Sexo sexo, String estadoCivil, int estadoCivilId) {
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estadoCivilId = estadoCivilId;
        this.edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        this.estadoCivil = estadoCivil;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public HijoDTO() {

    }
    public Integer getEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public void setIdHijo(int idHijo) {
        this.idHijo = idHijo;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(Sexo sexo) {  // Cambiado a Sexo en lugar de String
        this.sexo = sexo;
    }

    public void setEstadoCivilId(int estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public int getIdHijo() {
        return idHijo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getEstadoCivilId() {
        return estadoCivilId;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
}