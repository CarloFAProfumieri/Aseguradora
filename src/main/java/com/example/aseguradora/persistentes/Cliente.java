package com.example.aseguradora.persistentes;

import com.example.aseguradora.enumeraciones.EstadoCliente;
import com.example.aseguradora.enumeraciones.Sexo;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

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
    private LocalDate fechaNacimiento;
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
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Poliza> polizas;
    @ManyToOne
    @JoinColumn(name = "idCondicionIVA")
    private CondicionIva condicionIVA;
    @ManyToOne
    @JoinColumn(name = "idTipoDocumento")
    private TipoDocumento tipoDocumento;
    @ManyToOne
    @JoinColumn(name = "idEstadoCivil")
    private EstadoCivil estadoCivil;
    @ManyToOne
    @JoinColumn(name = "idProfesion")
    private Profesion profesion;
    @ManyToOne
    @JoinColumn(name = "idDomicilio") // Nombre de la columna que actúa como clave externa
    private Domicilio domicilio;
    @Enumerated(EnumType.STRING)
    @Column(name = "estadoCliente")
    private EstadoCliente estadoCliente;
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;
    @Column(name = "activoDesde")
    private LocalDate activoDesde;

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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
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


    public CondicionIva getCondicionIVA() {
        return condicionIVA;
    }

    public void setCondicionIVA(CondicionIva condicionIVA) {
        this.condicionIVA = condicionIVA;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public EstadoCliente getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(EstadoCliente estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public List<Poliza> getPolizas() {
        return polizas;
    }

    public void setPolizas(List<Poliza> polizas) {
        this.polizas = polizas;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setEstado(EstadoCliente estadoCliente) {
        this.estadoCliente= estadoCliente;
    }
}
