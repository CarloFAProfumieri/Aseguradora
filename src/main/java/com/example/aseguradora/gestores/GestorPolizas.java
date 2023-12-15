package com.example.aseguradora.gestores;

import com.example.aseguradora.SistemaAutoscoring;
import com.example.aseguradora.DAOs.*;
import com.example.aseguradora.DTOs.*;
import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.enumeraciones.FormaPago;
import com.example.aseguradora.persistentes.*;

import java.time.LocalDate;
import java.util.ArrayList;
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
    /*
    public void emitirPoliza(ConfirmarPolizaDTO valoresDePolizaDTO){
        Poliza estaPoliza = polizaDAO.getPoliza(valoresDePolizaDTO.getNumeroPoliza());
        estaPoliza.setEstadoPoliza(EstadoPoliza.GENERADA);
        estaPoliza.getCliente().setEstadoCliente(EstadoCliente.NORMAL);
        //actualizarCondicionCliente(valoresDePolizaDTO.getIdCliente());
        //polizaDAO.guardarPoliza(estaPoliza);
    }

     */
    public void actualizarCondicionCliente(Cliente cliente){
        for (Poliza poliza : cliente.getPolizas()){
            List<Cuota> cuotasViejas = poliza.getCuotas();
            for (Cuota cuota : cuotasViejas){

            }
        }
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
    public List<AnioDTO> getAnios(int idModelo){
        return modeloDAO.getAnios(idModelo)
                .stream()
                .map(anioFabricacion -> {
                    AnioDTO anioDTO = new AnioDTO();
                    anioDTO.setAnio(anioFabricacion.getAnio());
                    return anioDTO;
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
    public List<EstadoCivilDTO> getAllEstadosCiviles(){
        return estadoCivilDAO.getAllEstadosCiviles()
                .stream()
                .map(estadoCivil -> {
                    EstadoCivilDTO estadoCivilDTO = new EstadoCivilDTO();
                    estadoCivilDTO.setIdEstadoCivil(estadoCivil.getIdEstadoCivil());
                    estadoCivilDTO.setNombre(estadoCivil.getNombre());
                    return estadoCivilDTO;
                }).collect(Collectors.toList());
    }
    public String generarPoliza(PolizaDTO datosPolizaDTO, List<HijoDTO> listaHijosDTO, ClienteDTO datosClienteDTO) {

        Poliza poliza = new Poliza();
        poliza.setAtributosPoliza(datosPolizaDTO); //verificar con el profesor
        poliza.setFormaPago(datosPolizaDTO.getFormaPago());
        poliza.setEstadoPoliza(EstadoPoliza.GENERADA);
        Cliente cliente = clienteDAO.obtenerClientePorNumero(datosClienteDTO.getNumeroCliente());
        poliza.setCliente(cliente);

        for (HijoDTO unHijo : listaHijosDTO) {
            EstadoCivil estadoCivil = estadoCivilDAO.getEstadoCivil(unHijo.getEstadoCivilId());
            Hijo nuevoHijo = new Hijo(unHijo.getSexo(), unHijo.getFechaNacimiento() ,estadoCivil);
            poliza.agregarHijo(nuevoHijo);
        }

        for (int medidaSeguridadId : datosPolizaDTO.getIdMedidas()){
            poliza.addMedida(medidaSeguridadDAO.getMedida(medidaSeguridadId));
        }

        poliza.setTipoCobertura(tipoCoberturaDAO.getTipoCobertura(datosPolizaDTO.getIdTipoCobertura()));
        poliza.setModeloAnio(datosPolizaDTO.getAnio());
        poliza.setModelo(modeloDAO.getModelo(datosPolizaDTO.getIdModelo()));
        poliza.setLocalidad(localidadDAO.getLocalidad(datosPolizaDTO.getIdLocalidad()));
        poliza.setKmPorAnio(kmPorAnioDAO.getKmPorAnio(datosPolizaDTO.getIdKmPorAnio()));
        poliza.setCantidadSiniestros(cantidadSiniestrosDAO.getCantidadSiniestros(datosPolizaDTO.getIdCantidadSiniestros()));

        if (datosPolizaDTO.getFormaPago() == FormaPago.MENSUAL){
            List<Cuota> cuotasLista = new ArrayList<>();
            LocalDate fechaInicio = datosPolizaDTO.getFechaInicio();
            LocalDate primerFechaUltimoDiaPago = datosPolizaDTO.getUltimoDiaPago().getLast();
            List<LocalDate> listaFechasDeVencimiento = new ArrayList<>();
            double montoPorCuota = (datosPolizaDTO.getPrima()/6);
            for (int i = 0; i < 6; i++) {
                Cuota cuota = new Cuota(fechaInicio.plusMonths(i));
                LocalDate ultimoDiaDePago_i = primerFechaUltimoDiaPago.plusMonths(i);
                cuota.setImporte(montoPorCuota);
                cuota.setPoliza(poliza);
                listaFechasDeVencimiento.add(ultimoDiaDePago_i);
                cuotasLista.add(cuota);
            }
            poliza.setUltimoDiaPago(listaFechasDeVencimiento);
            poliza.addCuotas(cuotasLista);
        }
        if (datosPolizaDTO.getFormaPago() == FormaPago.SEMESTRAL){
            List<Cuota> cuotasLista = new ArrayList<>();
            LocalDate fechaInicio = datosPolizaDTO.getFechaInicio();
            Cuota cuota = new Cuota(fechaInicio.minusDays(1));
            cuota.setImporte(datosPolizaDTO.getPrima());
            poliza.setUltimoDiaPago(datosPolizaDTO.getUltimoDiaPago());
            poliza.addCuotas(cuotasLista);
        }
        String numeroPoliza = poliza.generarNroPoliza(SistemaAutoscoring.getSucursal(), SistemaAutoscoring.getSecuenciaRenovacion());
        poliza.setNumeroPoliza(numeroPoliza);
        ValorPorcentualHijo valorPorcentualHijo = valorPorcentualHijoDAO.getValorPorcentualHijo(datosPolizaDTO.getIdValorPorcentualHijo());
        poliza.setValorPorcentualHijo(valorPorcentualHijo);
        ParametrosMonto parametrosMonto = new ParametrosMonto(datosPolizaDTO, poliza);
        poliza.setParametrosMonto(parametrosMonto);
        polizaDAO.guardarPoliza(poliza);
        return poliza.getNumeroPoliza();
    }

    public ClienteDTO getClienteDTO() { //hardcode
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNombre("Carlo");
        cliente.setApellido("Profumieri");
        cliente.setNumeroDocumento(412456332);
        cliente.setTipoDocumentoId(1);
        cliente.setNumeroCliente(42059);
        cliente.setFechaNacimiento(LocalDate.now().minusYears(25));
        return cliente;
    }

    public int getIdKmPorAnio(Integer kilometrosCantidad) {
        List<KmPorAnio> kmPorAnioList = kmPorAnioDAO.getAllKmPorAnio();
        for (KmPorAnio kmPorAnio : kmPorAnioList){
            if (kmPorAnio.getLimiteInferior() <= kilometrosCantidad && kmPorAnio.getLimiteSuperior() >= kilometrosCantidad) return kmPorAnio.getIdKmPorAnio();
            }
        return 0;
        }

    public boolean existePatenteVigente(String numeroDePatente) {
        return polizaDAO.existePatenteVigente(numeroDePatente);
    }
    public boolean existeChasisVigente(String codigoChasis) {
        return polizaDAO.existeChasisVigente(codigoChasis);
    }
    public boolean existeMotorVigente(String codigoMotor) {
        return polizaDAO.existeMotorVigente(codigoMotor);
    }

}

