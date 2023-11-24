package com.example.aseguradora.gestores;

import com.example.aseguradora.DAOs.PolizaDAO;
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
    private GestorPolizas() {
    }
    public static GestorPolizas getInstancia() {

        return instancia;
    }
    public void darAltaPoliza(PolizaDTO unaPolizaDTO){
        PolizaDAO polizaDao = new PolizaDAO();
        polizaDao.guardarPoliza(unaPolizaDTO);
    }
    public void emitirPoliza(){

    }
    public void consultarPoliza(){

    }
    public void generarInformeResultadoMensual(){

    }
    //pasar recuperacion de listas a un solo metodo
    public List<Marca> getMarcasList(){
        PolizaDAO polizaDao = new PolizaDAO();
        return polizaDao.getAllMarcas();
    }
    public List<Provincia> getProvinciaList(){
        PolizaDAO polizaDao = new PolizaDAO();
        return polizaDao.getAllProvincias();
    }
    public List<Localidad> getLocalidadList(int idProvincia) {
        PolizaDAO polizaDAO = new PolizaDAO();
        return polizaDAO.getLocalidades(idProvincia);
    }
    public List<ModeloVehiculo> getModelosList(int idMarca){
        PolizaDAO polizaDAO = new PolizaDAO();
        return polizaDAO.getModelos(idMarca);
    }
    public void guardarPoliza(PolizaDTO polizaDTO){
        PolizaDAO DAO = new PolizaDAO();
        DAO.guardarPoliza(polizaDTO);
    }
    public List<TipoCobertura> getTiposDeCobertura() {
        PolizaDAO dao = new PolizaDAO();
        return dao.getAllTiposCobertura();
    }
    public static void main(String[] args) {
        PolizaDTO polizaTest = new PolizaDTO(1,500.0, new Date(), new Date(), 1000.35, "ABC123",
                "123456", new Date(),20000, "XYZ789", 1, 123,
                456, 789, 2, 3, 4, FormaPago.MENSUAL, EstadoPoliza.VIGENTE);
        PolizaDAO DAO = new PolizaDAO();
        DAO.guardarPoliza(polizaTest);
        System.out.println("numero de poliza: " + polizaTest.getNumeroPoliza());
    }

    public void generarPoliza(PolizaDTO datosPoliza, HijoDTO datosHijo, ClienteDTO datosCliente) {
        //implementar con diagrama de secuencia :D
    }
}
