package com.example.aseguradora;

import com.example.aseguradora.DAOs.MarcaDAO;
import com.example.aseguradora.gestores.GestorClientes;
import com.example.aseguradora.gestores.GestorPolizas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuInicioController implements Initializable {
    @FXML Button darAltaPolizaButton, darAltaClienteButton;
    GestorPolizas gestorPolizas = GestorPolizas.getInstancia();
    GestorClientes gestorClientes = GestorClientes.obtenerInstancia();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    private static Stage stg;
    public void darAltaPolizaAction(ActionEvent evento) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("altaPoliza.fxml"));
        Parent altaPolizaParent = fxmlLoader.load();

        Stage altaPolizaStage = new Stage();
        altaPolizaStage.setTitle("Alta Poliza");
        Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
        altaPolizaStage.getIcons().add(imagen);
        altaPolizaStage.initModality(Modality.WINDOW_MODAL);
        altaPolizaStage.initOwner(stg);

        Scene scene = new Scene(altaPolizaParent, 906, 844);
        altaPolizaStage.setScene(scene);
        altaPolizaStage.setResizable(false);

        altaPolizaStage.showAndWait();
    }

    public void darAltaClienteAction(ActionEvent evento) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("altaCliente.fxml"));
        Parent altaClienteParent = fxmlLoader.load();

        Stage altaClienteStage = new Stage();
        altaClienteStage.setTitle("Alta Cliente");
        Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
        altaClienteStage.getIcons().add(imagen);
        altaClienteStage.initModality(Modality.WINDOW_MODAL);
        altaClienteStage.initOwner(stg);

        Scene scene = new Scene(altaClienteParent, 800, 627);  // Ajusta ANCHO y ALTO según tus preferencias
        altaClienteStage.setScene(scene);
        altaClienteStage.setResizable(false);

        altaClienteStage.showAndWait();
    }

    public void consultarClienteAction(ActionEvent evento) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("buscarCliente.fxml"));
        Parent buscarClienteParent = fxmlLoader.load();

        Stage buscarClienteStage = new Stage();
        buscarClienteStage.setTitle("Buscar Cliente");
        Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
        buscarClienteStage.getIcons().add(imagen);
        buscarClienteStage.initModality(Modality.WINDOW_MODAL);
        buscarClienteStage.initOwner(stg);

        Scene scene = new Scene(buscarClienteParent, 815, 554);
        buscarClienteStage.setScene(scene);
        buscarClienteStage.setResizable(false);

        buscarClienteStage.showAndWait();
    }



    public void actualizarFactoresCaracteristicasAction(ActionEvent event) {
    }

    public void cerrarSesionAction(ActionEvent evento) {
        Stage stage = (Stage) ((javafx.scene.Node) evento.getSource()).getScene().getWindow();
        stage.close();
    }
}
