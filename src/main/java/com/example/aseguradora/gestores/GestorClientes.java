package com.example.aseguradora.gestores;

import com.example.aseguradora.DAOs.ClienteDAO;
import com.example.aseguradora.DTOs.ClienteDTO;
import com.example.aseguradora.DTOs.EstadoCivilDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GestorClientes {
    private static final GestorClientes instancia = new GestorClientes();
    private ClienteDAO clienteDAO;
    public void darAltaCliente() {
    }
    public void darDeBajaCliente() {
    }
    public void modificarCliente() {
    }
    public void consultarCliente() {
    }
    private GestorClientes() {
        clienteDAO = new ClienteDAO();
    }
    public static GestorClientes obtenerInstancia() {
        return instancia;
    }

    public List<ClienteDTO> getAllClientes() {
        return clienteDAO.obtenerTodosLosClientes()
                .stream()
                .map(cliente -> {
                    ClienteDTO clienteDTO = new ClienteDTO();
                    clienteDTO.setNumeroCliente(cliente.getNumeroCliente());
                    clienteDTO.setApellido(cliente.getApellido());
                    clienteDTO.setNombre(cliente.getNombre());
                    clienteDTO.setNumeroDocumento(cliente.getNumeroDocumento());
                    clienteDTO.setTipoDocumentoId(cliente.getTipoDocumento().getIdTipoDocumento());
                    clienteDTO.setTipoDocumento(cliente.getTipoDocumento().getNombre());
                    return clienteDTO;
                }).collect(Collectors.toList());
    }

}
