package com.example.aseguradora;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AltaPolizaHijo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Alta de Póliza para Hijo");

        // Crear controles y etiquetas
        DatePicker datePicker = new DatePicker();
        Label fechaLabel = new Label("Fecha de nacimiento:");

        ComboBox<String> estadoCivilComboBox = new ComboBox<>();
        estadoCivilComboBox.getItems().addAll("Soltero", "Casado", "Divorciado", "Viudo");
        estadoCivilComboBox.setPromptText("Seleccione estado civil");
        Label estadoCivilLabel = new Label("Estado civil:");

        Button agregarButton = new Button("Agregar");
        agregarButton.setOnAction(e -> {
            // Acciones al hacer clic en Agregar
            System.out.println("Fecha seleccionada: " + datePicker.getValue());
            System.out.println("Estado civil seleccionado: " + estadoCivilComboBox.getValue());
        });

        Button cancelarButton = new Button("Cancelar");
        cancelarButton.setOnAction(e -> primaryStage.close());

        ComboBox<String> sexo = new ComboBox<>();
        sexo.getItems().addAll("Masculino", "Femenino");
        sexo.setPromptText("SEXO");
        Label sexoLabel = new Label("Sexo:");

        // Crear GridPane y configurar diseño
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        // Agregar controles y etiquetas al GridPane
        gridPane.add(fechaLabel, 0, 0);
        gridPane.add(datePicker, 0, 1);

        gridPane.add(sexoLabel, 2, 0);
        gridPane.add(sexo, 2, 1);

        gridPane.add(estadoCivilLabel, 0, 2);
        gridPane.add(estadoCivilComboBox, 0, 3);

        // Crear HBox para los botones y ajustar la alineación
        HBox botonesBox = new HBox(5);
        botonesBox.getChildren().addAll(agregarButton, cancelarButton);
        botonesBox.setAlignment(Pos.BOTTOM_RIGHT);





        // Crear VBox para organizar todo
        VBox layout = new VBox(10);
        VBox.setMargin(botonesBox, new Insets(0, 10, 0, 0));
        layout.getChildren().addAll(gridPane, botonesBox);

        // Crear Scene y mostrar la ventana
        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}