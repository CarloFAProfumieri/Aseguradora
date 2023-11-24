package com.example.aseguradora.gestores;

import com.example.aseguradora.DAOs.*;
import com.example.aseguradora.DTOs.ClienteDTO;
import com.example.aseguradora.DTOs.HijoDTO;
import com.example.aseguradora.DTOs.PolizaDTO;
import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.enumeraciones.FormaPago;
import com.example.aseguradora.persistentes.*;

import java.util.Date;
import java.util.List;

public class GestorPolizas {
    // Instancia única de la clase
    private static final GestorPolizas instancia = new GestorPolizas();
    private PolizaDAO polizaDAO;
    private ValorPorcentualHijoDAO valorPorcentualHijoDAO;
    private ClienteDAO clienteDAO;
    private CantidadSiniestrosDAO cantidadSiniestrosDAO;
    private KmPorAnioDAO kmPorAnioDAO;
    private LocalidadDAO localidadDAO;
    private ModeloDAO modeloDAO;
    private AnioDAO anioDAO;
    private TipoCoberturaDAO tipoCoberturaDAO;
    private MedidaSeguridadDAO medidaSeguridadDAO;
    private EstadoCivilDAO estadoCivilDAO;
    private MarcaDAO marcaDAO;
    private ProvinciaDAO provinciaDAO;
    /*private GestorPolizas() {
        polizaDAO = new PolizaDAO();
        valorPorcentualHijoDAO = new ValorPorcentualHijoDAO();
        clienteDAO = new ClienteDAO();
        cantidadSiniestrosDAO = new CantidadSiniestrosDAO();
        kmPorAnioDAO = new KmPorAnioDAO();
        localidadDAO = new LocalidadDAO();
        modeloDAO = new ModeloDAO();
        anioDAO = new AnioDAO();
        tipoCoberturaDAO = new TipoCoberturaDAO();
        marcaDAO = new MarcaDAO();
        medidaSeguridadDAO = new MedidaSeguridadDAO();
        provinciaDAO = new ProvinciaDAO();
    }*/
    public static GestorPolizas getInstancia() {
        return instancia;
    }
    public void darAltaPoliza(PolizaDTO unaPolizaDTO){
        polizaDAO.guardarPoliza(unaPolizaDTO);
    }
    public void emitirPoliza(){

    }
    public void consultarPoliza(){

    }
    public void generarInformeResultadoMensual(){

    }
    //pasar recuperacion de listas a un solo metodo
    public List<Marca> getMarcasList(){
        return marcaDAO.getAllMarcas();
    }
    public List<Provincia> getProvinciaList(){
        return provinciaDAO.getAllProvincias();
    }
    public List<Localidad> getLocalidadList(int idProvincia) {
        return localidadDAO.getLocalidades(idProvincia);
    }
    public List<ModeloVehiculo> getModelosList(int idMarca){
        PolizaDAO polizaDAO = new PolizaDAO();
        return modeloDAO.getModelos(idMarca);
    }
    public void guardarPoliza(PolizaDTO polizaDTO){
        polizaDAO.guardarPoliza(polizaDTO);
    }
    public List<TipoCobertura> getTiposDeCobertura() {
        return tipoCoberturaDAO.getAllTiposCobertura();
    }
    public void generarPoliza(PolizaDTO datosPoliza, List<HijoDTO> listaHijosDTO, ClienteDTO datosCliente) {
        Poliza poliza = new Poliza();
        poliza.setEstadoPoliza(EstadoPoliza.GENERADA);
        Cliente cliente = clienteDAO.obtenerClientePorNumero(datosCliente.getNumeroCliente());
        for (HijoDTO unHijo : listaHijosDTO) {
            EstadoCivil estadoCivil = estadoCivilDAO.getEstadoCivil(unHijo.getIdEstadoCivil());
            Hijo nuevoHijo = new Hijo(unHijo.getSexo(), unHijo.getFechaNacimiento() ,estadoCivil);
        }
        poliza.setCliente(datosCliente); // le mando el DTO o creo un cliente y se lo envio como objeto?
        poliza.setPoliza(datosPoliza);
    }

    public static void main(String[] args) {
        PolizaDTO polizaTest = new PolizaDTO(1,500.0, new Date(), new Date(), 1000.35, "ABC123",
                "123456", new Date(),20000, "XYZ789", 1, 123,
                456, 789, 2, 3, 4, FormaPago.MENSUAL, EstadoPoliza.VIGENTE);
        PolizaDAO DAO = new PolizaDAO();
        DAO.guardarPoliza(polizaTest);
        System.out.println("numero de poliza: " + polizaTest.getNumeroPoliza());
    }
}
