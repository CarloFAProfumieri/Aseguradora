package com.example.aseguradora;

import com.example.aseguradora.DTOs.ClienteDTO;
import com.example.aseguradora.DTOs.PolizaDTO;
import com.example.aseguradora.DTOs.PremioyDerechosDTO;
import com.example.aseguradora.persistentes.Cliente;

import java.util.Random;

public class CalculadoraMontos{

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
    public static PremioyDerechosDTO calcularPremioyDerechos(PolizaDTO polizaDTO, ClienteDTO clienteDTO) {
        PremioyDerechosDTO premioyDerechosDTO = new PremioyDerechosDTO();

        // Lógica de cálculo (valores de prueba, ajusta según tus necesidades)
        int montoAsegurado = polizaDTO.getSumaAsegurada();
        int anio = polizaDTO.getAnio();
        int edadConductor = clienteDTO.getEdadConductor();

        premioyDerechosDTO.setPrima(montoAsegurado / 100); // Ejemplo: prima del 1% del monto asegurado
        premioyDerechosDTO.setDescuento(anio * 10); // Ejemplo: descuento de 10 por cada año de antigüedad
        premioyDerechosDTO.setDerechoEmision(edadConductor * 5); // Ejemplo: derecho de emisión de 5 por cada año de edad
        premioyDerechosDTO.setBaseAnualPrima(premioyDerechosDTO.getPrima() - premioyDerechosDTO.getDescuento());
        premioyDerechosDTO.setMontoTotal((double) (premioyDerechosDTO.getBaseAnualPrima() + premioyDerechosDTO.getDerechoEmision()));

        return premioyDerechosDTO;
    }

}