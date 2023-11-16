module com.example.aseguradora {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aseguradora to javafx.fxml;
    exports com.example.aseguradora;
}