package com.example.aseguradora;
import com.example.aseguradora.DTOs.*;
import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.enumeraciones.FormaPago;
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
    private final int ULTIMO_ANIO_CUBRIBLE = 1998;
    @FXML private TableView<Hijo> hijosTabla;
    @FXML private Button editarClienteButton, agregarHijoButton, altaClienteButton, buscarClienteButton, calcularPremioButton, confirmarDatosButton, cancelarButton, modificarDatosButton, quitarHijoButton;
    @FXML private CheckBox alarmaCheckBox, garageCheckBox, rastreoVehicularCheckBox, tuercasAntirroboCheckBox;
    @FXML private ComboBox<String> anioComboBox;
    @FXML private ComboBox<TipoCoberturaDTO> tipoCoberturaComboBox;
    @FXML private ComboBox<FormaPago> modalidadDePagoComboBox;
    @FXML private ComboBox<TipoDocumentoDTO> tipoDocumentoComboBox;
    @FXML private ComboBox<LocalidadDTO> localidadComboBox;
    @FXML private ComboBox<ModeloDTO> modeloComboBox;
    @FXML private ComboBox<MarcaDTO> marcaComboBox;
    @FXML private ComboBox<ProvinciaDTO> provinciaComboBox;
    @FXML private ComboBox<CantidadSiniestrosDTO> siniestrosComboBox;
    @FXML private DatePicker inicioCoberturaDatePicker;
    @FXML private TextField sumaAseguradaTextField, apellidoTextField, kilometrosTextField, motorTextField, nombreTextField, nroClienteTextField, nroDeDocumentoTextField, patenteTextField, chasisTextField;
    @FXML private Pane upperPane, middlePane, bottomPane, clientDataPane;
    @FXML private Label successMessage;
    @FXML private TextArea descripcionCoberturaTextArea;
    @FXML private TableColumn<Hijo,Integer> edadColumn;
    @FXML private TableColumn<Hijo,Character> sexoColumn;
    @FXML private TableColumn<Hijo,String> estadoCivilColumn;
    ObservableList<Hijo> listaHijos = observableArrayList();
    GestorPolizas gestorPolizas = GestorPolizas.getInstancia();
    List<LocalidadDTO>  localidadesCargadas; //cambiar a listas de objetos
    List<ModeloDTO> modelosCargados;
    List <TipoCoberturaDTO> tiposCoberturasCargadas;
    List <MedidaSeguridadDTO> medidasDeSeguridadCargadas;
    List<MarcaDTO> marcasCargadas;
    List<ProvinciaDTO> provinciasCargadas;
    List<TipoDocumentoDTO> tiposDeDocumentoLista;
    ObservableList<FormaPago> formasDePagoLista = observableArrayList(FormaPago.SEMESTRAL,FormaPago.MENSUAL);
    PolizaDTO polizaDTO = new PolizaDTO();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //ACCESO BASE DE DATOS
        accesosABaseDeDatos();
        //ACCESO BASE DE DATOS
        inicializarModalidadDePagoComboBox();
        anioComboBox.setItems(anos());//falta traer los años de la base de datos, donde supuestamente estarian cargados los años en que se fabrico ese modelo
        edadColumn.setCellValueFactory(new PropertyValueFactory<Hijo,Integer>("edad"));
        sexoColumn.setCellValueFactory(new PropertyValueFactory<Hijo,Character>("sexo"));
        estadoCivilColumn.setCellValueFactory(new PropertyValueFactory<Hijo,String>("estadoCivil"));
        hijosTabla.setItems(listaHijos);
        LocalDate fechaInicial = LocalDate.now().plusDays(1);
        inicioCoberturaDatePicker.setValue(fechaInicial);
    }

    private void accesosABaseDeDatos() {
        inicializarMarcaComboBox();
        inicializarProvinciaComboBox();
        incializarTiposdeCoberturaComboBox();
        inicializarMedidasDeSeguridadLista();
        inicializarTipoDocumentoComboBox();
        inicializarCantidadSiniestrosComboBox();
    }
    private void inicializarCantidadSiniestrosComboBox(){
        siniestrosComboBox.getItems().setAll(gestorPolizas.getAllCantidadSiniestros());
    }
    public void inicializarMarcaComboBox() {
        marcasCargadas = gestorPolizas.getMarcasList();
        marcaComboBox.getItems().addAll(marcasCargadas);
    }
    private void inicializarProvinciaComboBox() {
        provinciasCargadas = gestorPolizas.getProvinciaList();
        Collections.sort(provinciasCargadas);
        provinciaComboBox.getItems().addAll(provinciasCargadas);
    }

    private void cargarModelosPorMarca(MarcaDTO marcaSeleccionada) {//REFACTORIZAR
        int idMarca = marcaSeleccionada.getIdMarca();
        modelosCargados = gestorPolizas.getModelosList(idMarca);
        Collections.sort(modelosCargados);
        modeloComboBox.getItems().clear();
        modeloComboBox.getItems().addAll(modelosCargados);
        System.out.println("modelos de " + marcaSeleccionada + " cargados");
    }

    private void inicializarTipoDocumentoComboBox() {
        tiposDeDocumentoLista = gestorPolizas.getTiposDocumento();
        tipoDocumentoComboBox.getItems().setAll(tiposDeDocumentoLista);
    }
    private void incializarTiposdeCoberturaComboBox() {
        tiposCoberturasCargadas = gestorPolizas.getTiposDeCobertura();
        tipoCoberturaComboBox.getItems().clear();
        tipoCoberturaComboBox.getItems().setAll(tiposCoberturasCargadas);
    }
    private void inicializarMedidasDeSeguridadLista() {
        medidasDeSeguridadCargadas = gestorPolizas.getAllMedidasSeguridad();
    }

    private void inicializarModalidadDePagoComboBox() {
        modalidadDePagoComboBox.setItems(formasDePagoLista);
    }

    private <T> ObservableList<String> getNombres(List<T> objetosLista) {
        ObservableList<String> listaDeStrings = observableArrayList();
        for (T unObjeto : objetosLista) {
            listaDeStrings.add(unObjeto.toString());
        }
        Collections.sort(listaDeStrings);
        return listaDeStrings;
    }
    public ObservableList<String> anos() {
        ObservableList<String> anos = observableArrayList();
        for (int i = 2023; i >= ULTIMO_ANIO_CUBRIBLE; i--) {
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
        if (siniestrosComboBox.getValue()==null) return false;
        return true;
    }

    private void actualizarPolizaDTO() {
      /*  int numeroCliente = (int) Integer.parseInt(nroClienteTextField.getText());
        PolizaDTO polizaDTO = new PolizaDTO();
        polizaDTO.setnumeroCliente(numeroCliente);
        polizaDTO.setEstadoPoliza(EstadoPoliza.GENERADA);
        //polizaDTO.setIdModelo(getModeloId(modeloComboBox.getValue().getIdModelo()));
        polizaDTO.setIdLocalidad(getModeloId(localidadComboBox.getValue()));
        polizaDTO.setPatente(patenteTextField.getText());
        polizaDTO.setCodigoChasis(chasisTextField.getText());
        polizaDTO.setCodigoMotor(motorTextField.getText());
        polizaDTO.setIdKmPorAnio(this.getIdKmPorAnio());
        polizaDTO.setSumaAsegurada(getSumaAsegurada());
        polizaDTO.setIdMedida(this.getMedidas());

       */
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

    private List<Integer> getMedidas() {
        List<Integer> medidas = new ArrayList<>();
        if (alarmaCheckBox.isSelected()) medidas.add(getIdMedida("Alarma"));
        if (garageCheckBox.isSelected()) medidas.add(getIdMedida("Garage"));
        if (rastreoVehicularCheckBox.isSelected()) medidas.add(getIdMedida("Rastreo Vehicular"));
        if (tuercasAntirroboCheckBox.isSelected()) medidas.add(getIdMedida("Tuercas Antirrobo"));
        System.out.println(medidas.toString());
        return medidas;
    }

    private int getIdMedida(String nombre){
        for(MedidaSeguridadDTO medidaSeguridadDTO : medidasDeSeguridadCargadas){
            if (medidaSeguridadDTO.getNombre().equals(nombre)) return medidaSeguridadDTO.getIdMedida();
        }
        return 0;
    }

    private int getIdKmPorAnio() { //ARREGLAR TABLA
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
        habilitarModeloComboBox();
    }

    private void habilitarModeloComboBox() {
        modeloComboBox.setDisable(false);
    }

    public void coberturaSelectedAction(ActionEvent evento) throws IOException{
        descripcionCoberturaTextArea.setText(tipoCoberturaComboBox.getValue().getDescripcion());
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
    public void calcularPremioAction(ActionEvent evento)throws IOException{
        PolizaDTO datosPoliza = getPolizaDTO();
        ClienteDTO datosCliente = getClienteDTO();
        List<HijoDTO> datosHijoLista = getHijosDTO();
        PremioyDerechosDTO premioYDerechosDTO = CalculadoraMontos.calcularPremioyDerechos(datosPoliza,datosCliente);
        polizaDTO.setPremioYDerechos(premioYDerechosDTO);
        gestorPolizas.generarPoliza(datosPoliza, datosHijoLista, datosCliente);
        System.out.println("POLIZA GENERADA!");
    }

    public PolizaDTO getPolizaDTO(){
        PolizaDTO polizaDTO = new PolizaDTO();
        //polizaDTO.setNumeroPoliza();
        polizaDTO.setEstadoPoliza(EstadoPoliza.GENERADA);
        polizaDTO.setSumaAsegurada(getSumaAsegurada());
        polizaDTO.setFechaInicio(Date.from(inicioCoberturaDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        polizaDTO.setFechaFin(Date.from(inicioCoberturaDatePicker.getValue().plusMonths(6).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        polizaDTO.setFormaPago(modalidadDePagoComboBox.getValue());
        polizaDTO.setPatente(patenteTextField.getText());
        polizaDTO.setCodigoMotor(motorTextField.getText());
        polizaDTO.setCodigoChasis(chasisTextField.getText());
        polizaDTO.setIdTipoCobertura(tipoCoberturaComboBox.getValue().getIdTipo());
        polizaDTO.setAnio(Integer.parseInt(anioComboBox.getValue()));
        polizaDTO.setIdModelo(modeloComboBox.getValue().getIdModelo());
        polizaDTO.setIdLocalidad(localidadComboBox.getValue().getIdLocalidad());
        polizaDTO.setIdMedida(getMedidas());
        polizaDTO.setIdKmPorAnio(getIdKmPorAnio());
        polizaDTO.setIdCantidadSiniestros(siniestrosComboBox.getValue().getIdCantidadSiniestros());
        //polizaDTO.setPrima();
        //polizaDTO.setDescuento();
        //polizaDTO.setDerechoEmision();
        //polizaDTO.setBaseAnualPrima();
        //polizaDTO.setMontoTotal();
        return polizaDTO;

    }

    private ClienteDTO getClienteDTO() {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNumeroCliente(Integer.parseInt(nroClienteTextField.getText()));
        clienteDTO.setNombre(nombreTextField.getText());
        clienteDTO.setApellido(apellidoTextField.getText());
        clienteDTO.setTipoDocumento(tipoDocumentoComboBox.getValue().getIdTipoDocumento());
        clienteDTO.setNumeroDocumento(Integer.parseInt(nroDeDocumentoTextField.getText()));
        return clienteDTO;
    }

    private List<HijoDTO> getHijosDTO() {
        List<HijoDTO> hijosDTOList = new ArrayList<>();

        for (Hijo hijo : listaHijos) {
            HijoDTO hijoDTO = new HijoDTO();
            hijoDTO.setSexo(hijo.getSexo());
            hijoDTO.setIdHijo(listaHijos.indexOf(hijo));
            hijoDTO.setIdEstadoCivil(hijo.getEstadoCivil().getIdEstadoCivil());
            hijoDTO.setFechaNacimiento(hijo.getFechaNacimiento());
            hijosDTOList.add(hijoDTO);
            System.out.println("id estado civil: " + hijo.getEstadoCivil().getIdEstadoCivil());
        }

        return hijosDTOList;
    }

    private void calcularPremioyDerechos(){

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
        calcularPremioButton.setDisable(true);
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
    public int getMarcaId(String nombreMarca) {
        for (MarcaDTO unaMarca : marcasCargadas) {
            if (unaMarca.getNombre().equals(nombreMarca)){
                return unaMarca.getIdMarca();
            }
        }
        return 0;
    }

    private void cargarLocalidadesPorProvincia(ProvinciaDTO provincia) {
        int idProvincia = provincia.getIdProvincia();
        localidadesCargadas = GestorPolizas.getInstancia().getLocalidadList(idProvincia);
        Collections.sort(localidadesCargadas);
        localidadComboBox.getItems().clear();
        localidadComboBox.getItems().addAll(localidadesCargadas);
    }
    private void altaCliente(){ //faltan los caminos tristes(trycatch?)
        Integer numeroAleatorio = new java.util.Random().nextInt(1000) + 1;
        nroClienteTextField.setText(String.valueOf(numeroAleatorio));
        setEstado2();
    }

    private void busquedaCliente() {
        ClienteDTO clienteDTO = gestorPolizas.getClienteDTO();
        apellidoTextField.setText(clienteDTO.getApellido());
        nombreTextField.setText(clienteDTO.getNombre());
        nroClienteTextField.setText(clienteDTO.getNumeroClienteString());
        seleccionarTipoDocumento(clienteDTO.getTipoDocumentoId());
        nroDeDocumentoTextField.setText(clienteDTO.getNumeroDocumentoString());
        setEstado2();
        //editarClienteButton.setDisable(false);
    }
    private void seleccionarTipoDocumento(int tipoDocumentoId){
        for (TipoDocumentoDTO tipoDocumento : tipoDocumentoComboBox.getItems()) {
            if (tipoDocumento.getIdTipoDocumento() == tipoDocumentoId) {
                tipoDocumentoComboBox.setValue(tipoDocumento);
                break;
            }
        }
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









