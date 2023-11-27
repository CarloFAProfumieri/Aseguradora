module com.example.aseguradora {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens com.example.aseguradora;// to javafx.fxml;
    exports com.example.aseguradora;
    exports com.example.aseguradora.enumeraciones;
    opens com.example.aseguradora.enumeraciones;// to javafx.fxml;
    exports com.example.aseguradora.persistentes;
    opens com.example.aseguradora.persistentes;

}