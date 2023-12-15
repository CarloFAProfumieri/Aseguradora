package com.example.aseguradora;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PopupController implements Initializable {

    @FXML
    private Label errorMessageLabel;
    @FXML ImageView errorImage, informacionImage;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public static void mostrarVentanaError(String mensaje) {
        try {
            // cargo el fxml
            FXMLLoader loader = new FXMLLoader(PopupController.class.getResource("errorPopup.fxml"));
            Parent root = loader.load();


            // Obtener el controlador de la ventana de error
            PopupController errorController = loader.getController();

            // Configurar el mensaje de error
            errorController.setErrorMessage(mensaje);
            errorController.setImagen("ERROR");
            // Crear la escena y el escenario (Stage)
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image imagen = new Image("com/example/aseguradora/error.png");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.getIcons().add(imagen);
            stage.setTitle("Error");
            stage.setScene(scene);

            // Mostrar la ventana de error
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setImagen(String error) {
        if (error == "ERROR"){
            informacionImage.setVisible(false);
            errorImage.setVisible(true);
        }
        if (error == "INFORMACION"){
            informacionImage.setVisible(true);
            errorImage.setVisible(false);
        }
        return;
    }

    public static void mostrarVentanaInformacion(String mensaje, String nombreVentana) {
        try {
            // Cargar el FXML de la ventana de error
            FXMLLoader loader = new FXMLLoader(PopupController.class.getResource("errorPopup.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la ventana de error
            PopupController errorController = loader.getController();

            // Configurar el mensaje de error
            errorController.setErrorMessage(mensaje);
            errorController.setImagen("INFORMACION");
            // Crear la escena y el escenario (Stage)
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image imagen = new Image("com/example/aseguradora/informacion.png");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.getIcons().add(imagen);
            stage.setTitle(nombreVentana);
            stage.setScene(scene);

            // Mostrar la ventana de error
            stage.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
