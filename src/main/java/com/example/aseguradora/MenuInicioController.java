package com.example.aseguradora;

import com.example.aseguradora.gestores.GestorClientes;
import com.example.aseguradora.gestores.GestorPolizas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuInicioController implements Initializable {
    @FXML Button darAltaPolizaButton, darAltaClienteButton;
    GestorPolizas gestorPolizas;
    GestorClientes gestorClientes;
    boolean altaPolizaRunning = false
            , altaClienteRunning = false
            , consultarClienteRunning = false;
    private PantallaCargaController pantallaCargaController;
    private boolean polizaCargadaExitosamente = false;

    public void setNumeroDePolizaGenerada(String numeroDePolizaGenerada) {
        this.numeroDePolizaGenerada = numeroDePolizaGenerada;
    }

    private String numeroDePolizaGenerada;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    private static Stage stg;
    public void darAltaPolizaAction(ActionEvent evento) throws IOException {
        if (altaPolizaRunning){
            mostrarVentanaError("Ya hay una ventana de Alta Póliza corriendo. Cierre la ventana de Alta Póliza para continuar.");
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("altaPoliza.fxml"));
        Parent altaPolizaParent = fxmlLoader.load();
        AltaPolizaController altaPolizaController = fxmlLoader.getController();
        altaPolizaController.setMainMenu(this);
        Stage altaPolizaStage = new Stage();
        altaPolizaStage.setTitle("Alta Poliza");
        Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
        altaPolizaStage.getIcons().add(imagen);
        altaPolizaStage.initModality(Modality.WINDOW_MODAL);
        altaPolizaStage.initOwner(stg);

        Scene scene = new Scene(altaPolizaParent, 906, 844);
        altaPolizaStage.setScene(scene);
        altaPolizaStage.setResizable(false);
        altaPolizaRunning=true;
        altaPolizaStage.showAndWait();
        if (polizaCargadaExitosamente){
            PopupController.mostrarVentanaInformacion("Póliza numero: "+ numeroDePolizaGenerada + " generada exitosamente.","Póliza generada exitosamente");
            polizaCargadaExitosamente = false;
        }
        altaPolizaRunning=false;
    }
    public void consultarPoliza(ActionEvent evento) throws IOException {
        PopupController.mostrarVentanaInformacion("Consultar poliza no implementado","Consultar Poliza no Implementado");
        return;
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("altaCliente.fxml"));
        Parent altaClienteParent = fxmlLoader.load();

        Stage altaClienteStage = new Stage();
        altaClienteStage.setTitle("Alta Cliente");
        Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
        altaClienteStage.getIcons().add(imagen);
        altaClienteStage.initModality(Modality.APPLICATION_MODAL);
        altaClienteStage.initOwner(stg);

        Scene scene = new Scene(altaClienteParent, 800, 627);//627  // Ajusta ANCHO y ALTO según tus preferencias

        altaClienteStage.setScene(scene);
        altaClienteStage.setResizable(false);

        altaClienteStage.showAndWait();

         */
    }
    public void generarPropuestasRenovacion(ActionEvent evento) throws IOException {
        PopupController.mostrarVentanaInformacion("Generar Propuesta de Renovacion no implementado", "Propuesta de Renovaciónn");
        return;
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("buscarCliente.fxml"));
        Parent buscarClienteParent = fxmlLoader.load();

        Stage buscarClienteStage = new Stage();
        buscarClienteStage.setTitle("Buscar Cliente");
        Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
        buscarClienteStage.getIcons().add(imagen);
        buscarClienteStage.initModality(Modality.WINDOW_MODAL);
        buscarClienteStage.initOwner(stg);

        Scene scene = new Scene(buscarClienteParent, 815, 554);//554
        buscarClienteStage.setScene(scene);
        buscarClienteStage.setResizable(false);

        buscarClienteStage.showAndWait();

         */
    }
    public void polizaCargadaExitosamente(){
        polizaCargadaExitosamente = true;
    }
    public void inicializarBasesDeDatos(){
        gestorPolizas = GestorPolizas.getInstancia();
        gestorClientes = GestorClientes.obtenerInstancia();
    }

    public void actualizarFactoresCaracteristicasAction(ActionEvent event) {
        PopupController.mostrarVentanaInformacion("Actualizar Factores de Características no implementado", "Actualizar Factores de características");
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
    public void cerrarSesionAction(ActionEvent evento) {
        Stage stage = (Stage) ((javafx.scene.Node) evento.getSource()).getScene().getWindow();
        stage.close();
    }
}
