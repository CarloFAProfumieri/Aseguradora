package com.example.aseguradora;

import com.example.aseguradora.DTOs.ClienteDTO;
import com.example.aseguradora.DTOs.TipoDocumentoDTO;
import com.example.aseguradora.gestores.GestorClientes;
import com.example.aseguradora.gestores.GestorPolizas;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class BuscarClienteController implements Initializable {
    public static int CANTIDAD_DE_RESULTADOS_POR_PAGINA = 12;
    @FXML TextField nroClienteTextField, nroDocumentoTextField, apellidoTextField, nombreTextField;
    @FXML ComboBox<TipoDocumentoDTO> tipoDocumentoDTOComboBox;
    @FXML ComboBox<Integer> numeroDePaginasComboBox;
    @FXML private TableView<ClienteDTO> clientesTabla;
    @FXML private TableColumn<ClienteDTO, Integer> nroClienteColumn;
    @FXML private TableColumn<ClienteDTO, String> apellidoColumn;
    @FXML private TableColumn<ClienteDTO, String> nombreColumn;
    @FXML private TableColumn<ClienteDTO, String> tipoDocumentoColumn;
    @FXML private TableColumn<ClienteDTO, Integer> nroDocumentoColumn;
    @FXML private Button seleccionarButton;
    AltaPolizaController altaPolizaController;
    List<TipoDocumentoDTO> tiposDeDocumentoLista;
    ObservableList<ClienteDTO> listaClientes = observableArrayList();
    GestorClientes gestorClientes = GestorClientes.obtenerInstancia();
    List<ClienteDTO> clientesLista = new ArrayList<>();
    GestorPolizas gestorPolizas = GestorPolizas.getInstancia();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarTipoDocumentoComboBox();
        inicializarCantidadDePaginasComboBox();
        nroClienteColumn.setStyle("-fx-alignment: CENTER;");
        tipoDocumentoColumn.setStyle("-fx-alignment: CENTER;");
        nroDocumentoColumn.setStyle("-fx-alignment: CENTER;");
        nroClienteColumn.setCellValueFactory(new PropertyValueFactory<ClienteDTO, Integer>("numeroCliente"));
        apellidoColumn.setCellValueFactory(new PropertyValueFactory<ClienteDTO, String>("apellido"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<ClienteDTO, String>("nombre"));
        tipoDocumentoColumn.setCellValueFactory(new PropertyValueFactory<ClienteDTO, String>("tipoDocumento"));
        nroDocumentoColumn.setCellValueFactory(new PropertyValueFactory<ClienteDTO, Integer>("numeroDocumento"));
        clientesTabla.setItems(listaClientes);
        Label customPlaceholder = new Label("Complete los datos necesarios y haga clic en 'Buscar' para visualizar los clientes");
        clientesTabla.setPlaceholder(customPlaceholder);
    }

    private void inicializarCantidadDePaginasComboBox() {
        for (int i = 1; i <= 99; i++) {
            numeroDePaginasComboBox.getItems().add(i);
        }
        numeroDePaginasComboBox.setValue(1);
    }
    private void inicializarTipoDocumentoComboBox() {
        tiposDeDocumentoLista = gestorPolizas.getTiposDocumento();
        tipoDocumentoDTOComboBox.getItems().setAll(tiposDeDocumentoLista);
    }
    public void buscarClienteAction(ActionEvent event){
        int cantidadDeResultados = numeroDePaginasComboBox.getValue() * CANTIDAD_DE_RESULTADOS_POR_PAGINA;
        clientesLista = gestorClientes.getClientes(getClienteDTO(), cantidadDeResultados);
        if (clientesLista.isEmpty()){
            Label customPlaceholder = new Label("No se encontró ningún cliente que coincida con los criterios de búsqueda");
            clientesTabla.setPlaceholder(customPlaceholder);
            return;
        }
        clientesTabla.getItems().clear();
        listaClientes.addAll(clientesLista);
        seleccionarButton.setDisable(true);
    }
    public void clienteSelected(MouseEvent event){
        if(listaClientes.isEmpty()){
            return;
        }
        seleccionarButton.setDisable(false);
    }
    public ClienteDTO getClienteDTO(){
        ClienteDTO datosCargadosClienteDTO = new ClienteDTO();
        if (!nroClienteTextField.getText().isEmpty()){
            datosCargadosClienteDTO.setNumeroCliente(Integer.parseInt(nroClienteTextField.getText()));
        }
        if (tipoDocumentoDTOComboBox.getSelectionModel().getSelectedIndex() != -1) {
            datosCargadosClienteDTO.setTipoDocumentoId(tipoDocumentoDTOComboBox.getValue().getIdTipoDocumento());
        }
        if (!nroDocumentoTextField.getText().isEmpty()){
            datosCargadosClienteDTO.setNumeroDocumento(Integer.parseInt(nroDocumentoTextField.getText()));
        }
        if (!apellidoTextField.getText().isEmpty()){
            datosCargadosClienteDTO.setApellido(apellidoTextField.getText());
        }
        if (!nombreTextField.getText().isEmpty()){
            datosCargadosClienteDTO.setNombre(nombreTextField.getText());
        }
        return datosCargadosClienteDTO;
    }
    @FXML
    private void verificarNroDocumento() {
        try {
            int posicionCursor = nroDocumentoTextField.getCaretPosition();
            String textoActual = nroDocumentoTextField.getText();
            StringBuilder nuevoTexto = new StringBuilder();

            for (char caracter : textoActual.toCharArray()) {
                if (Character.isDigit(caracter)) {
                    nuevoTexto.append(caracter);
                }
            }

            nroDocumentoTextField.setText(nuevoTexto.toString());
            nroDocumentoTextField.positionCaret(posicionCursor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Texto ingresado: " + nroDocumentoTextField.getText());
    }


    @FXML
    private void verificarNroCliente() {
        try {
            int posicionCursor = nroClienteTextField.getCaretPosition();
            String textoActual = nroClienteTextField.getText();
            StringBuilder nuevoTexto = new StringBuilder();

            // Iterar sobre cada carácter del texto
            for (char caracter : textoActual.toCharArray()) {
                // Verificar si el carácter es un número
                if (Character.isDigit(caracter)) {
                    nuevoTexto.append(caracter);
                }
            }

            // Establecer el nuevo texto en el campo de texto
            nroClienteTextField.setText(nuevoTexto.toString());
            nroClienteTextField.positionCaret(posicionCursor);
        } catch (Exception e) {
            // Manejar excepciones, si es necesario
            e.printStackTrace();
        }

        // Puedes seguir con la lógica adicional aquí
        System.out.println("Texto ingresado: " + nroClienteTextField.getText());
    }

    public void cancelarAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void setAltaPolizaController(AltaPolizaController altaPolizaController) {
        this.altaPolizaController = altaPolizaController;
    }
    public void seleccionarClienteAction(ActionEvent event) {
        // Obtén el cliente seleccionado de la tabla
        ClienteDTO clienteSeleccionado = clientesTabla.getSelectionModel().getSelectedItem();

        if (clienteSeleccionado != null) {
            // Puedes imprimir algunos detalles del cliente seleccionado
            System.out.println("Cliente seleccionado: " + clienteSeleccionado.getNombre() + " " + clienteSeleccionado.getApellido());

            // Luego, pasa el cliente seleccionado al controlador de AltaPoliza
            altaPolizaController.setClienteDTO(clienteSeleccionado);

            // Cierra la ventana actual
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.close();
        } else {
            mostrarVentanaError("Por favor seleccione un cliente de la lista para continuar");
        }
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

}
