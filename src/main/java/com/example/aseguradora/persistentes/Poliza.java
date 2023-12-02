package com.example.aseguradora.persistentes;
import com.example.aseguradora.DTOs.PolizaDTO;
import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.enumeraciones.FormaPago;
import jakarta.persistence.*;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private LocalDate fechaInicio;
    @Basic
    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "ultimoDiaPago")
    @Temporal(TemporalType.DATE) // Esto especifica el tipo temporal de la columna
    private List<LocalDate> ultimoDiaPago = new ArrayList<>();

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
    @Column(name = "sumaAsegurada")
    private int sumaAsegurada;
    @Basic
    @Column(name = "codigoChasis")
    private String codigoChasis;
    @Basic
    @Column(name = "modeloAnio")
    private int modeloAnio;

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
    @OneToMany(mappedBy = "poliza")
    private List<Cuota> cuotas;
    @Enumerated(EnumType.STRING)
    @Column(name = "estadoPoliza")
    private EstadoPoliza estadoPoliza;
    @OneToOne(mappedBy = "poliza", cascade = CascadeType.ALL, orphanRemoval = true)
    private ParametrosMonto parametrosMonto;
    @ManyToMany
    @JoinTable(
            name = "polizaMedida",
            joinColumns = @JoinColumn(name = "numeroPoliza"),
            inverseJoinColumns = @JoinColumn(name = "idMedida")
    )
    private List<MedidaSeguridad> medidasSeguridadList = new ArrayList<>();
    public List<MedidaSeguridad> getMedidasSeguridadList() {
        return medidasSeguridadList;
    }
    public void addMedida(MedidaSeguridad medidaSeguridad){
        medidasSeguridadList.add(medidaSeguridad);
    }

    public void setMedidasSeguridadList(List<MedidaSeguridad> medidasSeguridadList) {
        this.medidasSeguridadList = medidasSeguridadList;
    }

    public void setModeloAnio(int modeloAnio) {
        this.modeloAnio = modeloAnio;
    }

    public int getModeloAnio() {
        return modeloAnio;
    }

    public Poliza() {

    }

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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
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

    public List<LocalDate> getUltimoDiaPago() {
        return ultimoDiaPago;
    }

    public void setUltimoDiaPago(List<LocalDate> ultimoDiaPago) {
        this.ultimoDiaPago = ultimoDiaPago;
    }
    public void addUltimoDiaPago(LocalDate diaDePago){
        this.ultimoDiaPago.add(diaDePago);
    }

    public void setCodigoMotor(String codigoMotor) {
        this.codigoMotor = codigoMotor;
    }

    public int getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(int sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }

    public String getCodigoChasis() {
        return codigoChasis;
    }

    public void setCodigoChasis(String codigoChasis) {
        this.codigoChasis = codigoChasis;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public ModeloVehiculo getModelo() {
        return modelo;
    }

    public void setModelo(ModeloVehiculo modelo) {
        this.modelo = modelo;
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

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public EstadoPoliza getEstadoPoliza() {
        return estadoPoliza;
    }

    public ParametrosMonto getParametrosMonto() {
        return parametrosMonto;
    }

    public void setParametrosMonto(ParametrosMonto parametrosMonto) {
        this.parametrosMonto = parametrosMonto;
    }

    public void setEstadoPoliza(EstadoPoliza estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public void setAtributosPoliza(PolizaDTO datosPolizaDTO) {
        this.estadoPoliza = datosPolizaDTO.getEstadoPoliza();
        this.codigoChasis = datosPolizaDTO.getCodigoChasis();
        this.codigoMotor = datosPolizaDTO.getCodigoMotor();
        this.fechaInicio = datosPolizaDTO.getFechaInicio();
        this.fechaFin = datosPolizaDTO.getFechaFin();
        this.montoTotal = datosPolizaDTO.getMontoTotal();
        this.sumaAsegurada = datosPolizaDTO.getSumaAsegurada();
        this.premio = datosPolizaDTO.getPremio();
        this.patente = datosPolizaDTO.getPatente();
        this.formaPago = datosPolizaDTO.getFormaPago();
    }

    public void addCuotas(List<Cuota> cuotasLista) {
        this.cuotas = cuotasLista;
    }
}
