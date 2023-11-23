package com.example.aseguradora;
import com.example.aseguradora.DTOs.PolizaDTO;
import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.gestores.GestorPolizas;
import com.example.aseguradora.persistentes.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class AltaPoliza implements Initializable{
    private final int ULTIMO_ANIO_ELEGIBLE = 1998;
    @FXML private TableView<Hijo> hijosTabla;
    @FXML private Button editarClienteButton, agregarHijoButton, altaClienteButton, buscarClienteButton, calcularPremioButton, confirmarDatosButton, cancelarButton, modificarDatosButton, quitarHijoButton;
    @FXML private CheckBox alarmaCheckBox, garageCheckBox, rastreoVehicularCheckBox, tuercasAntirroboCheckBox;
    @FXML private ComboBox<String> tipoDocumentoComboBox, marcaComboBox, anioComboBox, localidadComboBox, modalidadDePagoComboBox, modeloComboBox, provinciaComboBox, siniestrosComboBox, tipoCoberturaComboBox;
    @FXML private DatePicker inicioCoberturaDatePicker;
    @FXML private TextField sumaAseguradaTextField, apellidoTextField, kilometrosTextField, motorTextField, nombreTextField, nroClienteTextField, nroDeDocumentoTextField, patenteTextField;
    @FXML private Pane upperPane, middlePane, bottomPane, clientDataPane;
    @FXML private Label successMessage;
    ObservableList<Hijo> listaHijos = observableArrayList();
    @FXML private TableColumn<Hijo,Integer> edadColumn;
    @FXML private TableColumn<Hijo,Character> sexoColumn;
    @FXML private TableColumn<Hijo,String> estadoCivilColumn;
    GestorPolizas gestorPolizas = GestorPolizas.getInstancia();
    List<String> marcasLista;
    List<String> provinciasLista2;
    ObservableList<String> cantidadDeSiniestrosLista = observableArrayList("Ninguno", "Uno", "Dos", "Más de Dos");
    ObservableList<String> tiposDeDocumentoLista = observableArrayList("DNI", "LE", "LC");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inicializarTipoDocumentoComboBox();
        inicializarMarcaComboBox();
        inicializarProvinciaComboBox();
        siniestrosComboBox.setItems(cantidadDeSiniestrosLista);
        //localidadComboBox.setItems implementar
        anioComboBox.setItems(anos());//falta traer los años de la base de datos, donde supuestamente estarian cargados los años en que se fabrico ese modelo
        edadColumn.setCellValueFactory(new PropertyValueFactory<Hijo,Integer>("edad"));
        sexoColumn.setCellValueFactory(new PropertyValueFactory<Hijo,Character>("sexo"));
        estadoCivilColumn.setCellValueFactory(new PropertyValueFactory<Hijo,String>("estadoCivil"));
        hijosTabla.setItems(listaHijos);
    }

    private void inicializarTipoDocumentoComboBox() {
        tipoDocumentoComboBox.setItems(tiposDeDocumentoLista);
    }

    private void inicializarProvinciaComboBox() {
        List<Provincia> listaProvincias = gestorPolizas.getProvinciaList();
        ObservableList<String> provinciasLista = observableArrayList();
        for (Provincia unaProvincia : listaProvincias) {
            provinciasLista.add(unaProvincia.getNombre());
        }
        provinciasLista2 = provinciasLista;
        provinciaComboBox.setItems(provinciasLista);
    }

    public void inicializarMarcaComboBox() {
        List<Marca> listaMarcas = gestorPolizas.getMarcasList();
        ObservableList<String> nombresMarcas = observableArrayList();
        for (Marca marca : listaMarcas) {
            nombresMarcas.add(marca.getNombre());
        }
        marcasLista = nombresMarcas;
        marcaComboBox.setItems(nombresMarcas);
    }
    public int getMarcaId(String nombreMarca) {
       return marcasLista.indexOf(nombreMarca) + 1;
    }
    public ObservableList<String> anos() {
        ObservableList<String> anos = observableArrayList();
        for (int i = 2023; i >= ULTIMO_ANIO_ELEGIBLE; i--) {
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
        setSumaAsegurada(CalculadoraMontos.calcularSumaAsegurada());
    }
    public void buscarClienteAction(ActionEvent evento) throws IOException{
        busquedaCliente();
    }

    public void darDeAltaClienteAction(ActionEvent evento) throws IOException{
        altaCliente();
    }

    public void editarClienteAction(ActionEvent evento) throws IOException{
        editarClienteToggle();
    }
    public void marcaSelectedAction(ActionEvent evento) throws IOException{
        cargarModelosPorMarca(marcaComboBox.getValue());
    }
    public void modeloSelectedAction(ActionEvent evento) throws IOException{
        habilitarAnios();
    }
    public void provinciaSelectedAction(ActionEvent evento) throws IOException{
        cargarLocalidadesPorProvincia(provinciaComboBox.getValue());
        habilitarLocalidades();
    }



    public void agregarHijoAction(ActionEvent evento) throws IOException {
        abrirVentanaAltaPolizaHijo();
        actualizarQuitarHijobutton();
    }
    public void quitarHijoAction(ActionEvent evento)throws IOException{
        listaHijos.removeLast();
        actualizarQuitarHijobutton();
    }
    public void getPolizaDTO(){
    //public PolizaDTO getPolizaDTO(){
        PolizaDTO polizaDTO = new PolizaDTO();
        polizaDTO.setEstadoPoliza(EstadoPoliza.GENERADA);
        polizaDTO.setSumaAsegurada(getSumaAsegurada());
        //polizaDTO.setFechaInicio();
        //polizaDTO.setFechaFin();
        /*polizaDTO.setFormaPago(formaPago);
        polizaDTO.setPremio(premio);
        polizaDTO.setUltimoDiaPago(ultimoDiaPago);
        polizaDTO.setPatente(patente);
        polizaDTO.setCodigoMotor(codigoMotor);
        polizaDTO.setMontoTotal(montoTotal);
        polizaDTO.setCodigoChasis(codigoChasis);
        polizaDTO.setIdTipoCobertura(idTipoCobertura);
        polizaDTO.setAnio(anio);
        polizaDTO.setIdModelo(idModelo);
        polizaDTO.setIdLocalidad(idLocalidad);
        polizaDTO.setIdMedida(idMedida);
        polizaDTO.setIdKmPorAnio(idKmPorAnio);
        polizaDTO.setIdCantidadSiniestros(idCantidadSiniestros);
        polizaDTO.setPrima(prima);
        polizaDTO.setDescuento(descuento);
        polizaDTO.setDerechoEmision(derechoEmision);
        polizaDTO.setBaseAnualPrima(baseAnualPrima);
        polizaDTO.setNumeroCliente(numeroCliente);
        polizaDTO.setIdValorPorcentualHijo(idValorPorcentualHijo);

        return polizaDTO;*/
    }
    public void setSumaAsegurada(int sumaAsegurada) {
        String formattedSuma = String.format("$%,d", sumaAsegurada);
        sumaAseguradaTextField.setText(formattedSuma);
    }
    public int getSumaAsegurada() {
        String sumaAseguradaText = sumaAseguradaTextField.getText();
        String numericValue = sumaAseguradaText.replaceAll("[^\\d]", "");
        try {
            return Integer.parseInt(numericValue);
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir a entero: " + e.getMessage());
            return 0;
        }
    }

    public void actualizarQuitarHijobutton(){
        if (listaHijos.isEmpty()) quitarHijoButton.setDisable(true);
        if (!listaHijos.isEmpty()) quitarHijoButton.setDisable(false);
    }
    private void editarClienteToggle(){
        if (clientDataPane.isDisabled()){
            clientDataPane.setDisable(false);
            middlePane.setDisable(true);
            buscarClienteButton.setDisable(false);
            successMessage.setVisible(false);
        }
        else {
            clientDataPane.setDisable(true);
            middlePane.setDisable(false);
            buscarClienteButton.setDisable(true);
            successMessage.setVisible(true);
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
        successMessage.setVisible(false); // este mensaje se podria quitar despues de unos segundos usando threads...
        actualizarQuitarHijobutton();
    }
    private void setEstado3() {
        clientDataPane.setDisable(true);
        middlePane.setDisable(true);
        modificarDatosButton.setDisable(false);
        confirmarDatosButton.setDisable(true);
        bottomPane.setDisable(false);
        editarClienteButton.setDisable(true);
        successMessage.setVisible(false);
    }
    private void habilitarLocalidades() {
        localidadComboBox.setDisable(false);
    }
    private void habilitarAnios() {
        anioComboBox.setDisable(false);
    }
    public int getProvinciaId(String nombreProvincia) {
        return provinciasLista2.indexOf(nombreProvincia) + 1;
    }
    private void cargarLocalidadesPorProvincia(String provincia) {
        int idProvincia = getProvinciaId(provincia);
        List<Localidad> listaDeLocalidades = GestorPolizas.getInstancia().getLocalidadList(idProvincia);
        actualizarLocalidadesComboBox(listaDeLocalidades);
    }
    private void actualizarLocalidadesComboBox(List<Localidad> listaDeLocalidades) {
        ObservableList<String> nombresModelos = observableArrayList();
        for (Localidad localidad : listaDeLocalidades){
            nombresModelos.add(localidad.getNombre());
        }
        Collections.sort(nombresModelos);
        localidadComboBox.setItems(nombresModelos);
        System.out.println("modelos de " + marcaComboBox.getValue() + " cargados");
    }

    public void actualizarModelosComboBox(List<ModeloVehiculo> modelosLista){
        ObservableList<String> nombresModelos = observableArrayList();
        for (ModeloVehiculo modeloVehiculo : modelosLista){
            nombresModelos.add(modeloVehiculo.getNombre());
        }
        modeloComboBox.setItems(nombresModelos);
        System.out.println("modelos de " + marcaComboBox.getValue() + " cargados");
    }

    private void cargarModelosPorMarca(String marcaSeleccionada) {
        int idMarca = getMarcaId(marcaSeleccionada);
        List<ModeloVehiculo> listaDeModelos = GestorPolizas.getInstancia().getModelosList(idMarca);
        actualizarModelosComboBox(listaDeModelos);
        modeloComboBox.setDisable(false);
    }

    private void altaCliente(){ //faltan los caminos tistes
        Integer numeroAleatorio = new java.util.Random().nextInt(1000) + 1;
        nroClienteTextField.setText(String.valueOf(numeroAleatorio));
        setEstado2();
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

    public void abrirVentanaAltaPolizaHijo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("altaPolizaHijo.fxml"));
            Parent root = loader.load();

            AltaPolizaHijoController altaPolizaHijoController = loader.getController();

            // Configurar una referencia a AltaPoliza en AltaPolizaHijoController
            altaPolizaHijoController.setAltaPolizaController(this);
            Stage stage = new Stage();
            stage.setTitle("Alta de Póliza para Hijo");
            stage.setScene(new Scene(root, 422, 201));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción según sea necesario
        }
    }

    public void agregarHijo(Hijo nuevoHijo) {
            listaHijos.add(nuevoHijo);
            actualizarQuitarHijobutton();
        }


    public void mostrarVentanaError(String mensaje) {
        try {
            // Cargar el FXML de la ventana de error
            FXMLLoader loader = new FXMLLoader(getClass().getResource("errorPopup.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la ventana de error
            ErrorPopupController errorController = loader.getController();

            // Configurar el mensaje de error
            errorController.setErrorMessage(mensaje);

            // Crear la escena y el escenario (Stage)
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Error");
            stage.setScene(scene);

            // Mostrar la ventana de error
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}









