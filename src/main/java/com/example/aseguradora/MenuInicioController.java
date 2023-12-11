package com.example.aseguradora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuInicioController {
    @FXML Button darAltaPolizaButton, darAltaClienteButton;
    private static Stage stg;
    public void darAltaPolizaAction(ActionEvent evento) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("altaPoliza.fxml"));
        Parent altaPolizaParent = fxmlLoader.load();

        Stage altaPolizaStage = new Stage();
        altaPolizaStage.setTitle("Alta Poliza");
        altaPolizaStage.initModality(Modality.WINDOW_MODAL);
        altaPolizaStage.initOwner(stg);

        Scene scene = new Scene(altaPolizaParent, 906, 844);
        altaPolizaStage.setScene(scene);
        altaPolizaStage.setResizable(false);

        altaPolizaStage.show();
    }
    public void darAltaClienteAction(ActionEvent evento) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("altaCliente.fxml"));
        Parent altaClienteParent = fxmlLoader.load();

        Stage altaClienteStage = new Stage();
        altaClienteStage.setTitle("Alta Cliente");
        altaClienteStage.initModality(Modality.WINDOW_MODAL);
        altaClienteStage.initOwner(stg);

        Scene scene = new Scene(altaClienteParent, 800, 627);  // Ajusta ANCHO y ALTO según tus preferencias
        altaClienteStage.setScene(scene);
        altaClienteStage.setResizable(false);

        altaClienteStage.show();
    }

    public void consultarClienteAction(ActionEvent evento) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("buscarCliente.fxml"));
        Parent buscarClienteParent = fxmlLoader.load();

        Stage buscarClienteStage = new Stage();
        buscarClienteStage.setTitle("Buscar Cliente");
        buscarClienteStage.initModality(Modality.WINDOW_MODAL);
        buscarClienteStage.initOwner(stg);

        Scene scene = new Scene(buscarClienteParent, 815, 554);  // Ajusta ANCHO y ALTO según tus preferencias
        buscarClienteStage.setScene(scene);
        buscarClienteStage.setResizable(false);

        buscarClienteStage.show();
    }



    public void actualizarFactoresCaracteristicasAction(ActionEvent event) {
    }

    public void cerrarSesionAction(ActionEvent evento) {
        Stage stage = (Stage) ((javafx.scene.Node) evento.getSource()).getScene().getWindow();
        stage.close();
    }
}
