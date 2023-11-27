package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "idLocalidad")
    private Localidad localidad;

}
