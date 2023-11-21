package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Domicilio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idDomicilio")
    private int idDomicilio;
    @Basic
    @Column(name = "calle")
    private String calle;
    @Basic
    @Column(name = "altura")
    private Integer altura;
    @Basic
    @Column(name = "piso")
    private String piso;
    @Basic
    @Column(name = "departamento")
    private String departamento;
    @Basic
    @Column(name = "codigoPostal")
    private String codigoPostal;
    @Basic
    @Column(name = "idLocalidad")
    private Integer idLocalidad;

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return idDomicilio == domicilio.idDomicilio && Objects.equals(calle, domicilio.calle) && Objects.equals(altura, domicilio.altura) && Objects.equals(piso, domicilio.piso) && Objects.equals(departamento, domicilio.departamento) && Objects.equals(codigoPostal, domicilio.codigoPostal) && Objects.equals(idLocalidad, domicilio.idLocalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDomicilio, calle, altura, piso, departamento, codigoPostal, idLocalidad);
    }
}
