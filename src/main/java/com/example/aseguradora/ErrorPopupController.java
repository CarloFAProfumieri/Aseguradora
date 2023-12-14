package com.example.aseguradora;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorPopupController implements Initializable {

    @FXML
    private Label errorMessageLabel;
    @FXML
    ImageView imagenView;
    Image imagen = new Image(getClass().getResourceAsStream("error.png"));
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imagenView.setImage(imagen);
    }

    public void setErrorMessage(String mensaje) {
        errorMessageLabel.setText(mensaje);
    }

    @FXML
    private void closeErrorPopup() {
        // Cierra la ventana emergente
        errorMessageLabel.getScene().getWindow().hide();
    }
}
