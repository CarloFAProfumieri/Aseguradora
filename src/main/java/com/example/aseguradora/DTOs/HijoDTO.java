package com.example.aseguradora.DTOs;

import com.example.aseguradora.enumeraciones.Sexo;

import java.sql.Date;

public class HijoDTO {
    private int idHijo;
    private Date fechaNacimiento;
    private Sexo sexo;  // Debería ser del tipo Sexo, no String
    private int idEstadoCivil;

    public HijoDTO(int idHijo, Date fechaNacimiento, Sexo sexo, int idEstadoCivil) {
        this.idHijo = idHijo;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.idEstadoCivil = idEstadoCivil;
    }

    public HijoDTO() {

    }

    public void setIdHijo(int idHijo) {
        this.idHijo = idHijo;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setSexo(Sexo sexo) {  // Cambiado a Sexo en lugar de String
        this.sexo = sexo;
    }


    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public int getIdHijo() {
        return idHijo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }
}