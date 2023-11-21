package com.example.aseguradora.persistentes;
import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.enumeraciones.FormaPago;
import jakarta.persistence.*;

import javax.persistence.Entity;
import java.sql.Date;
import java.util.Objects;

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
    private Double sumaAsegurada;
    @Basic
    @Column(name = "codigoChasis")
    private String codigoChasis;
    @Basic
    @Column(name = "idLocalidad")
    private Integer idLocalidad;
    @Basic
    @Column(name = "numeroCliente")
    private Integer numeroCliente;
    @Basic
    @Column(name = "idModelo")
    private Integer idModelo;
    @Basic
    @Column(name = "idTipoCobertura")
    private Integer idTipoCobertura;
    @Basic
    @Column(name = "idCantidadSiniestros")
    private Integer idCantidadSiniestros;
    @Basic
    @Column(name = "idKmPorAnio")
    private Integer idKmPorAnio;
    @Basic
    @Column(name = "idValorPorcentualHijo")
    private Integer idValorPorcentualHijo;
    @Enumerated(EnumType.STRING)
    @Column(name = "formaPago")
    private FormaPago formaPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "estadoPoliza")
    private EstadoPoliza estadoPoliza;

    public int getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(int numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Double getPremio() {
        return premio;
    }

    public void setPremio(Double premio) {
        this.premio = premio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getCodigoMotor() {
        return codigoMotor;
    }

    public void setCodigoMotor(String codigoMotor) {
        this.codigoMotor = codigoMotor;
    }

    public Date getUltimoDiaPago() {
        return ultimoDiaPago;
    }

    public void setUltimoDiaPago(Date ultimoDiaPago) {
        this.ultimoDiaPago = ultimoDiaPago;
    }

    public Double getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(Double sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }

    public String getCodigoChasis() {
        return codigoChasis;
    }

    public void setCodigoChasis(String codigoChasis) {
        this.codigoChasis = codigoChasis;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Integer getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(Integer numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Integer getIdTipoCobertura() {
        return idTipoCobertura;
    }

    public void setIdTipoCobertura(Integer idTipoCobertura) {
        this.idTipoCobertura = idTipoCobertura;
    }

    public Integer getIdCantidadSiniestros() {
        return idCantidadSiniestros;
    }

    public void setIdCantidadSiniestros(Integer idCantidadSiniestros) {
        this.idCantidadSiniestros = idCantidadSiniestros;
    }

    public Integer getIdKmPorAnio() {
        return idKmPorAnio;
    }

    public void setIdKmPorAnio(Integer idKmPorAnio) {
        this.idKmPorAnio = idKmPorAnio;
    }

    public Integer getIdValorPorcentualHijo() {
        return idValorPorcentualHijo;
    }

    public void setIdValorPorcentualHijo(Integer idValorPorcentualHijo) {
        this.idValorPorcentualHijo = idValorPorcentualHijo;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public EstadoPoliza getEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(EstadoPoliza estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poliza poliza = (Poliza) o;
        return numeroPoliza == poliza.numeroPoliza && Objects.equals(premio, poliza.premio) && Objects.equals(fechaInicio, poliza.fechaInicio) && Objects.equals(fechaFin, poliza.fechaFin) && Objects.equals(montoTotal, poliza.montoTotal) && Objects.equals(patente, poliza.patente) && Objects.equals(codigoMotor, poliza.codigoMotor) && Objects.equals(ultimoDiaPago, poliza.ultimoDiaPago) && Objects.equals(sumaAsegurada, poliza.sumaAsegurada) && Objects.equals(codigoChasis, poliza.codigoChasis) && Objects.equals(idLocalidad, poliza.idLocalidad) && Objects.equals(numeroCliente, poliza.numeroCliente) && Objects.equals(idModelo, poliza.idModelo) && Objects.equals(idTipoCobertura, poliza.idTipoCobertura) && Objects.equals(idCantidadSiniestros, poliza.idCantidadSiniestros) && Objects.equals(idKmPorAnio, poliza.idKmPorAnio) && Objects.equals(idValorPorcentualHijo, poliza.idValorPorcentualHijo) && Objects.equals(formaPago, poliza.formaPago) && Objects.equals(estadoPoliza, poliza.estadoPoliza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroPoliza, premio, fechaInicio, fechaFin, montoTotal, patente, codigoMotor, ultimoDiaPago, sumaAsegurada, codigoChasis, idLocalidad, numeroCliente, idModelo, idTipoCobertura, idCantidadSiniestros, idKmPorAnio, idValorPorcentualHijo, formaPago, estadoPoliza);
    }
}
