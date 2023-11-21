package com.example.aseguradora.gestores;

import com.example.aseguradora.persistentes.Usuario;

import java.util.List;

public class GestorAutentificacion {
    // Instancia única de la clase
    private static final GestorAutentificacion instancia = new GestorAutentificacion();
    private List<Usuario> sesionesActivas;
    private GestorAutentificacion() {
    }
    public static GestorAutentificacion obtenerInstancia() {
        return instancia;
    }

    public void autenticarUsuario(){

    }
    public void verificarPermisos(){

    }
    public void iniciarSesion(){

    }
}
