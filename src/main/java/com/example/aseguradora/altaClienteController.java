package com.example.aseguradora;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class altaClienteController {

    @FXML private TextField nombreTextField,apellidoTextField,numeroDeDocumentoTextField,numeroDeClienteTextField,numeroDeCuilTextField,codigoPostalTextField,calleTextField
            ,numeroDeCalleTextField,pisoTextField,departamentoTextField,correoElectronicoTextField,profesionTextField,anioTextField;
    @FXML private ComboBox<String> tipoDeDocumentoComboBox;
    @FXML private ComboBox<String> sexoComboBox;
    @FXML private DatePicker fechaNacimientoDatePicker;
    @FXML private ComboBox<String> paisComboBox;
    @FXML private ComboBox<String> provinciaComboBox;
    @FXML private ComboBox<String> localidadComboBox;
    @FXML private ComboBox<String> estadoCivilComboBox;
    @FXML private ComboBox<String> condicionIVAComboBox;

    public static void main(String[] args) {

    }
}
