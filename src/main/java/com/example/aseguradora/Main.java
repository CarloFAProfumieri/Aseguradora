package com.example.aseguradora;

import com.example.aseguradora.DTOs.ConfirmarPolizaDTO;
import com.example.aseguradora.enumeraciones.FormaPago;
import com.example.aseguradora.persistentes.Cliente;
import com.example.aseguradora.persistentes.Poliza;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    private static Stage stg;
    @Override
    //version con scrollbar para desarrollar en pantallas de menor resolucion
    /*public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("altaPoliza.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        ScrollPane Pane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(scrollPane, 906.0, 800.0);

        stage.setTitle("Alta Poliza");
        stage.setScene(scene);
        stage.show();
    }*/
    //version sin scrollbar
    /*
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("altaPoliza.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 906, 844);
        stage.setTitle("Alta Poliza");
        stage.setScene(scene);
        stage.show();
    }
    */
    public void start(Stage stage) throws IOException{
        stg = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("confirmarPoliza.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 906, 844);
        stage.setTitle("Alta Poliza");
        stage.setScene(scene);
        stage.show();
        ConfirmarPolizaController confirmarPolizaController = fxmlLoader.getController();

        ConfirmarPolizaDTO confirmarPolizaDTO = new ConfirmarPolizaDTO();
        confirmarPolizaDTO.setNumeroPoliza("123123");
        confirmarPolizaDTO.setVehiculoMarca("pepeugeot");
        confirmarPolizaDTO.setVehiculoModelo("50008");
        confirmarPolizaDTO.setVehiculoMotor("312312");
        confirmarPolizaDTO.setVehiculoChasis("143232");
        confirmarPolizaDTO.setVehiculoPatente("ad13423");
        confirmarPolizaDTO.setInicioCoberturaLocalDate(LocalDate.of(2023, 12, 7));
        confirmarPolizaDTO.setFinalCoberturaLocalDate(LocalDate.of(2024, 5, 7));
        confirmarPolizaDTO.setSumaAsegurada(123123);
        confirmarPolizaDTO.setPremio(23123.2);
        confirmarPolizaDTO.setModalidadDePagoFormaPago(FormaPago.MENSUAL);
        List<LocalDate> ultimoDiaDePagoList = new ArrayList<>();

        List<Double> pagosPorCuota = new ArrayList<>();
        pagosPorCuota.add(14.2);
        confirmarPolizaDTO.setPagosPorCuotaList(pagosPorCuota);
        ultimoDiaDePagoList.add(LocalDate.of(2023, 12, 7));
        confirmarPolizaDTO.setUltimoDiaPagoLocalDateList(ultimoDiaDePagoList);
        confirmarPolizaDTO.setMontoTotal(1342312.45);

        confirmarPolizaController.setPoliza(confirmarPolizaDTO);
    }
    public static void main(String[] args) {
        //Main.setHibernate(Level.SEVERE);
        launch();
    }
    public static void setHibernate(Level unNivel){
        Logger hibernateLogger = Logger.getLogger("org.hibernate");
        hibernateLogger.setLevel(unNivel);
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(unNivel);
        hibernateLogger.addHandler(consoleHandler);
    }
}