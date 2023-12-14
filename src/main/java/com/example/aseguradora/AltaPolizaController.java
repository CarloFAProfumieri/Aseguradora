package com.example.aseguradora;
import com.example.aseguradora.DTOs.*;
import com.example.aseguradora.enumeraciones.EstadoPoliza;
import com.example.aseguradora.enumeraciones.FormaPago;
import com.example.aseguradora.gestores.GestorPolizas;
import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;


import static javafx.collections.FXCollections.observableArrayList;

public class AltaPolizaController implements Initializable{

    @FXML private Button editarClienteButton, altaClienteButton, buscarClienteButton, calcularPremioButton, confirmarDatosButton, cancelarButton, modificarDatosButton, quitarHijoButton;
    @FXML private CheckBox alarmaCheckBox, garageCheckBox, rastreoVehicularCheckBox, tuercasAntirroboCheckBox;
    @FXML private ComboBox<AnioDTO> anioComboBox;
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
    @FXML private Pane middlePane, bottomPane, clientDataPane;
    @FXML private TextArea descripcionCoberturaTextArea;
    @FXML private TableView<HijoDTO> hijosTabla;
    @FXML private TableColumn<HijoDTO,Integer> edadColumn;
    @FXML private TableColumn<HijoDTO,Character> sexoColumn;
    @FXML private TableColumn<HijoDTO, String> estadoCivilColumn;
    @FXML private Label patenteErrorLabel, chasisErrorLabel, motorErrorLabel;
    @FXML private Tooltip patenteErrorTooltip, chasisErrorTooltip, motorErrorTooltip;
    ObservableList<HijoDTO> listaHijos = observableArrayList();
    GestorPolizas gestorPolizas = GestorPolizas.getInstancia();
    List<LocalidadDTO>  localidadesCargadas; //cambiar a listas de objetos
    List<ModeloDTO> modelosCargados;
    List <TipoCoberturaDTO> tiposDeCoberturaLista;
    List <MedidaSeguridadDTO> medidasDeSeguridadCargadas;
    List <CantidadSiniestrosDTO> cantidadDeSiniestrosList;
    List<MarcaDTO> marcasCargadas;
    List<ProvinciaDTO> provinciasCargadas;
    List<TipoDocumentoDTO> tiposDeDocumentoLista;
    ObservableList<FormaPago> formasDePagoLista = observableArrayList(FormaPago.SEMESTRAL,FormaPago.MENSUAL);
    PolizaDTO datosPolizaDTO = new PolizaDTO();
    ClienteDTO clienteDTO = new ClienteDTO();
    List<HijoDTO> hijoDTOs = new ArrayList<>();
    private boolean busquedaExitosa = false;
    private boolean patenteValida = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //ACCESO BASE DE DATOS
        accesosABaseDeDatos();
        //ACCESO BASE DE DATOS
        listeners();
        clientDataPane.setDisable(true);
        patenteErrorLabel.setVisible(false);
        chasisErrorLabel.setVisible(false);
        motorErrorLabel.setVisible(false);
        inicializarModalidadDePagoComboBox();
        calcularPremioButton.setDisable(true);
        edadColumn.setStyle("-fx-alignment: CENTER;");
        sexoColumn.setStyle("-fx-alignment: CENTER;");
        estadoCivilColumn.setStyle("-fx-alignment: CENTER;");
        edadColumn.setCellValueFactory(new PropertyValueFactory<HijoDTO,Integer>("edad"));
        sexoColumn.setCellValueFactory(new PropertyValueFactory<HijoDTO,Character>("sexo"));
        estadoCivilColumn.setCellValueFactory(new PropertyValueFactory<HijoDTO,String>("estadoCivil"));
        hijosTabla.setItems(listaHijos);
        LocalDate fechaInicial = LocalDate.now().plusDays(1);
        inicioCoberturaDatePicker.setValue(fechaInicial);
    }

    private void listeners() {
        listenerPatente();
    }

    private void listenerPatente() {
        patenteTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    quitarErrorViewer(patenteErrorLabel);
                } else {
                    patenteValida = formatearVerificarPatenteIngresada();
                }
            }
        });
    }

    private void quitarErrorViewer(Label label){
        label.setVisible(false);
    }
    private boolean formatearVerificarPatenteIngresada() {
        String input = patenteTextField.getText().toUpperCase();
        // Use a regular expression to check if the input matches the format AA-999-AA
        if (input.matches("[A-Z]{2}-\\d{3}-[A-Z]{2}")) {
            formatearPatente(1);
            return true;
        }
        if (input.matches("[A-Z]{2}\\d{3}[A-Z]{2}")){
            formatearPatente(2);
            return true;
        }
        if (input.matches("[A-Z]{3}-\\d{3}")){
            formatearPatente(1);
            return true;
        }
        if (input.matches("[A-Z]{3}\\d{3}")){
            formatearPatente(2);
            return true;
        }
        if ("".equals(input)){
            return true;
        }
        mostrarErrorViewer("MODERADO", patenteErrorLabel, patenteErrorTooltip,"Por favor ingrese un formato de patente válido", true);
        return false;
    }
    private void mostrarErrorViewer(String severidad, Label label, Tooltip tooltip, String mensaje, boolean mostrar) {
        double screenY = getYCoordinate(tooltip,label);
        double screenX = getXCoordinate(tooltip,label);
        Stage stage = (Stage) label.getScene().getWindow();

        if ("GRAVE".equals(severidad)) {
            label.setTextFill(Color.RED);
        } else if ("MODERADO".equals(severidad)) {
            label.setTextFill(Color.ORANGE);
        }
        tooltip.setText(mensaje);
        tooltip.setShowDelay(Duration.ZERO);
        label.setVisible(true);
        if (mostrar) {
            tooltip.show(stage, screenX, screenY);
            Duration delay = Duration.seconds(1.5);
            PauseTransition delayTransition = new PauseTransition(delay);
            delayTransition.setOnFinished(event -> tooltip.hide());
            delayTransition.play();
        }
    }
    private double getXCoordinate(Tooltip tooltip, Label label){
        double screenX = label.localToScreen(label.getBoundsInLocal()).getMinX();
        double maxX = Screen.getPrimary().getVisualBounds().getMaxX();
        if (screenX + tooltip.getWidth() > maxX) {
            screenX = maxX - tooltip.getWidth();
        }
        return screenX;
    }
    private double getYCoordinate(Tooltip tooltip, Label label){
        double screenY = label.localToScreen(label.getBoundsInLocal()).getMinY();
        double maxY = Screen.getPrimary().getVisualBounds().getMaxY();
        if (screenY + tooltip.getHeight() > maxY) {
            screenY = maxY - tooltip.getHeight();
        }
        return screenY;
    }
    private void formatearPatente(int caso) {
        switch (caso) {
            case 1: //tiene guiones
                patenteTextField.setText((patenteTextField.getText().toUpperCase()));
                return;
            case 2: //no tiene guiones
                patenteTextField.setText((agregarGuionesPatente(patenteTextField.getText().toUpperCase())));
                return;
        }
    }
    private String agregarGuionesPatente(String patente) {
        patente = patente.replaceAll("-", "");

        // Verificar la longitud del texto y agregar guiones según el formato AA-999-AA
        if (patente.length() == 7) {
            return patente.substring(0, 2) + "-" + patente.substring(2, 5) + "-" + patente.substring(5);
        }
        if (patente.length() == 6){
            return patente.substring(0,3) + "-" + patente.substring(3,6);
        }
        return patente;
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
        cantidadDeSiniestrosList = gestorPolizas.getAllCantidadSiniestros();
        siniestrosComboBox.getItems().clear();
        siniestrosComboBox.getItems().setAll(cantidadDeSiniestrosList);
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
    private void cargarModelosPorMarca(MarcaDTO marcaSeleccionada) {
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
        tiposDeCoberturaLista = gestorPolizas.getTiposDeCobertura();
        tipoCoberturaComboBox.getItems().clear();
        tipoCoberturaComboBox.getItems().setAll(tiposDeCoberturaLista);
    }
    private void inicializarMedidasDeSeguridadLista() {
        medidasDeSeguridadCargadas = gestorPolizas.getAllMedidasSeguridad();
    }
    private void inicializarModalidadDePagoComboBox() {
        modalidadDePagoComboBox.setItems(formasDePagoLista);
        modalidadDePagoComboBox.setValue(FormaPago.MENSUAL);
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
            mostrarVentanaError("Los campos no fueron completados correctamente");
            return;
        }
        if (gestorPolizas.existePatenteVigente(patenteTextField.getText())){
            mostrarVentanaError("Patente ya existente en la base de datos");
            return;
        }
        setSumaAsegurada(SistemaAutoscoring.calcularSumaAsegurada(modeloComboBox.getValue().getIdModelo(), anioComboBox.getValue().getAnio()));
        setEstado3();
    }
    private boolean validarDatosIngresadosVehiculo() {
        if (anioComboBox.getValue() == null) return false;
        if (marcaComboBox.getValue()==null) return false;
        if (modeloComboBox.getValue()==null) return false;
        if (provinciaComboBox.getValue()==null) return false;
        if (localidadComboBox.getValue()==null) return false;
        if (chasisTextField.getText().isEmpty()) return false;
        if (motorTextField.getText().isEmpty()) return false;
        if (kilometrosTextField.getText().isEmpty()) return false;
        if (siniestrosComboBox.getValue()==null) return false;
        if (!patenteValida) return false;
        return true;
    }

    private List<Integer> getMedidas() {
        List<Integer> medidas = new ArrayList<>();
        if (alarmaCheckBox.isSelected()) medidas.add(getIdMedida("Alarma"));
        if (garageCheckBox.isSelected()) medidas.add(getIdMedida("Garage"));
        if (rastreoVehicularCheckBox.isSelected()) medidas.add(getIdMedida("Rastreo Vehicular"));
        if (tuercasAntirroboCheckBox.isSelected()) medidas.add(getIdMedida("Tuercas Antirrobo"));
        System.out.println(medidas);
        return medidas;
    }

    private int getIdMedida(String nombre){
        for(MedidaSeguridadDTO medidaSeguridadDTO : medidasDeSeguridadCargadas){
            if (medidaSeguridadDTO.getNombre().equals(nombre)) return medidaSeguridadDTO.getIdMedida();
        }
        return 0;
    }

    private int getIdKmPorAnio() {
        return gestorPolizas.getIdKmPorAnio(Integer.valueOf(kilometrosTextField.getText()));
    }

    public void buscarClienteAction(ActionEvent evento) throws IOException{
        abrirVentanaBuscarCliente();
        if (!busquedaExitosa){
            return;
        }
        setCamposCliente();
        int idCantidadSiniestros = SistemaAutoscoring.getCantidadSiniestros();
        setCantidadSiniestros(idCantidadSiniestros);
        setEstado2();
        busquedaExitosa = false;
    }
    private void abrirVentanaBuscarCliente() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("buscarCliente.fxml"));
            Parent root = loader.load();

            BuscarClienteController buscarClienteController = loader.getController();

            // Configurar una referencia a AltaPoliza en AltaPolizaHijoController
            buscarClienteController.setAltaPolizaController(this);
            Stage stage = new Stage();
            Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
            stage.setTitle("Busqueda de Cliente");
            stage.getIcons().add(imagen);
            stage.setScene(new Scene(root, 815, 554));
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción según sea necesario
        }
    }

    private void setCantidadSiniestros(int cantidadSiniestrosId){
        for(CantidadSiniestrosDTO unaCantSiniestrosIterada : cantidadDeSiniestrosList){
            if (unaCantSiniestrosIterada.getIdCantidadSiniestros() == cantidadSiniestrosId){
                siniestrosComboBox.setValue(unaCantSiniestrosIterada);
            }
        }
    }
    public void darDeAltaClienteAction(ActionEvent evento) throws IOException{
        altaCliente();
    }

    public void editarClienteAction(ActionEvent evento) throws IOException{
        editarClienteToggle();
    }

    public void marcaSelectedAction(ActionEvent evento) throws IOException{
        anioComboBox.getItems().clear();
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
        actualizarAniosComboBox();
    }

    public void provinciaSelectedAction(ActionEvent evento) throws IOException{
        cargarLocalidadesPorProvincia(provinciaComboBox.getValue());
        habilitarLocalidades();
    }
    public void agregarHijoAction(ActionEvent evento) throws IOException {
        abrirVentanaAltaPolizaHijo();
        actualizarQuitarHijobutton();
    }
    public void quitarHijoAction(ActionEvent evento) throws IOException {
        // Obtén el índice del elemento seleccionado en la TableView
        int selectedIndex = hijosTabla.getSelectionModel().getSelectedIndex();

        // Verifica si se seleccionó un elemento antes de intentar eliminar
        if (selectedIndex != -1) {
            // Elimina el elemento correspondiente de la lista
            listaHijos.remove(selectedIndex);

            // Actualiza la TableView con la nueva lista de hijos
            hijosTabla.setItems(listaHijos);

            // Actualiza cualquier lógica adicional después de quitar un elemento
            actualizarQuitarHijobutton();
        }
    }
    public void calcularPremioAction(ActionEvent evento)throws IOException{
        actualizarDatosPolizaDTO();
        actualizarDatosClienteDTO();
        ParametrosMontoDTO premioYDerechosDTO = SistemaAutoscoring.calcularPremioyDerechos(datosPolizaDTO,clienteDTO);
        datosPolizaDTO.setPremioYDerechos(premioYDerechosDTO);
        cargarPantallaConfirmarPoliza(new ConfirmarPolizaDTO(datosPolizaDTO,clienteDTO));
    }
    public void confirmarPolizaAction(ActionEvent evento){
        gestorPolizas.generarPoliza(datosPolizaDTO, getHijosDTO(), clienteDTO);
        System.out.println("POLIZA GENERADA!");
    }
    public void anioComboBoxSelected(ActionEvent evento){
        if (anioComboBox.getValue().getAnio() <= LocalDate.now().getYear() - 10){
            setTipoCoberturaComboBox(1);
            System.out.println("El vehículo solo puede acceder a coberturas por Responsabilidad Civil");
        }
        else {
            incializarTiposdeCoberturaComboBox();
        }
    }
    public void setTipoCoberturaComboBox(int idCobertura){
        TipoCoberturaDTO tipoCoberturaDTO = null;
        for(TipoCoberturaDTO coberturaDTOIteracion : tiposDeCoberturaLista){
            if (coberturaDTOIteracion.getIdTipo() == idCobertura){
                tipoCoberturaDTO = coberturaDTOIteracion;
            }
        }
        tipoCoberturaComboBox.getItems().setAll(tipoCoberturaDTO);

    }
    public void actualizarDatosPolizaDTO(){
        datosPolizaDTO.setEstadoPoliza(EstadoPoliza.GENERADA);
        datosPolizaDTO.setSumaAsegurada(getSumaAsegurada());
        datosPolizaDTO.setFechaInicio(inicioCoberturaDatePicker.getValue());
        datosPolizaDTO.setFechaFin(inicioCoberturaDatePicker.getValue().plusMonths(6));
        datosPolizaDTO.setFormaPago(modalidadDePagoComboBox.getValue());
        datosPolizaDTO.setPatente(patenteTextField.getText());
        datosPolizaDTO.setCodigoMotor(motorTextField.getText());
        datosPolizaDTO.setCodigoChasis(chasisTextField.getText());
        datosPolizaDTO.setIdTipoCobertura(tipoCoberturaComboBox.getValue().getIdTipo());
        datosPolizaDTO.setAnio(Integer.parseInt(anioComboBox.getValue().toString()));
        datosPolizaDTO.setIdModelo(modeloComboBox.getValue().getIdModelo());
        datosPolizaDTO.setModelo(modeloComboBox.getValue().getNombre());
        datosPolizaDTO.setIdLocalidad(localidadComboBox.getValue().getIdLocalidad());
        datosPolizaDTO.setIdMedidas(getMedidas());
        datosPolizaDTO.setIdKmPorAnio(getIdKmPorAnio());
        datosPolizaDTO.setIdCantidadSiniestros(siniestrosComboBox.getValue().getIdCantidadSiniestros());
        datosPolizaDTO.setIdValorPorcentualHijo(getHijosDTO().size()+1);
        List <LocalDate> ultimodiapago = new ArrayList<>();
        ultimodiapago.add(inicioCoberturaDatePicker.getValue().minusDays(1));
        datosPolizaDTO.setUltimoDiaPago(ultimodiapago);
        datosPolizaDTO.setMarca(marcaComboBox.getValue().getNombre());
    }
    private void actualizarDatosClienteDTO() {
        clienteDTO.setNumeroCliente(Integer.parseInt(String.valueOf(Integer.valueOf(nroClienteTextField.getText()))));
        clienteDTO.setNombre(nombreTextField.getText());
        clienteDTO.setApellido(apellidoTextField.getText());
        clienteDTO.setTipoDocumentoId(tipoDocumentoComboBox.getValue().getIdTipoDocumento());
        clienteDTO.setNumeroDocumento(Integer.parseInt(nroDeDocumentoTextField.getText()));
    }

    private List<HijoDTO> getHijosDTO() {
        List<HijoDTO> hijosDTOList = new ArrayList<>();

        for (HijoDTO hijo : listaHijos) {
            HijoDTO hijoDTO = new HijoDTO();
            hijoDTO.setSexo(hijo.getSexo());
            hijoDTO.setEstadoCivilId(hijo.getEstadoCivilId());
            hijoDTO.setFechaNacimiento(hijo.getFechaNacimiento());
            hijosDTOList.add(hijoDTO);
            System.out.println(hijoDTO);
        }

        return hijosDTOList;
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
            mostrarVentanaError("Error al obtener la suma asegurada. Reinicie el programa para continuar");
        }
        return 0;
    }
    public void actualizarQuitarHijobutton(){
        if (listaHijos.isEmpty()) quitarHijoButton.setDisable(true);
        if (!listaHijos.isEmpty()) quitarHijoButton.setDisable(false);
    }


    public void editarClienteToggle(){
        if (buscarClienteButton.isDisabled()){
            //clientDataPane.setDisable(false);
            middlePane.setDisable(true);
            buscarClienteButton.setDisable(false);
            editarClienteButton.setDisable(true);
            confirmarDatosButton.setDisable(true);
        }
        else {
            //clientDataPane.setDisable(true);
            middlePane.setDisable(false);
            buscarClienteButton.setDisable(true);
            confirmarDatosButton.setDisable(false);
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
        calcularPremioButton.setDisable(false);
    }
    private void habilitarLocalidades() {
        localidadComboBox.setDisable(false);
    }
    private void actualizarAniosComboBox() {
        int idModelo = modeloComboBox.getValue().getIdModelo();
        List<AnioDTO> anios = gestorPolizas.getAnios(idModelo);
        Collections.sort(anios);
        anioComboBox.getItems().clear();
        anioComboBox.getItems().addAll(anios);
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

    private void setCamposCliente() {
        apellidoTextField.setText(clienteDTO.getApellido());
        nombreTextField.setText(clienteDTO.getNombre());
        nroClienteTextField.setText(clienteDTO.getNumeroClienteString());
        seleccionarTipoDocumento(clienteDTO.getTipoDocumentoId());
        nroDeDocumentoTextField.setText(clienteDTO.getNumeroDocumentoString());
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
            Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
            stage.getIcons().add(imagen);
            stage.setScene(new Scene(root, 422, 201));
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            mostrarVentanaError("Error fatal. Reinicie el programa para continuar");
        }
    }

    public void agregarHijo(HijoDTO nuevoHijo) {
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

    private void cargarPantallaConfirmarPoliza(ConfirmarPolizaDTO confirmarPolizaDTO) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ConfirmarPoliza.fxml"));
        Parent root = loader.load();
        ConfirmarPolizaController confirmarPolizaController = loader.getController();
        confirmarPolizaController.setAltaPolizaController(this);
        // Crear la escena y el escenario (Stage)
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("DATOS DE LA PÓLIZA");
        Image imagen = new Image("com/example/aseguradora/iconoMedium.png");
        stage.getIcons().add(imagen);
        stage.setScene(scene);

        confirmarPolizaController.setPoliza(confirmarPolizaDTO);
        stage.showAndWait();


    }

    public void revisarPatente(KeyEvent keyEvent) {
    }

    public void setClienteDTO(ClienteDTO clienteSeleccionado) {
        busquedaExitosa = true;
        clienteDTO = clienteSeleccionado;
    }
}













