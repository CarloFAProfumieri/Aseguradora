package com.example.aseguradora.DTOs;

public class CuotaDTO {
    private int idCuota;
    private Double importeFinal;

    public CuotaDTO(int idCuota, Double importeFinal) {
        this.idCuota = idCuota;
        this.importeFinal = importeFinal;
    }

    public int getIdCuota() {
        return idCuota;
    }

    public Double getImporteFinal() {
        return importeFinal;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public void setImporteFinal(Double importeFinal) {
        this.importeFinal = importeFinal;
    }
}
