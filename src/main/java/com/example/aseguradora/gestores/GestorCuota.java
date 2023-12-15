package com.example.aseguradora.gestores;

import com.example.aseguradora.DAOs.CuotaDAO;
import com.example.aseguradora.DAOs.PolizaDAO;
import com.example.aseguradora.DTOs.ClienteDTO;

public class GestorCuota {
    private static final GestorCuota instancia = new GestorCuota();
    CuotaDAO cuotaDAO;
    private GestorCuota() {
        CuotaDAO cuotaDAO = new CuotaDAO();
    }
    public static GestorCuota obtenerInstancia() {
        return instancia;
    }

    public void darAltaCuota() {
    }
    public void consultarCuota(){

    }

    public boolean poseePolizasImpagas(ClienteDTO clienteDTO) {
        return cuotaDAO.poseePolizasImpagas(clienteDTO.getNumeroCliente());
    }
}
