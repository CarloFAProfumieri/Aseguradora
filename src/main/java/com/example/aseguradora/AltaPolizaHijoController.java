package com.example.aseguradora;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.Period;

import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class AltaPolizaHijoController implements Initializable {

    private AltaPoliza altaPolizaController;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label fechaLabel;

    @FXML
    private ComboBox<String> sexoComboBox;

    @FXML
    private ComboBox<String> estadoCivilComboBox;

    @FXML
    private Label estadoCivilLabel;

    @FXML
    private Button agregarButton;

    @FXML
    private Button cancelarButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        estadoCivilComboBox.getItems().addAll("SOLTERO", "CASADO", "DIVORCIADO", "VIUDO");


        sexoComboBox.getItems().addAll("Masculino", "Femenino");

    }

    @FXML
    private void cancelarButtonAction() {

        cerrarVentanaActual();

    }

    @FXML
    private void agregarButtonAction() {
        // Obtener la información seleccionada en AltaPolizaHijo
        String fechaNacimiento = datePicker.getValue().toString();
        String estadoCivil = estadoCivilComboBox.getValue();
        String sexo = sexoComboBox.getValue();

        char ns = (Objects.equals(sexo, "Masculino")) ? 'M' : 'F';

        // Obtener la fecha de nacimiento del DatePicker
        LocalDate fechaNacimiento1 = datePicker.getValue();

        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        int edad = Period.between(fechaNacimiento1, fechaActual).getYears();

        // Crear un nuevo objeto Hijo
        Hijo nuevoHijo = new Hijo(edad, ns, estadoCivil);

        // Agregar el nuevo hijo a AltaPoliza
        altaPolizaController.agregarHijo(nuevoHijo);

        // Cerrar la ventana de AltaPolizaHijo
        cerrarVentanaActual();



    }

    private void cerrarVentanaActual() {
        // Obtén la referencia al escenario (Stage) actual
        Stage stage = (Stage) agregarButton.getScene().getWindow();
        // Cierra la ventana actual
        stage.close();
    }

    public void setAltaPolizaController(AltaPoliza altaPolizaController) {
        this.altaPolizaController = altaPolizaController;
    }
}


