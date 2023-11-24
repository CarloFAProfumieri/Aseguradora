package com.example.aseguradora;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;



public class ConfirmarPolizaController implements Initializable {
    @FXML Label titularSeguroLabel, marcaVehiculoLabel, modeloVehiculoLabel, motorLabel, chasisLabel, patenteLabel, inicioCoberturaLabel, finalCoberturaLabel, sumaAseguradaLabel, PremioLabel, importesDescuentosLabel, modalidadPagoLabel, montoTotalLabel;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titularSeguroLabel.setText("Santino");
    }


    @FXML
    private void cancelarAction() {
        // Acciones al hacer clic en Cancelar
        System.out.println("Operación cancelada");
    }

    @FXML
    private void generarPolizaAction() {
        // Lógica para generar la póliza
        System.out.println("Generando la póliza...");
    }
}