package com.example.aseguradora.gestores;

import com.example.aseguradora.DAOs.*;
import com.example.aseguradora.DTOs.*;
import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.enumeraciones.FormaPago;
import com.example.aseguradora.persistentes.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    private TipoDocumentoDAO tipoDocumentoDAO;
    private GestorPolizas() {
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
        estadoCivilDAO = new EstadoCivilDAO();
        tipoDocumentoDAO = new TipoDocumentoDAO();
    }
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
    public List<MarcaDTO> getMarcasList(){
        List<MarcaDTO> dTOs = new ArrayList<>();
        List<Marca> marcas = marcaDAO.getAllMarcas();
        for (Marca marca : marcas){
            MarcaDTO marcaDTO = new MarcaDTO();
            marcaDTO.setIdMarca(marca.getIdMarca());
            marcaDTO.setNombre(marca.getNombre());
            dTOs.add(marcaDTO);
        }
        return dTOs;
    }
    public List<ModeloDTO> getModelosList(int idMarca){
        return modeloDAO.getModelos(idMarca)
                .stream()
                .map(modelo -> {
                    ModeloDTO modeloDTO = new ModeloDTO();
                    modeloDTO.setIdModelo(modelo.getIdModelo());
                    modeloDTO.setIdMarca(idMarca);
                    modeloDTO.setNombre(modelo.getNombre());
                    // Set other properties as needed
                    return modeloDTO;
                })
                .collect(Collectors.toList());
    }
    public List<CantidadSiniestrosDTO> getAllCantidadSiniestros(){
        return cantidadSiniestrosDAO.getAll()
                .stream()
                .map(cantidadSiniestros -> {
                    CantidadSiniestrosDTO cantidadSiniestrosDTO = new CantidadSiniestrosDTO();
                    cantidadSiniestrosDTO.setIdCantidadSiniestros(cantidadSiniestros.getIdCantidadSiniestros());
                    cantidadSiniestrosDTO.setCantidad(cantidadSiniestros.getCantidad());
                    cantidadSiniestrosDTO.setValorPorcentual(cantidadSiniestros.getValorPorcentual());
                    cantidadSiniestrosDTO.setDescripcion(cantidadSiniestros.getDescripcion());
                    return cantidadSiniestrosDTO;
                }).collect(Collectors.toList());
    }
    public List<ProvinciaDTO> getProvinciaList(){
        return provinciaDAO.getAllProvincias()
                .stream()
                .map(provincia -> {
                    ProvinciaDTO provinciaDTO = new ProvinciaDTO();
                    provinciaDTO.setIdProvincia(provincia.getIdProvincia());
                    provinciaDTO.setNombre(provincia.getNombre());
                    return provinciaDTO;
                }).collect(Collectors.toList());
    }
    public List<TipoDocumentoDTO> getTiposDocumento(){
        return tipoDocumentoDAO.getAll()
                .stream()
                .map(tipoDocumento -> {
                    TipoDocumentoDTO tipoDocumentoDTO = new TipoDocumentoDTO();
                    tipoDocumentoDTO.setIdTipoDocumento(tipoDocumento.getIdTipoDocumento());
                    tipoDocumentoDTO.setNombre(tipoDocumento.getNombre());
                    return tipoDocumentoDTO;
                }).collect(Collectors.toList());
    }
    public List<LocalidadDTO> getLocalidadList(int idProvincia) {
        return localidadDAO.getLocalidades(idProvincia)
                .stream()
                .map(localidad -> {
                    LocalidadDTO localidadDTO = new LocalidadDTO();
                    localidadDTO.setIdLocalidad(localidad.getIdLocalidad());
                    localidadDTO.setValorPorcentual(localidad.getValorPorcentual());
                    localidadDTO.setNombre(localidad.getNombre());
                    localidadDTO.setIdProvincia(localidad.getProvincia().getIdProvincia());
                    return localidadDTO;
                }).collect(Collectors.toList());
        //return localidadDAO.getLocalidades(idProvincia);
    }
    public void guardarPoliza(PolizaDTO polizaDTO){
        polizaDAO.guardarPoliza(polizaDTO);
    }
    public List<TipoCoberturaDTO> getTiposDeCobertura() {
        return tipoCoberturaDAO.getAllTiposCobertura()
                .stream()
                .map(tipoCobertura -> {
                    TipoCoberturaDTO tipoCoberturaDTO = new TipoCoberturaDTO();
                    tipoCoberturaDTO.setIdTipo(tipoCobertura.getIdTipo());
                    tipoCoberturaDTO.setDescripcion(tipoCobertura.getDescripcion());
                    tipoCoberturaDTO.setNombre(tipoCobertura.getNombre());
                    tipoCoberturaDTO.setValorPorcentual(tipoCobertura.getValorPorcentual());
                    return tipoCoberturaDTO;
                }).collect(Collectors.toList());
    }
    public List<MedidaSeguridadDTO> getAllMedidasSeguridad() {
        return medidaSeguridadDAO.getAllMedidas()
                .stream()
                .map(medidaSeguridad -> {
                    MedidaSeguridadDTO medidaSeguridadDTO = new MedidaSeguridadDTO();
                    medidaSeguridadDTO.setIdMedida(medidaSeguridad.getIdMedida());
                    medidaSeguridadDTO.setNombre(medidaSeguridad.getNombre());
                    medidaSeguridadDTO.setValorPorcentual(medidaSeguridad.getValorPorcentual());
                    return medidaSeguridadDTO;
                }).collect(Collectors.toList());
    }

    public void generarPoliza(PolizaDTO datosPolizaDTO, List<HijoDTO> listaHijosDTO, ClienteDTO datosClienteDTO) {
        Poliza poliza = new Poliza();
        poliza.setEstadoPoliza(EstadoPoliza.GENERADA);
        for (HijoDTO unHijo : listaHijosDTO) {
            EstadoCivil estadoCivil = estadoCivilDAO.getEstadoCivil(unHijo.getIdEstadoCivil());
            Hijo nuevoHijo = new Hijo(unHijo.getSexo(), unHijo.getFechaNacimiento() ,estadoCivil);
        }
        Cliente cliente = clienteDAO.obtenerClientePorNumero(datosClienteDTO.getNumeroCliente());
        poliza.setCliente(cliente);
        poliza.setAtributosPoliza(datosPolizaDTO);
        for (int medidaSeguridadId : datosPolizaDTO.getIdMedidas()){
            poliza.addMedida(medidaSeguridadDAO.getMedida(medidaSeguridadId));
        }
        poliza.setTipoCobertura(tipoCoberturaDAO.getTipoCobertura(datosPolizaDTO.getIdTipoCobertura()));
        poliza.setModeloAnio(datosPolizaDTO.getAnio());
        poliza.setModelo(modeloDAO.getModelo(datosPolizaDTO.getIdModelo()));
        poliza.setLocalidad(localidadDAO.getLocalidad(datosPolizaDTO.getIdLocalidad()));
        poliza.setKmPorAnio(kmPorAnioDAO.getKmPorAnio(datosPolizaDTO.getIdKmPorAnio()));
        poliza.setCantidadSiniestros(cantidadSiniestrosDAO.getCantidadSiniestros(datosPolizaDTO.getIdCantidadSiniestros()));

        if (datosPolizaDTO.getFormaPago() == FormaPago.MENSUAL){ //SETEAR LOS VALORES DE LAS CUOTAS!
            List<Cuota> cuotasLista = new ArrayList<>();
            LocalDate fechaInicio = LocalDate.from(datosPolizaDTO.getFechaInicio().toInstant()); //esto esta mal
            for (int i = 0; i <= 6; i++) {
                Cuota cuota = new Cuota(fechaInicio.plusMonths(i));
                cuotasLista.add(cuota);
            }
            poliza.addCuotas(cuotasLista);
        }
        if (datosPolizaDTO.getFormaPago() == FormaPago.SEMESTRAL){//SETEAR LOS VALORES DE LAS CUOTAS!
            List<Cuota> cuotasLista = new ArrayList<>();
            LocalDate fechaInicio = LocalDate.from(datosPolizaDTO.getFechaInicio().toInstant()); //esto tambien
            Cuota cuota = new Cuota(fechaInicio.plusMonths(6));
            poliza.addCuotas(cuotasLista);
        }
        poliza.setValorPorcentualHijo(valorPorcentualHijoDAO.getValorPorcentualHijo(datosPolizaDTO.getIdValorPorcentualHijo()));
        polizaDAO.guardarPoliza(poliza);
    }

    public static void main(String[] args) {
        PolizaDTO polizaTest = new PolizaDTO(1,500.0, new Date(), new Date(), 1000.35, "ABC123",
                "123456", new Date(),20000, "XYZ789", 1, 123,
                456, 789, 2, 3, 4, FormaPago.MENSUAL, EstadoPoliza.VIGENTE);
        PolizaDAO DAO = new PolizaDAO();
        DAO.guardarPoliza(polizaTest);
        System.out.println("numero de poliza: " + polizaTest.getNumeroPoliza());
    }

    public ClienteDTO getClienteDTO() {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNombre("Carlo");
        cliente.setApellido("Profumieri");
        cliente.setNumeroDocumento(412456332);
        cliente.setTipoDocumento(1);
        cliente.setNumeroCliente(42059);
        cliente.setFechaNacimiento(LocalDate.now().minusYears(25));
        return cliente;
    }
}
