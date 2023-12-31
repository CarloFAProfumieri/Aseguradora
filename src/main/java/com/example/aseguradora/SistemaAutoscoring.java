package com.example.aseguradora;

import com.example.aseguradora.DTOs.ClienteDTO;
import com.example.aseguradora.DTOs.PolizaDTO;
import com.example.aseguradora.DTOs.ParametrosMontoDTO;

import java.util.Random;

public class SistemaAutoscoring {

    public static int calcularSumaAsegurada(int idModelo, int anio) {
        return generarSumaAseguradaAleatoria(3000000 + idModelo, 20000000 + anio);
    }

    private static int generarSumaAseguradaAleatoria(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("El valor mínimo debe ser menor que el valor máximo");
        }

        Random random = new Random();
        long range = (long) max - (long) min + 1;
        long generatedValue = (long) (min + range * random.nextDouble());
        return (int) Math.min(generatedValue, Integer.MAX_VALUE);
    }
    public static ParametrosMontoDTO calcularPremioyDerechos(PolizaDTO polizaDTO, ClienteDTO clienteDTO) {
        ParametrosMontoDTO parametrosMontoDTO = new ParametrosMontoDTO();

        // Lógica de cálculo (valores de prueba, ajusta según tus necesidades)
        int montoAsegurado = polizaDTO.getSumaAsegurada();
        int anio = polizaDTO.getAnio();
        int edadConductor = clienteDTO.getEdadConductor();
        parametrosMontoDTO.setPrima(montoAsegurado / 100); // Ejemplo: prima del 1% del monto asegurado
        parametrosMontoDTO.setDescuento(anio * 10); // Ejemplo: descuento de 10 por cada año de antigüedad
        parametrosMontoDTO.setDerechoEmision(edadConductor * 5); // Ejemplo: derecho de emisión de 5 por cada año de edad
        parametrosMontoDTO.setPremio(parametrosMontoDTO.getPrima() + parametrosMontoDTO.getDerechoEmision());
        parametrosMontoDTO.setBaseAnualPrima(parametrosMontoDTO.getPrima() - parametrosMontoDTO.getDescuento());
        parametrosMontoDTO.setMontoTotal((double) (parametrosMontoDTO.getPremio() - parametrosMontoDTO.getDescuento()));

        return parametrosMontoDTO;
    }

    public static int getSecuenciaRenovacion() {
        Random random = new Random();
        return random.nextInt(100);
    }
    public static int getSucursal() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static int getCantidadSiniestros() {
        Random random = new Random();
        return random.nextInt(4)+1;
    }
}