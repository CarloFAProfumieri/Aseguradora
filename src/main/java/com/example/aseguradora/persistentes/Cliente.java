package com.example.aseguradora.persistentes;

import com.example.aseguradora.enumeraciones.EstadoCliente;
import com.example.aseguradora.enumeraciones.Sexo;
import jakarta.persistence.*;

import java.sql.Date;
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
    @OneToMany(mappedBy = "cliente") // "cliente" es el nombre del atributo en la clase Poliza
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

}
