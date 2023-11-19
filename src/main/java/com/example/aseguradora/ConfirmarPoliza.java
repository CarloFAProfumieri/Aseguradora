package com.example.aseguradora;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ConfirmarPoliza extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Confirmar Generación de Póliza");

        // Crear etiqueta para "DATOS DE LA PÓLIZA"
        Label datosPolizaLabel = new Label("DATOS DE LA PÓLIZA");
        datosPolizaLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;-fx-border-color: black; -fx-border-width: 0 0 2 0; -fx-padding: 10 10 10 10;-fx-background-color: #CCCCCC;-fx-text-fill: black;");
        datosPolizaLabel.setMaxWidth(Double.MAX_VALUE);



        // Crear una cuadrícula para los datos de la póliza
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // Datos de la póliza
        String[] labels = {
                "Titular del Seguro:", "Marca del Vehiculo:", "Modelo del Vehiculo:", "Motor:",
                "Chasis:", "Patente:", "Inicio de la cobertura:", "Final de la cobertura:",
                "Suma Asegurada:", "Premio:", "Importes por descuentos:", "Modalidad de pago:",
                "Último día de pago:", "Monto por cuota:", "Monto total a abonar:"
        };

        // Alternar colores entre gris claro y gris oscuro para las filas
        for (int i = 0; i < labels.length; i++) {
            // Asumiendo que los valores provienen de otras pantallas, reemplaza los siguientes valores con los reales
            String valorCorrespondiente = "Valor correspondiente";
            Label label = new Label(labels[i]);
            Label valorLabel = new Label(valorCorrespondiente);

            // Aplicar estilo a la fila completa
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            HBox row = new HBox(label, spacer, valorLabel);
            row.setStyle("-fx-background-color: " + (i % 2 == 0 ? "#f2f2f2;" : "#e6e6e6;"));
            grid.add(row, 0, i, 2, 1);


        }





        // Ajustar el ancho de las columnas
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(30);



        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(70);

        grid.getColumnConstraints().addAll(column1, column2);

        // Crear botones "Cancelar" y "Generar Póliza"
        Button cancelarButton = new Button("Cancelar");
        Button generarPolizaButton = new Button("Generar Póliza");

        // Configurar acciones de los botones
        cancelarButton.setOnAction(e -> primaryStage.close());
        generarPolizaButton.setOnAction(e -> {
            // Lógica para generar la póliza
            System.out.println("Generando la póliza...");
        });

        // Crear HBox para los botones y ajustar la alineación
        HBox botonesBox = new HBox(10);
        botonesBox.getChildren().addAll(cancelarButton, generarPolizaButton);
        botonesBox.setAlignment(javafx.geometry.Pos.BOTTOM_RIGHT);

        // Crear VBox para organizar
        VBox layout = new VBox(10);
        layout.getChildren().addAll(datosPolizaLabel, grid, botonesBox);
        Insets vboxInsets = new Insets(10,10,10,10);
        VBox.setMargin(layout, vboxInsets);
        VBox.setMargin(botonesBox, new Insets(0, 10, 0, 0));




        // Crear Scene y mostrar la ventana
        Scene scene = new Scene(layout, 800, 500); // Ajustar el tamaño
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}