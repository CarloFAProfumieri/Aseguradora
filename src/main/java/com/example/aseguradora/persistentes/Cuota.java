package com.example.aseguradora.persistentes;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Cuota {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCuota")
    private int idCuota;
    @ManyToOne
    @JoinColumn(name = "numeroPoliza")
    private Poliza poliza;
    @Basic // se registra al realizar el pago
    @Column(name = "fechaPago")
    private LocalDate fechaPago;
    @Basic
    @Column(name = "ultimoDiaDePago")
    private LocalDate ultimoDiaDePago;
    @Basic
    @Column(name = "importeOriginal")
    private Double importeOriginal;
    @Basic
    @Column(name = "importeFinal")
    private Double importeFinal;

    public Cuota() {

    }

    public Cuota(LocalDate vencimiento) {
        ultimoDiaDePago = vencimiento;
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public LocalDate getUltimoDiaDePago() {
        return ultimoDiaDePago;
    }

    public void setUltimoDiaDePago(LocalDate ultimoDiaDePago) {
        this.ultimoDiaDePago = ultimoDiaDePago;
    }

    public Double getImporteOriginal() {
        return importeOriginal;
    }

    public void setImporte(Double importeOriginal) {
        this.importeOriginal = importeOriginal;
    }

    public Double getImporteFinal() {
        return importeFinal;
    }

    public void setImporteFinal(Double importeFinal) {
        this.importeFinal = importeFinal;
    }
}
