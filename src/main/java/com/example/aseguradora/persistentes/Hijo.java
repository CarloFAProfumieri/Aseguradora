package com.example.aseguradora.persistentes;

import com.example.aseguradora.enumeraciones.Sexo;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Hijo {
    private Integer edad;
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;
    private String estadoCivil;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idHijo")
    private int idHijo;
    @Basic
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;
    @Basic
    @Column(name = "idEstadoCivil")
    private Integer idEstadoCivil;

    public Hijo(Integer edad, Sexo sexo, String estadoCivil) {
        this.edad = edad;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

    public Hijo() {

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

    public String getEstadoCivil() {
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

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hijo hijo = (Hijo) o;
        return idHijo == hijo.idHijo && Objects.equals(sexo, hijo.sexo) && Objects.equals(fechaNacimiento, hijo.fechaNacimiento) && Objects.equals(idEstadoCivil, hijo.idEstadoCivil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHijo, fechaNacimiento, idEstadoCivil, sexo);
    }
}
