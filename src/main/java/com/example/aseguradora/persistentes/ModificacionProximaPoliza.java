package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class ModificacionProximaPoliza {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idModificacion")
    private int idModificacion;
    @Basic
    @Column(name = "patente")
    private String patente;
    @Basic
    @Column(name = "codigoMotor")
    private String codigoMotor;
    @Basic
    @Column(name = "codigoChasis")
    private String codigoChasis;
    @Basic
    @Column(name = "fechaModificacion")
    private Date fechaModificacion;
    @Basic
    @Column(name = "idCantidadSiniestros")
    private Integer idCantidadSiniestros;
    @Basic
    @Column(name = "idKmPorAnio")
    private Integer idKmPorAnio;
    @Basic
    @Column(name = "idValorPorcentualHijo")
    private Integer idValorPorcentualHijo;
    @Basic
    @Column(name = "idTipoCobertura")
    private Integer idTipoCobertura;
    @Basic
    @Column(name = "numeroPoliza")
    private Integer numeroPoliza;

    public int getIdModificacion() {
        return idModificacion;
    }

    public void setIdModificacion(int idModificacion) {
        this.idModificacion = idModificacion;
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

    public String getCodigoChasis() {
        return codigoChasis;
    }

    public void setCodigoChasis(String codigoChasis) {
        this.codigoChasis = codigoChasis;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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

    public Integer getIdTipoCobertura() {
        return idTipoCobertura;
    }

    public void setIdTipoCobertura(Integer idTipoCobertura) {
        this.idTipoCobertura = idTipoCobertura;
    }

    public Integer getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(Integer numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModificacionProximaPoliza that = (ModificacionProximaPoliza) o;
        return idModificacion == that.idModificacion && Objects.equals(patente, that.patente) && Objects.equals(codigoMotor, that.codigoMotor) && Objects.equals(codigoChasis, that.codigoChasis) && Objects.equals(fechaModificacion, that.fechaModificacion) && Objects.equals(idCantidadSiniestros, that.idCantidadSiniestros) && Objects.equals(idKmPorAnio, that.idKmPorAnio) && Objects.equals(idValorPorcentualHijo, that.idValorPorcentualHijo) && Objects.equals(idTipoCobertura, that.idTipoCobertura) && Objects.equals(numeroPoliza, that.numeroPoliza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idModificacion, patente, codigoMotor, codigoChasis, fechaModificacion, idCantidadSiniestros, idKmPorAnio, idValorPorcentualHijo, idTipoCobertura, numeroPoliza);
    }
}
