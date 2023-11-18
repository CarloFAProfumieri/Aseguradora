package com.example.aseguradora;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class AltaPoliza implements Initializable{
    ObservableList<String> marcasLista = observableArrayList("CHEVROLET", "FORD", "VOLKSWAGEN", "RENAULT", "PEUGEOT", "FIAT", "TOYOTA", "HONDA");
    ObservableList<String> modelosListaHonda = observableArrayList(
            "Accord",
            "Civic",
            "CR-V",
            "Pilot",
            "Odyssey",
            "Fit",
            "HR-V",
            "Ridgeline",
            "Insight",
            "Passport"
    );
    ObservableList<String> provinciasLista = observableArrayList("Buenos Aires","Catamarca","Chaco","Chubut","Córdoba","Corrientes","Entre Ríos","Formosa","Jujuy",
            "La Pampa","La Rioja","Mendoza","Misiones","Neuquén","Río Negro","Salta","San Juan","San Luis","Santa Cruz","Santa Fe","Santiago del Estero","Tierra del Fuego",
            "Tucumán");
    ObservableList<String> tiposDeDocumentoLista = observableArrayList("DNI", "LE", "LC");
    private final int ULTIMO_ANO_VIGENTE = 1998;
    @FXML private TableView<Hijo> hijosTabla;
    @FXML private TableColumn<Hijo,Integer> edadColumn;
    @FXML private TableColumn<Hijo,Character> sexoColumn;
    @FXML private TableColumn<Hijo,String> estadoCivilColumn;
    @FXML private Button editarClienteButton, agregarHijoButton, altaClienteButton, buscarClienteButton, calcularPremioButton, confirmarDatosButton, cancelarButton, modificarDatosButton, quitarHijoButton;
    @FXML private CheckBox alarmaCheckBox, garageCheckBox, rastreoVehicularCheckBox, tuercasAntirroboCheckBox;
    @FXML private ComboBox<String> tipoDocumentoComboBox, marcaComboBox, anioComboBox, localidadComboBox, modalidadDePagoComboBox, modeloComboBox, provinciaComboBox, siniestrosComboBox, tipoCoberturaComboBox;
    @FXML private DatePicker inicioCoberturaDatePicker;
    @FXML private TextField sumaAseguradaTextField, apellidoTextField, kilometrosTextField, motorTextField, nombreTextField, nroClienteTextField, nroDeDocumentoTextField, patenteTextField;
    @FXML private Pane upperPane, middlePane, bottomPane, clientDataPane;
    ObservableList<Hijo> lista = observableArrayList(new Hijo(24,'M',"CASADO"));
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoDocumentoComboBox.setItems(tiposDeDocumentoLista);
        marcaComboBox.setItems(marcasLista); //traer modelos desde bdd
        provinciaComboBox.setItems(provinciasLista);
        //localidadComboBox.setItems implementar
        anioComboBox.setItems(anos());//falta traer los años de la base de datos, donde supuestamente estarian cargados los años en que se fabrico ese modelo
        edadColumn.setCellValueFactory(new PropertyValueFactory<Hijo,Integer>("edad"));
        sexoColumn.setCellValueFactory(new PropertyValueFactory<Hijo,Character>("sexo"));
        estadoCivilColumn.setCellValueFactory(new PropertyValueFactory<Hijo,String>("estadoCivil"));
        hijosTabla.setItems(lista);
    }
    public ObservableList<String> anos() {
        ObservableList<String> anos = observableArrayList();
        for (int i = 2023; i >= ULTIMO_ANO_VIGENTE; i--) {
            anos.add(Integer.toString(i));
        }
        return anos;
    }
    @FXML
    public void cancelarAction(ActionEvent evento) {
        // Obtén la referencia al escenario (Stage) actual
        Stage stage = (Stage) ((javafx.scene.Node) evento.getSource()).getScene().getWindow();

        // Cierra la ventana actual
        stage.close();
    }
    public void modificarDatosAction(ActionEvent evento) throws IOException{
        setEstado2();
    }
    public void confirmarDatosAction(ActionEvent evento) throws IOException{
        setEstado3();
        calcularSumaAsegurada();
    }

    public void buscarClienteAction(ActionEvent evento) throws IOException{
        busquedaCliente();
    }

    public void darDeAltaClienteAction(ActionEvent evento) throws IOException{
        //altaCliente();
    }
    public void editarClienteAction(ActionEvent evento) throws IOException{
        editarClienteToggle();
    }
    public void marcaSelectedAction(ActionEvent evento) throws IOException{
        cargarModelos();
    }
    public void modeloSelectedAction(ActionEvent evento) throws IOException{
        habilitarAnios();
    }
    public void provinciaSelectedAction(ActionEvent evento) throws IOException{
        habilitarLocalidades();
    }
    public void agregarHijoAction(ActionEvent evento) throws IOException{
        //implementar! :S
    }
    public void quitarHijoAction(ActionEvent evento)throws IOException{
        //implementar!
    }

    private void calcularSumaAsegurada() {
        sumaAseguradaTextField.setText("$15 230 456");
    }
    private void editarClienteToggle(){
        if (clientDataPane.isDisabled()){
            clientDataPane.setDisable(false);
            middlePane.setDisable(true);
        }
        else {
            clientDataPane.setDisable(true);
            middlePane.setDisable(false);
        }
    }
    private void setEstado2() {
        clientDataPane.setDisable(true);
        altaClienteButton.setDisable(true);
        editarClienteButton.setDisable(false);
        buscarClienteButton.setDisable(true);
        middlePane.setDisable(false);
        modificarDatosButton.setDisable(true);
        confirmarDatosButton.setDisable(false);
        bottomPane.setDisable(true);
    }
    private void setEstado3() {
        clientDataPane.setDisable(true);
        middlePane.setDisable(true);
        modificarDatosButton.setDisable(false);
        confirmarDatosButton.setDisable(true);
        bottomPane.setDisable(false);
        editarClienteButton.setDisable(true);
    }
    private void habilitarLocalidades() {
        localidadComboBox.setDisable(false);
    }

    private void habilitarAnios() {
        anioComboBox.setDisable(false);
    }

    private void cargarModelos() {
        modeloComboBox.setDisable(false);
        if (marcaComboBox.getValue() == "HONDA"){
            modeloComboBox.setItems(modelosListaHonda);
        }
    }

    private void altaCliente(){ //faltan los caminos tistes
        clientDataPane.setDisable(true);
        middlePane.setDisable(false);
        editarClienteButton.setDisable(false);
        altaClienteButton.setDisable(true);
    }

    private void busquedaCliente() {
        apellidoTextField.setText("Profumieri");
        nombreTextField.setText("Carlo");
        nroClienteTextField.setText("42059");
        tipoDocumentoComboBox.setValue("DNI");
        nroDeDocumentoTextField.setText("41256332");
        setEstado2();
        //editarClienteButton.setDisable(false);
    }


}