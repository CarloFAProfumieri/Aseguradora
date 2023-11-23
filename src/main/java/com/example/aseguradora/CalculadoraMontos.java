package com.example.aseguradora;

import java.util.Random;

public class CalculadoraMontos{

    public static int calcularSumaAsegurada() {
        return generarSumaAseguradaAleatoria(3000000, 20000000);
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



}