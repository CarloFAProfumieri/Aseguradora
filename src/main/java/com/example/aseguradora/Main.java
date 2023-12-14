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
import javafx.scene.image.Image;
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
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setTitle("Menu de Inicio");
        Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
        stage.getIcons().add(imagen);
        stage.setScene(scene);
        stage.show();
    }
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
    public static void main(String[] args) {
        Main.setHibernate(Level.SEVERE);
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