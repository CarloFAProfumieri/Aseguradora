package com.example.aseguradora;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class AltaPoliza implements Initializable{
    ObservableList<String> marcasLista =  observableArrayList("Chevrolet", "Ford", "Volkswagen", "Renault", "Peugeot", "Fiat", "Toyota", "Honda");
    ObservableList<String> tiposDeDocumentoLista = observableArrayList("DNI", "LE", "LC");
    @FXML private Button editarClienteButton, agregarHijoButton, altaClienteButton, buscarClienteButton, calcularPremioButton, confirmarDatosButton, cancelarButton, modificarDatosButton, quitarHijoButton;
    @FXML private CheckBox alarmaCheckBox, garageCheckBox, rastreoVehicularCheckBox, tuercasAntirroboCheckBox;
    @FXML private ComboBox<String> tipoDocumentoComboBox, marcaComboBox, anioComboBox, localidadComboBox, modalidadDePagoComboBox, modeloComboBox, provinciaComboBox, siniestrosComboBox, tipoCoberturaComboBox;
    @FXML private DatePicker inicioCoberturaDatePicker;
    @FXML private TextField apellidoTextField, kilometrosTextField, motorTextField, nombreTextField, nroClienteTextField, nroDeDocumentoTextField, patenteTextField;
    @FXML private Pane upperPane, middlePane, bottomPane, clientDataPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoDocumentoComboBox.setItems(tiposDeDocumentoLista);
        marcaComboBox.setItems(marcasLista);
    }

    public void buscarClienteAction(ActionEvent evento) throws IOException{
        busquedaCliente();
    }
    public void darDeAltaClienteAction(ActionEvent evento) throws IOException{
        altaCliente();
    }
    public void editarClienteAction(ActionEvent evento) throws IOException{
        editarCliente();
    }
    private void editarCliente(){
        clientDataPane.setDisable(false);
        altaClienteButton.setDisable(false);
        editarClienteButton.setDisable(true);
        middlePane.setDisable(true);
    }
    private void altaCliente(){ //faltan los caminos tistes
        clientDataPane.setDisable(true);
        middlePane.setDisable(false);
        editarClienteButton.setDisable(false);
        altaClienteButton.setDisable(true);
    }

    private void busquedaCliente() {
        apellidoTextField.setText("Profumieri");
        nombreTextField.setText("Carlo");
        nroClienteTextField.setText("42059");
        tipoDocumentoComboBox.setValue("DNI");
        nroDeDocumentoTextField.setText("41256332");
        clientDataPane.setDisable(true);
        middlePane.setDisable(false);
        altaClienteButton.setDisable(true);
        editarClienteButton.setDisable(false);
    }


}