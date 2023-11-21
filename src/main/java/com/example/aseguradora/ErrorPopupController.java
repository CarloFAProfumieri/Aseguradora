package com.example.aseguradora;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ErrorPopupController {

    @FXML
    private Label errorMessageLabel;

    public void setErrorMessage(String mensaje) {
        errorMessageLabel.setText(mensaje);
    }

    @FXML
    private void closeErrorPopup() {
        // Cierra la ventana emergente
        errorMessageLabel.getScene().getWindow().hide();
    }
}
