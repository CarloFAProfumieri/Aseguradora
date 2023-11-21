package com.example.aseguradora.persistentes;

import com.example.aseguradora.enumeraciones.EstadoCliente;
import com.example.aseguradora.enumeraciones.Sexo;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numeroCliente")
    private int numeroCliente;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "apellido")
    private String apellido;
    @Basic
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;
    @Basic
    @Column(name = "cuil")
    private String cuil;
    @Basic
    @Column(name = "numeroDocumento")
    private Integer numeroDocumento;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "anioRegistro")
    private Integer anioRegistro;
    @Basic
    @Column(name = "idTipoDocumento")
    private Integer idTipoDocumento;
    @Basic
    @Column(name = "idEstadoCivil")
    private Integer idEstadoCivil;
    @Basic
    @Column(name = "idCondicionIVA")
    private Integer idCondicionIva;
    @Basic
    @Column(name = "idProfesion")
    private Integer idProfesion;
    @Basic
    @Column(name = "idDomicilio")
    private Integer idDomicilio;
    @Enumerated(EnumType.STRING)
    @Column(name = "estadoCliente")
    private EstadoCliente estadoCliente;
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAnioRegistro() {
        return anioRegistro;
    }

    public void setAnioRegistro(Integer anioRegistro) {
        this.anioRegistro = anioRegistro;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public Integer getIdCondicionIva() {
        return idCondicionIva;
    }

    public void setIdCondicionIva(Integer idCondicionIva) {
        this.idCondicionIva = idCondicionIva;
    }

    public Integer getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Integer idProfesion) {
        this.idProfesion = idProfesion;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Object getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(EstadoCliente estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public Object getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return numeroCliente == cliente.numeroCliente && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(fechaNacimiento, cliente.fechaNacimiento) && Objects.equals(cuil, cliente.cuil) && Objects.equals(numeroDocumento, cliente.numeroDocumento) && Objects.equals(email, cliente.email) && Objects.equals(anioRegistro, cliente.anioRegistro) && Objects.equals(idTipoDocumento, cliente.idTipoDocumento) && Objects.equals(idEstadoCivil, cliente.idEstadoCivil) && Objects.equals(idCondicionIva, cliente.idCondicionIva) && Objects.equals(idProfesion, cliente.idProfesion) && Objects.equals(idDomicilio, cliente.idDomicilio) && Objects.equals(estadoCliente, cliente.estadoCliente) && Objects.equals(sexo, cliente.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCliente, nombre, apellido, fechaNacimiento, cuil, numeroDocumento, email, anioRegistro, idTipoDocumento, idEstadoCivil, idCondicionIva, idProfesion, idDomicilio, estadoCliente, sexo);
    }
}
