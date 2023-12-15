package com.example.aseguradora;

import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PantallaCargaController extends Thread{
    private Main main;
    private Stage cargaStage;
    public void initialize() {

    }

        public void setMain(Main main) {
        this.main = main;
    }

    public void setCargaStage(Stage cargaStage) {
        this.cargaStage = cargaStage;
    }

    public void close() {
        if (cargaStage != null) {
            cargaStage.close();
        }
    }

    public void setMainApp(Main main) {
        this.main = main;
    }

    public void startMenuInicio() {
        try{

            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuInicio.fxml"));
            Parent root = loader.load();
            // Configurar una referencia a AltaPoliza en AltaPolizaHijoController
            Stage stage = new Stage();
            stage.setTitle("Menu de inicio");
            Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
            stage.getIcons().add(imagen);
            stage.setScene(new Scene(root, 400, 500));
            stage.setResizable(false);
            stage.showAndWait();
        }
        catch (IOException e){
            mostrarVentanaError("Error fatal. Reinicie el programa para continuar");
        }

    }
    public void mostrarVentanaError(String mensaje) {
        try {
            // Cargar el FXML de la ventana de error
            FXMLLoader loader = new FXMLLoader(getClass().getResource("errorPopup.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la ventana de error
            PopupController errorController = loader.getController();

            // Configurar el mensaje de error
            errorController.setErrorMessage(mensaje);

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
    public void bindProgressBar(Task<Void> task) {
    }
}
