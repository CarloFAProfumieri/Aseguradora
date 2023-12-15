package com.example.aseguradora;

import com.example.aseguradora.DTOs.*;
import com.example.aseguradora.enumeraciones.FormaPago;
import com.example.aseguradora.gestores.GestorPolizas;
import com.example.aseguradora.persistentes.Cliente;
import com.example.aseguradora.persistentes.Poliza;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ConfirmarPolizaController implements Initializable {
    public Button confirmarPolizaCancelarButton;
    public GridPane datosPolizaGridPane;
    public Label montoPorCuotaLabel;
    public Label montoPorCuotaValueLabel;
    private AltaPolizaController altaPolizaController;
    public Label montoTotalValueLabel;
    @FXML
    Label titularSeguroLabel, marcaVehiculoLabel, modeloVehiculoLabel, motorLabel, chasisLabel, patenteLabel, inicioCoberturaLabel, finalCoberturaLabel, sumaAseguradaLabel, premioLabel, importesDescuentosLabel, modalidadPagoLabel, montoTotalLabel, ultimoDiaPagoValueLabel;
    ConfirmarPolizaDTO valoresDePolizaDTO;
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void setAltaPolizaController(AltaPolizaController controlador){
        altaPolizaController = controlador;
    }
    public void setPoliza(ConfirmarPolizaDTO confirmarPolizaDTO) {
        valoresDePolizaDTO = confirmarPolizaDTO;
        titularSeguroLabel.setText(confirmarPolizaDTO.getTitularSeguroApellido() + ", " + confirmarPolizaDTO.getTitularSeguroNombre());
        motorLabel.setText(confirmarPolizaDTO.getVehiculoMotor());
        chasisLabel.setText(confirmarPolizaDTO.getVehiculoChasis());
        patenteLabel.setText(confirmarPolizaDTO.getVehiculoPatente());

        LocalDate fechaInicio = confirmarPolizaDTO.getInicioCoberturaLocalDate();
        LocalDate fechaFin = confirmarPolizaDTO.getFinalCoberturaLocalDate();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("MM/yyyy");
        String fechaInicioFormateada = fechaInicio.toString();
        String fechaFinFormateada = fechaFin.toString();
        inicioCoberturaLabel.setText(fechaInicioFormateada);
        finalCoberturaLabel.setText(fechaFinFormateada);

        sumaAseguradaLabel.setText("$" + String.valueOf(confirmarPolizaDTO.getSumaAsegurada()));
        marcaVehiculoLabel.setText(confirmarPolizaDTO.getVehiculoMarca());
        modeloVehiculoLabel.setText(confirmarPolizaDTO.getVehiculoModelo());
        premioLabel.setText("$" + String.valueOf(confirmarPolizaDTO.getPremio()));
        importesDescuentosLabel.setText("$" + String.valueOf(confirmarPolizaDTO.getImportePorDescuento()));
        modalidadPagoLabel.setText(String.valueOf(confirmarPolizaDTO.getModalidadDePagoFormaPago()));

        FormaPago formaPago = confirmarPolizaDTO.getModalidadDePagoFormaPago();


        List<Double> pagosPorCuota = confirmarPolizaDTO.getPagosPorCuotaList();
        StringBuilder montosPorCuota = new StringBuilder();
        for (Double monto : pagosPorCuota) {
            montosPorCuota.append("$").append(String.format("%.2f", monto)).append("   "); //trim to 2 significant values!!!!
        }

        montoPorCuotaValueLabel.setText(montosPorCuota.toString());


        //if (formaPago == FormaPago.MENSUAL) {

          //  montoPorCuotaValueLabel.setText("Monto por cuota"); //unaPoliza.getMontoPorCuota()

        // } else {
            //montoPorCuotaLabel.setVisible(false);
            //montoPorCuotaValueLabel.setVisible(false);
        // }


        List<LocalDate> ultimoDiaDePagoList = confirmarPolizaDTO.getUltimoDiaPagoLocalDateList();
        StringBuilder ultimoDiaDePago = new StringBuilder();
        for (LocalDate fecha : ultimoDiaDePagoList) {
            ultimoDiaDePago.append(fecha.getYear()).append("/").append(fecha.getMonthValue()).append("/").append(fecha.getDayOfMonth()).append("  ");
        }

        ultimoDiaPagoValueLabel.setText(ultimoDiaDePago.toString());

        montoTotalValueLabel.setText("$" + String.valueOf(confirmarPolizaDTO.getMontoTotal()));


    }

    @FXML
    private void cancelarConfirmarAction() {
        Stage stage = (Stage) confirmarPolizaCancelarButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void generarPolizaAction(ActionEvent evento) throws IOException {
        GestorPolizas gestorPolizas = GestorPolizas.getInstancia();
        //gestorPolizas.emitirPoliza(valoresDePolizaDTO);
        Stage stage = (Stage) ((javafx.scene.Node) evento.getSource()).getScene().getWindow();
        stage.close();
        altaPolizaController.confirmarPolizaAction(evento);
    }

}