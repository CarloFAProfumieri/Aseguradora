package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ModificacionProximaPoliza {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idModificacion")
    private int idModificacion;
    @Basic
    @Column(name = "fechaModificacion")
    private LocalDate fechaModificacion;
    @Basic
    @Column(name = "patente")
    private String patente;
    @Basic
    @Column(name = "codigoMotor")
    private String codigoMotor;
    @Basic
    @Column(name = "codigoChasis")
    private String codigoChasis;
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
    @ManyToOne
    @JoinColumn(name = "numeroPoliza")
    private Poliza poliza;
    @ManyToMany
    @JoinTable(
            name = "Prox_Med_seg",
            joinColumns = @JoinColumn(name = "idModificacion"),
            inverseJoinColumns = @JoinColumn(name = "idMedida")
    )
    private List<MedidaSeguridad> medidasSeguridad;
    @ManyToMany
    @JoinTable(
            name = "Prox_Hijos",
            joinColumns = @JoinColumn(name = "idModificacion"),
            inverseJoinColumns = @JoinColumn(name = "idHijo")
    )
    private List<Hijo> hijos;


    public int getIdModificacion() {
        return idModificacion;
    }
    public void setIdModificacion(int idModificacion) {
        this.idModificacion = idModificacion;
    }
    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }
    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
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
    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }
    public void setTipoCobertura(TipoCobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }
    public CantidadSiniestros getCantidadSiniestros() {
        return cantidadSiniestros;
    }
    public void setCantidadSiniestros(CantidadSiniestros cantidadSiniestros) {
        this.cantidadSiniestros = cantidadSiniestros;
    }
    public KmPorAnio getKmPorAnio() {
        return kmPorAnio;
    }
    public void setKmPorAnio(KmPorAnio kmPorAnio) {
        this.kmPorAnio = kmPorAnio;
    }
    public ValorPorcentualHijo getValorPorcentualHijo() {
        return valorPorcentualHijo;
    }
    public void setValorPorcentualHijo(ValorPorcentualHijo valorPorcentualHijo) {
        this.valorPorcentualHijo = valorPorcentualHijo;
    }
    public Poliza getPoliza() {
        return poliza;
    }
    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }
    public List<MedidaSeguridad> getMedidasSeguridad() {
        return medidasSeguridad;
    }
    public void setMedidasSeguridad(List<MedidaSeguridad> medidasSeguridad) {
        this.medidasSeguridad = medidasSeguridad;
    }
    public List<Hijo> getHijos() {
        return hijos;
    }
    public void setHijos(List<Hijo> hijos) {
        this.hijos = hijos;
    }
}