package com.example.aseguradora.persistentes;

import com.example.aseguradora.enumeraciones.Sexo;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Hijo {
    private Integer edad;
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idHijo")
    private int idHijo;
    @Basic
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;
    @ManyToOne
    @JoinColumn(name = "idEstadoCivil", referencedColumnName = "idEstadoCivil")
    private EstadoCivil estadoCivil;

    public Hijo(Integer edad, Sexo sexo, EstadoCivil estadoCivil) {
        this.edad = edad;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

    public Hijo() {

    }

    public Hijo(Sexo sexo, Date fechaNacimiento, EstadoCivil estadoCivil) {
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
    }

    public Integer getEdad() {
        return edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public int getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(int idHijo) {
        this.idHijo = idHijo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hijo hijo = (Hijo) o;
        return idHijo == hijo.idHijo && Objects.equals(sexo, hijo.sexo) && Objects.equals(fechaNacimiento, hijo.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHijo, fechaNacimiento, sexo);
    }


}
