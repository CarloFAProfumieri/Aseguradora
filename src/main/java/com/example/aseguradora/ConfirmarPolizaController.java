package com.example.aseguradora;

import com.example.aseguradora.DTOs.ClienteDTO;
import com.example.aseguradora.DTOs.MarcaDTO;
import com.example.aseguradora.DTOs.ModeloDTO;
import com.example.aseguradora.DTOs.PolizaDTO;
import com.example.aseguradora.enumeraciones.FormaPago;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class ConfirmarPolizaController implements Initializable {
    public Button confirmarPolizaCancelarButton;
    public GridPane datosPolizaGridPane;
    public Label montoPorCuotaLabel;
    public Label montoPorCuotaValueLabel;
    public Label montoTotalValueLabel;
    @FXML
    Label titularSeguroLabel, marcaVehiculoLabel, modeloVehiculoLabel, motorLabel, chasisLabel, patenteLabel, inicioCoberturaLabel, finalCoberturaLabel, sumaAseguradaLabel, premioLabel, importesDescuentosLabel, modalidadPagoLabel, montoTotalLabel;

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setPoliza(PolizaDTO unaPoliza, ClienteDTO unCliente, MarcaDTO unaMarca, ModeloDTO unModelo) {
        titularSeguroLabel.setText(unCliente.getApellido() + ", " + unCliente.getNombre());
        motorLabel.setText(unaPoliza.getCodigoMotor());
        chasisLabel.setText(unaPoliza.getCodigoChasis());
        patenteLabel.setText(unaPoliza.getPatente());

        LocalDate fechaInicio = unaPoliza.getFechaInicio();
        LocalDate fechaFin = unaPoliza.getFechaFin();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("MM/yyyy");
        String fechaInicioFormateada = fechaInicio.toString();
        String fechaFinFormateada = fechaFin.toString();
        inicioCoberturaLabel.setText(fechaInicioFormateada);
        finalCoberturaLabel.setText(fechaFinFormateada);

        sumaAseguradaLabel.setText(String.valueOf(unaPoliza.getSumaAsegurada()));
        marcaVehiculoLabel.setText(unaMarca.getNombre());
        modeloVehiculoLabel.setText(unModelo.getNombre());
        premioLabel.setText(String.valueOf(unaPoliza.getPremio()));
        importesDescuentosLabel.setText(String.valueOf(unaPoliza.getDescuento()));
        unaPoliza.setFormaPago(FormaPago.SEMESTRAL);
        modalidadPagoLabel.setText(String.valueOf(unaPoliza.getFormaPago()));

        FormaPago formaPago = unaPoliza.getFormaPago();

        if (formaPago == FormaPago.MENSUAL) {
            montoPorCuotaLabel.setVisible(true);
            montoPorCuotaValueLabel.setText("Monto por cuota"); //unaPoliza.getMontoPorCuota()
            montoPorCuotaValueLabel.setVisible(true);
        } else {
            montoPorCuotaLabel.setVisible(false);
            montoPorCuotaValueLabel.setVisible(false);
        }

        montoTotalValueLabel.setText(String.valueOf(unaPoliza.getMontoTotal()));
    }

    private Label obtenerLabelPorTexto(String texto) {
        for (javafx.scene.Node node : datosPolizaGridPane.getChildren()) {
            if (node instanceof Label) {
                Label label = (Label) node;
                if (label.getText().equals(texto)) {
                    return label;
                }
            }
        }
        return null;
    }

    @FXML
    private void cancelarConfirmarAction() {
        Stage stage = (Stage) confirmarPolizaCancelarButton.getScene().getWindow();
        stage.close();
        System.out.println("Operación cancelada");
    }

    @FXML
    private void generarPolizaAction() {
        System.out.println("Generando la póliza...");
    }
}