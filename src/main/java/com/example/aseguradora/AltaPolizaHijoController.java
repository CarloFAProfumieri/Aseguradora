package com.example.aseguradora;
import com.example.aseguradora.DAOs.EstadoCivilDAO;
import com.example.aseguradora.DTOs.EstadoCivilDTO;
import com.example.aseguradora.DTOs.HijoDTO;
import com.example.aseguradora.enumeraciones.Sexo;
import com.example.aseguradora.gestores.GestorPolizas;
import com.example.aseguradora.persistentes.EstadoCivil;
import com.example.aseguradora.persistentes.Hijo;
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
import java.util.List;
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
    private ComboBox<EstadoCivilDTO> estadoCivilComboBox;
    private List<EstadoCivilDTO> estadoCivilList;

    @FXML
    private Label estadoCivilLabel;

    @FXML
    private Button agregarButton;

    @FXML
    private Button cancelarButton;
    GestorPolizas gestorPolizas = GestorPolizas.getInstancia();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarEstadoCivil();
        LocalDate fechaInicial = LocalDate.now().minusYears(18);
        datePicker.setValue(fechaInicial);
        sexoComboBox.getItems().addAll("Masculino", "Femenino");

    }
    private void inicializarEstadoCivil() {
        estadoCivilList = gestorPolizas.getAllEstadosCiviles();

        estadoCivilComboBox.getItems().addAll(estadoCivilList);

    }

    @FXML
    public void cancelarButtonAction() {
        cerrarVentanaActual();
    }

    @FXML
    private void agregarButtonAction() {
        String fechaNacimiento = datePicker.getValue() != null ? datePicker.getValue().toString() : null;
        String sexo = sexoComboBox.getValue();
        EstadoCivilDTO estadoCivilSeleccionado = estadoCivilComboBox.getValue();

        if (fechaNacimiento == null || estadoCivilSeleccionado == null || sexoComboBox.getValue() == null) {
            altaPolizaController.mostrarVentanaError("Debe completar la información correspondiente");
            return;
        }

        Sexo sexoHijo = (Objects.equals(sexo, "Masculino")) ? Sexo.HOMBRE : Sexo.MUJER;
        LocalDate fechaNacimiento1 = datePicker.getValue();
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(fechaNacimiento1, fechaActual).getYears();

        if(edad<18 || edad >30) {
            altaPolizaController.mostrarVentanaError("La edad debe estar entre 18 y 30 años");
            return;
        }
        HijoDTO nuevoHijo = new HijoDTO(fechaNacimiento1, sexoHijo, estadoCivilSeleccionado.toString(), estadoCivilSeleccionado.getIdEstadoCivil());
        altaPolizaController.agregarHijo(nuevoHijo);
        cerrarVentanaActual();
    }

    private void cerrarVentanaActual() {
        Stage stage = (Stage) agregarButton.getScene().getWindow();
        stage.close();
    }

    public void setAltaPolizaController(AltaPoliza altaPolizaController) {
        this.altaPolizaController = altaPolizaController;
    }


}


