package com.example.aseguradora;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    private static Stage stg;
    @Override
    //version con scrollbar para desarrollar en pantallas de menor resolucion
    /*public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("altaPoliza.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        ScrollPane Pane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(scrollPane, 906.0, 800.0);

        stage.setTitle("Alta Poliza");
        stage.setScene(scene);
        stage.show();
    }*/

    //version sin scrollbar
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);

        FXMLLoader cargaLoader = new FXMLLoader(Main.class.getResource("PantallaCarga.fxml"));
        Scene cargaScene = new Scene(cargaLoader.load());
        Stage cargaStage = new Stage();
        Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
        cargaStage.getIcons().add(imagen);
        cargaStage.initModality(Modality.APPLICATION_MODAL);
        cargaStage.initStyle(StageStyle.UNDECORATED);
        cargaStage.setScene(cargaScene);
        cargaStage.show();
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                MenuInicioController menuInicioController = new MenuInicioController();
                menuInicioController.inicializarBasesDeDatos();
                return null;
            }
        };

        task.setOnSucceeded(e -> {
            // Cerrar la pantalla de carga cuando la inicialización ha terminado
            cargaStage.close();

            try {
                // Mostrar la pantalla principal después de la inicialización de la base de datos
                FXMLLoader loader = new FXMLLoader(getClass().getResource("menuInicio.fxml"));
                stage.setTitle("Inicio");
                stage.getIcons().add(imagen);
                stage.setScene(new Scene(loader.load(), 400, 500));
                stage.setResizable(false);
                stage.show();
            } catch (IOException error) {
                PopupController.mostrarVentanaError("Error fatal, vuelva a iniciar la aplicacion");
            }
        });

        // Actualizar la barra de progreso en el controlador de la pantalla de carga
        PantallaCargaController cargaController = cargaLoader.getController();
        cargaController.bindProgressBar(task);

        // Ejecutar la tarea en un nuevo hilo
        new Thread(task).start();
    }
    /*
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("altaPoliza.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 906, 844);
        stage.setTitle("Alta Poliza");
        stage.setScene(scene);
        stage.show();
    }

     */
    public static void main(String[] args) {
        Main.setHibernate(Level.SEVERE);
        launch();
    }
    public static void setHibernate(Level unNivel){
        Logger hibernateLogger = Logger.getLogger("org.hibernate");
        hibernateLogger.setLevel(unNivel);
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(unNivel);
        hibernateLogger.addHandler(consoleHandler);
    }
}