package com.example.aseguradora.persistentes;

import com.example.aseguradora.enumeraciones.Sexo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
public class Hijo {
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idHijo")
    private int idHijo;
    @Basic
    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;
    @ManyToOne
    @JoinColumn(name = "idEstadoCivil", referencedColumnName = "idEstadoCivil")
    private EstadoCivil estadoCivil;
    @ManyToOne
    @JoinColumn(name = "numeroPoliza")
    private Poliza poliza;
    public Hijo(LocalDate fechaNacimiento, Sexo sexo, EstadoCivil estadoCivil) {
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
    }

    public Hijo() {

    }

    public Hijo(Sexo sexo, LocalDate fechaNacimiento, EstadoCivil estadoCivil) {
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
    }

    public Integer edad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
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
