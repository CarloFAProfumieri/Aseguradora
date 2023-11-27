package com.example.aseguradora.persistentes;
import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.enumeraciones.FormaPago;
import jakarta.persistence.*;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@jakarta.persistence.Entity
@Entity
public class Poliza {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numeroPoliza")
    private int numeroPoliza;
    @Basic
    @Column(name = "premio")
    private Double premio;
    @Basic
    @Column(name = "fechaInicio")
    private Date fechaInicio;
    @Basic
    @Column(name = "fechaFin")
    private Date fechaFin;
    @Basic
    @Column(name = "montoTotal")
    private Double montoTotal;
    @Basic
    @Column(name = "patente")
    private String patente;
    @Basic
    @Column(name = "codigoMotor")
    private String codigoMotor;
    @Basic
    @Column(name = "ultimoDiaPago")
    private Date ultimoDiaPago;
    @Basic
    @Column(name = "sumaAsegurada")
    private int sumaAsegurada;
    @Basic
    @Column(name = "codigoChasis")
    private String codigoChasis;
    @ManyToOne
    @JoinColumn(name = "numeroCliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "idLocalidad")
    private Localidad localidad;
    @ManyToOne
    @JoinColumn(name = "idModelo")
    private ModeloVehiculo modelo;
    @ManyToOne
    @JoinColumn(name = "idTipoCobertura")
    private TipoCobertura tipoCobertura;
    @ManyToOne
    @JoinColumn(name = "idCantidadSiniestros")
    private CantidadSiniestros cantidadSiniestros;
    @ManyToOne
    @JoinColumn(name = "idKmPorAnio")
    private KmPorAnio kmPorAnio;
    @ManyToOne
    @JoinColumn(name = "idValorPorcentualHijo")
    private ValorPorcentualHijo valorPorcentualHijo;
    @Enumerated(EnumType.STRING)
    @Column(name = "formaPago")
    private FormaPago formaPago;
    @OneToMany(mappedBy = "poliza") // "cliente" es el nombre del atributo en la clase Poliza
    private List<Cuota> cuotas;
    @Enumerated(EnumType.STRING)
    @Column(name = "estadoPoliza")
    private EstadoPoliza estadoPoliza;
    @OneToOne(mappedBy = "poliza", cascade = CascadeType.ALL, orphanRemoval = true)
    private ParametrosMonto parametrosMonto;
    public Poliza() {

    }

    public void setEstadoPoliza(EstadoPoliza estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

}
