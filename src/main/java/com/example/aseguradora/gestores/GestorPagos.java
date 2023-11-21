package com.example.aseguradora.gestores;

public class GestorPagos {
    private static final GestorPagos instancia = new GestorPagos();
    private GestorPagos(){

    }
    public static GestorPagos obtenerInstancia() {
        return instancia;
    }

}
