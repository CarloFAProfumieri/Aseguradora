package com.example.aseguradora;

import com.example.aseguradora.DTOs.ClienteDTO;
import com.example.aseguradora.DTOs.PolizaDTO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;



public class ConfirmarPolizaController implements Initializable {
    @FXML Label titularSeguroLabel, marcaVehiculoLabel, modeloVehiculoLabel, motorLabel, chasisLabel, patenteLabel, inicioCoberturaLabel, finalCoberturaLabel, sumaAseguradaLabel, premioLabel, importesDescuentosLabel, modalidadPagoLabel, montoTotalLabel;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titularSeguroLabel.setText("Santino");
    }

    public void setPoliza(PolizaDTO unaPoliza, ClienteDTO unCliente){
    titularSeguroLabel.setText(unCliente.getNombre());
    //marcaVehiculoLabel.setText(unaPoliza.getMarcaAux());
    //modeloVehiculoLabel.setText(ModeloDAO);
    motorLabel.setText(unaPoliza.getCodigoMotor());
    chasisLabel.setText(unaPoliza.getCodigoChasis());
    patenteLabel.setText(unaPoliza.getPatente());
    inicioCoberturaLabel.setText(unaPoliza.getFechaInicio().toString());
    finalCoberturaLabel.setText(unaPoliza.getFechaFin().toString());
    sumaAseguradaLabel.setText(String.valueOf(unaPoliza.getSumaAsegurada()));
    //premioLabel.setText(unaPoliza.getPremio());
    //importesDescuentosLabel.setText(unaPoliza.getDescuento());
    //modalidadPagoLabel.setText();
    //montoTotalLabel.setText(unaPoliza.getMontoTotal());
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