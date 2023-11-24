package com.example.aseguradora;
import com.example.aseguradora.DTOs.ClienteDTO;
import com.example.aseguradora.DTOs.HijoDTO;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


import static javafx.collections.FXCollections.observableArrayList;

public class AltaPoliza implements Initializable{
    private final int ULTIMO_ANIO_ELEGIBLE = 1998;
    @FXML private TableView<Hijo> hijosTabla;
    @FXML private Button editarClienteButton, agregarHijoButton, altaClienteButton, buscarClienteButton, calcularPremioButton, confirmarDatosButton, cancelarButton, modificarDatosButton, quitarHijoButton;
    @FXML private CheckBox alarmaCheckBox, garageCheckBox, rastreoVehicularCheckBox, tuercasAntirroboCheckBox;
    @FXML private ComboBox<String> tipoDocumentoComboBox, marcaComboBox, anioComboBox, localidadComboBox, modalidadDePagoComboBox, modeloComboBox, provinciaComboBox, siniestrosComboBox, tipoCoberturaComboBox;
    @FXML private DatePicker inicioCoberturaDatePicker;
    @FXML private TextField sumaAseguradaTextField, apellidoTextField, kilometrosTextField, motorTextField, nombreTextField, nroClienteTextField, nroDeDocumentoTextField, patenteTextField, chasisTextField;
    @FXML private Pane upperPane, middlePane, bottomPane, clientDataPane;
    @FXML private Label successMessage;
    @FXML private TextArea descripcionCoberturaTextArea;
    ObservableList<Hijo> listaHijos = observableArrayList();
    @FXML private TableColumn<Hijo,Integer> edadColumn;
    @FXML private TableColumn<Hijo,Character> sexoColumn;
    @FXML private TableColumn<Hijo,String> estadoCivilColumn;
    GestorPolizas gestorPolizas = GestorPolizas.getInstancia();
    List<String> marcasCargadas, modelosCargados, localidadesCargadas; //cambiar a listas de objetos
    List <TipoCobertura> tiposCoberturasCargadas;
    List<String> provinciasLista2;
    PolizaDTO polizaDTO = new PolizaDTO();
    ObservableList<String> cantidadDeSiniestrosLista = observableArrayList("Ninguno", "Uno", "Dos", "Más de Dos");
    ObservableList<String> tiposDeDocumentoLista = observableArrayList("DNI", "LE", "LC");
    ObservableList<String> formasDePagoLista = observableArrayList("MENSUAL","SEMESTRAL");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inicializarTipoDocumentoComboBox();
        //ACCESO BASE DE DATOS
        //inicializarMarcaComboBox();
        //inicializarProvinciaComboBox();
        //incializarTiposdeCobertura();
        //ACCESO BASE DE DATOS
        inicializarFormaPagoComboBox();
        siniestrosComboBox.setItems(cantidadDeSiniestrosLista);
        anioComboBox.setItems(anos());//falta traer los años de la base de datos, donde supuestamente estarian cargados los años en que se fabrico ese modelo
        edadColumn.setCellValueFactory(new PropertyValueFactory<Hijo,Integer>("edad"));
        sexoColumn.setCellValueFactory(new PropertyValueFactory<Hijo,Character>("sexo"));
        estadoCivilColumn.setCellValueFactory(new PropertyValueFactory<Hijo,String>("estadoCivil"));
        hijosTabla.setItems(listaHijos);
        LocalDate fechaInicial = LocalDate.now().plusDays(1);
        inicioCoberturaDatePicker.setValue(fechaInicial);
    }

    private <T> ObservableList<String> getNombres(List<T> objetosLista) {
        ObservableList<String> listaDeStrings = observableArrayList();
        for (T unObjeto : objetosLista) {
            listaDeStrings.add(unObjeto.toString());
        }
        return listaDeStrings;
    }

    private void incializarTiposdeCobertura() {
        tiposCoberturasCargadas = gestorPolizas.getTiposDeCobertura();
        tipoCoberturaComboBox.setItems(getNombres(tiposCoberturasCargadas));
    }
    private void inicializarFormaPagoComboBox() {
        modalidadDePagoComboBox.setItems(formasDePagoLista);
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
        marcasCargadas = nombresMarcas;
        marcaComboBox.setItems(nombresMarcas);
    }

    public int getMarcaId(String nombreMarca) {
       return marcasCargadas.indexOf(nombreMarca) + 1;
    }
    private int getLocalidadId(String nombreLocalidad){return localidadesCargadas.indexOf(nombreLocalidad)+1;}
    private int getModeloId(String nombreModelo){return modelosCargados.indexOf(nombreModelo)+1;}
    public ObservableList<String> anos() {
        ObservableList<String> anos = observableArrayList();
        for (int i = 2023; i >= ULTIMO_ANIO_ELEGIBLE; i--) {
            anos.add(Integer.toString(i));
        }
        return anos;
    }
    @FXML
    public void cancelarAction(ActionEvent evento) {
        Stage stage = (Stage) ((javafx.scene.Node) evento.getSource()).getScene().getWindow();
        stage.close();
    }
    public void modificarDatosAction(ActionEvent evento) throws IOException{
        setEstado2();
    }
    public void confirmarDatosAction(ActionEvent evento) throws IOException{
        if (!validarDatosIngresadosVehiculo()) {
            mostrarVentanaError("Verificar que los campos esten debidamente completados");
            return;
        }
        //gestorPolizas.guardarPoliza(getPolizaDTO());
        setSumaAsegurada(CalculadoraMontos.calcularSumaAsegurada());
        actualizarPolizaDTO();
        setEstado3();
    }
    private boolean validarDatosIngresadosVehiculo() {
        if (anioComboBox.getValue() == null) return false;
        if (marcaComboBox.getValue()==null) return false;
        if (modeloComboBox.getValue()==null) return false;
        if (provinciaComboBox.getValue()==null) return false;
        if (localidadComboBox.getValue()==null) return false;
        if (patenteTextField.getText()==null) return false;
        if (chasisTextField.getText()==null) return false;
        if (motorTextField.getText().isEmpty()) return false;
        if (kilometrosTextField.getText().isEmpty()) return false;
        if (siniestrosComboBox.getValue().isEmpty()) return false;
        return true;
    }

    private void actualizarPolizaDTO() {
        int numeroCliente = (int) Integer.parseInt(nroClienteTextField.getText());
        PolizaDTO polizaDTO = new PolizaDTO();
        polizaDTO.setnumeroCliente(numeroCliente);
        polizaDTO.setEstadoPoliza(EstadoPoliza.GENERADA);
        polizaDTO.setIdModelo(getModeloId(marcaComboBox.getValue()));
        polizaDTO.setIdLocalidad(getModeloId(localidadComboBox.getValue()));
        polizaDTO.setPatente(patenteTextField.getText());
        polizaDTO.setCodigoChasis(chasisTextField.getText());
        polizaDTO.setCodigoMotor(motorTextField.getText());
        polizaDTO.setIdKmPorAnio(this.getIdKmPorAnio());
        polizaDTO.setSumaAsegurada(getSumaAsegurada());
        polizaDTO.setIdMedida(this.getMedidas());
        //polizaDTO.setHijos
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
        polizaDTO.setIdValorPorcentualHijo(idValorPorcentualHijo);*/

    }

    private int[] getMedidas() {
        int[] medidas = new int[4];
        if (alarmaCheckBox.isSelected()) medidas[0] = 1;
        if (garageCheckBox.isSelected()) medidas[1] = 2;
        if (rastreoVehicularCheckBox.isSelected()) medidas[2] = 3;
        if (tuercasAntirroboCheckBox.isSelected()) medidas[3] = 4;
        return medidas;
    }

    private int getIdKmPorAnio() {
       int kmPorAnio = Integer.parseInt(kilometrosTextField.getText());
       int id = kmPorAnio / 1000 + 1;
       return id;
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
    public void coberturaSelectedAction(ActionEvent evento) throws IOException{
        String descripcion = getDescripcionCobertura(tipoCoberturaComboBox.getValue());
        descripcionCoberturaTextArea.setText(descripcion);
    }

    private String getDescripcionCobertura(String nombreCobertura) {
        for (TipoCobertura unaCobertura : tiposCoberturasCargadas) {
            if (unaCobertura.getNombre() == nombreCobertura) return unaCobertura.getDescripcion();
        }
        return "ERROR AL OBTENER LA DESCRIPCIÓN DE LA COBERTURA";
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
        //listaHijos.removeLast();
        actualizarQuitarHijobutton();
    }
    public void calcularPremioAction(ActionEvent evento)throws IOException{
        PolizaDTO datosPoliza = getPolizaDTO();
        ClienteDTO datosCliente = getClienteDTO();
        List<HijoDTO> datosHijoLista = getHijosDTO();
        gestorPolizas.generarPoliza(datosPoliza, datosHijoLista, datosCliente);
        System.out.println("POLIZA GENERADA");
    }

    private ClienteDTO getClienteDTO() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNumeroCliente(Integer.parseInt(nroClienteTextField.getText()));
        clienteDTO.setNombre(nombreTextField.getText());
        clienteDTO.setApellido(apellidoTextField.getText());
        clienteDTO.setTipoDocumento(tipoDocumentoComboBox.getValue());
        clienteDTO.setNumeroDocumento(Integer.parseInt(nroDeDocumentoTextField.getText()));
        return clienteDTO;
    }

    private List<HijoDTO> getHijosDTO() {
        List<HijoDTO> hijosDTOList = new ArrayList<>();

        for (Hijo hijo : listaHijos) {
            HijoDTO hijoDTO = new HijoDTO();
            hijoDTO.setSexo(hijo.getSexo());
            hijoDTO.setIdHijo(listaHijos.indexOf(hijo));
            hijoDTO.setIdEstadoCivil(hijo.getIdEstadoCivil());
            hijoDTO.setFechaNacimiento(hijo.getFechaNacimiento());
            hijosDTOList.add(hijoDTO);
        }

        return hijosDTOList;
    }

    public PolizaDTO getPolizaDTO(){
        PolizaDTO polizaDTO = new PolizaDTO();
        polizaDTO.setEstadoPoliza(EstadoPoliza.GENERADA);
        polizaDTO.setSumaAsegurada(Integer.parseInt(sumaAseguradaTextField.getText()));
        polizaDTO.setFechaInicio(Date.from(inicioCoberturaDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        //polizaDTO.setFechaFin();
        //polizaDTO.setFormaPago(formaPago);
        //polizaDTO.setPremio(premio);
        //polizaDTO.setUltimoDiaPago(ultimoDiaPago);
        polizaDTO.setPatente(patenteTextField.getText());
        polizaDTO.setCodigoMotor(motorTextField.getText());
        //polizaDTO.setMontoTotal(montoTotal);
        polizaDTO.setCodigoChasis(chasisTextField.getText());
        //polizaDTO.setIdTipoCobertura(idTipoCobertura);
        polizaDTO.setAnio(Integer.parseInt(anioComboBox.getValue()));
        //polizaDTO.setIdModelo(idModelo);
        //polizaDTO.setIdLocalidad(idLocalidad);
        //polizaDTO.setIdMedida(idMedida);
        //polizaDTO.setIdKmPorAnio(idKmPorAnio);
        //polizaDTO.setIdCantidadSiniestros(idCantidadSiniestros);
        //polizaDTO.setPrima(prima);
        //polizaDTO.setDescuento(descuento);
        //polizaDTO.setDerechoEmision(derechoEmision);
        //polizaDTO.setBaseAnualPrima(baseAnualPrima);
        //polizaDTO.setNumeroCliente(numeroCliente);
        //polizaDTO.setIdValorPorcentualHijo(idValorPorcentualHijo);

        return polizaDTO;

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
        calcularPremioButton.setDisable(false);
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
        ObservableList<String> nombresLocalidades = observableArrayList();
        for (Localidad localidad : listaDeLocalidades){
            nombresLocalidades.add(localidad.getNombre());
        }
        Collections.sort(nombresLocalidades);
        localidadComboBox.setItems(nombresLocalidades);
        localidadesCargadas = nombresLocalidades;
        System.out.println("Localidades de " + provinciaComboBox.getValue() + " cargadas");
    }

    public void actualizarModelosComboBox(List<ModeloVehiculo> modelosLista){
        ObservableList<String> nombresModelos = observableArrayList();
        for (ModeloVehiculo modeloVehiculo : modelosLista){
            nombresModelos.add(modeloVehiculo.getNombre());
        }
        modelosCargados = nombresModelos;
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









