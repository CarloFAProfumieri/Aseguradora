package com.example.aseguradora;

import com.example.aseguradora.DTOs.ClienteDTO;
import com.example.aseguradora.DTOs.HijoDTO;
import com.example.aseguradora.DTOs.TipoDocumentoDTO;
import com.example.aseguradora.gestores.GestorClientes;
import com.example.aseguradora.gestores.GestorPolizas;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class BuscarClienteController implements Initializable {
    @FXML TextField nroClienteTextField, nroDocumentoTextField, apellidoTextField, nombreTextField;
    @FXML ComboBox<TipoDocumentoDTO> tipoDocumentoDTOComboBox;
    @FXML ComboBox<Integer> numeroDePaginasComboBox;
    @FXML private TableView<ClienteDTO> clientesTabla;
    @FXML private TableColumn<ClienteDTO, Integer> nroClienteColumn;
    @FXML private TableColumn<ClienteDTO, String> apellidoColumn;
    @FXML private TableColumn<ClienteDTO, String> nombreColumn;
    @FXML private TableColumn<ClienteDTO, String> tipoDocumentoColumn;
    @FXML private TableColumn<ClienteDTO, Integer> nroDocumentoColumn;
    List<TipoDocumentoDTO> tiposDeDocumentoLista;
    ObservableList<ClienteDTO> listaClientes = observableArrayList();
    GestorClientes gestorClientes = GestorClientes.obtenerInstancia();
    List<ClienteDTO> clientesLista = new ArrayList<>();
    GestorPolizas gestorPolizas = GestorPolizas.getInstancia();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inicializarTipoDocumentoComboBox();
        nroClienteColumn.setStyle("-fx-alignment: CENTER;");
        tipoDocumentoColumn.setStyle("-fx-alignment: CENTER;");
        nroDocumentoColumn.setStyle("-fx-alignment: CENTER;");
        nroClienteColumn.setCellValueFactory(new PropertyValueFactory<ClienteDTO, Integer>("numeroCliente"));
        apellidoColumn.setCellValueFactory(new PropertyValueFactory<ClienteDTO, String>("apellido"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<ClienteDTO, String>("nombre"));
        tipoDocumentoColumn.setCellValueFactory(new PropertyValueFactory<ClienteDTO, String>("tipoDocumento"));
        nroDocumentoColumn.setCellValueFactory(new PropertyValueFactory<ClienteDTO, Integer>("numeroDocumento"));
        clientesTabla.setItems(listaClientes);
    }
    private void inicializarTipoDocumentoComboBox() {
        tiposDeDocumentoLista = gestorPolizas.getTiposDocumento();
        tipoDocumentoDTOComboBox.getItems().setAll(tiposDeDocumentoLista);
    }

    public void buscarClienteAction(ActionEvent event) {
        clientesLista = gestorClientes.getAllClientes();
        if (!nroClienteTextField.getText().isEmpty()){
            filtrarPorNumeroCliente(nroClienteTextField.getText());
        }
        if (tipoDocumentoDTOComboBox.getSelectionModel().getSelectedIndex() != -1) {
            filtrarPorTipoDocumento(tipoDocumentoDTOComboBox.getSelectionModel());
        }
        if (!nroDocumentoTextField.getText().isEmpty()){
            filtrarPorNroDocumento(nroDocumentoTextField.getText());
        }
        if (!apellidoTextField.getText().isEmpty()){
            filtrarPorApellido(apellidoTextField.getText());
        }
        if (!nombreTextField.getText().isEmpty()){
            filtrarPorNombre(nombreTextField.getText());
        }
        clientesTabla.getItems().clear();
        listaClientes.addAll(clientesLista);

        //clientesTabla.getItems().addAll(clienteDTOList);

        // Actualizar la tabla para reflejar los cambios
        //clientesTabla.refresh();
    }

    private void filtrarPorNumeroCliente(String text) {
        // Crear una nueva lista para almacenar los clientes filtrados
        List<ClienteDTO> clientesFiltrados = new ArrayList<>();
        // Iterar sobre la lista original y agregar los clientes que coinciden al nuevo
        for (ClienteDTO cliente : clientesLista) {
            if (cliente.getNumeroClienteString().contains(text)) {
                clientesFiltrados.add(cliente);
            }
        }

        // Actualizar la lista original con los clientes filtrados
        clientesLista.clear();
        clientesLista.addAll(clientesFiltrados);

        // Actualizar la tabla para reflejar los cambios
        clientesTabla.refresh();
    }

    private void filtrarPorTipoDocumento(SingleSelectionModel<TipoDocumentoDTO> selectionModel) {
    }

    private void filtrarPorNroDocumento(String text) {
        // Crear una nueva lista para almacenar los clientes filtrados
        List<ClienteDTO> clientesFiltrados = new ArrayList<>();
        // Iterar sobre la lista original y agregar los clientes que coinciden al nuevo
        for (ClienteDTO cliente : clientesLista) {
            if (cliente.getNumeroDocumentoString().contains(text)) {
                clientesFiltrados.add(cliente);
            }
        }

        // Actualizar la lista original con los clientes filtrados
        clientesLista.clear();
        clientesLista.addAll(clientesFiltrados);

        // Actualizar la tabla para reflejar los cambios
        clientesTabla.refresh();
    }

    private void filtrarPorApellido(String text) {
        // Crear una nueva lista para almacenar los clientes filtrados
        List<ClienteDTO> clientesFiltrados = new ArrayList<>();
        // Iterar sobre la lista original y agregar los clientes que coinciden al nuevo
        for (ClienteDTO cliente : clientesLista) {
            if (cliente.getApellido().contains(text)) {
                clientesFiltrados.add(cliente);
            }
        }

        // Actualizar la lista original con los clientes filtrados
        clientesLista.clear();
        clientesLista.addAll(clientesFiltrados);

        // Actualizar la tabla para reflejar los cambios
        clientesTabla.refresh();
    }

    private void filtrarPorNombre(String text) {
        // Crear una nueva lista para almacenar los clientes filtrados
        List<ClienteDTO> clientesFiltrados = new ArrayList<>();
        // Iterar sobre la lista original y agregar los clientes que coinciden al nuevo
        for (ClienteDTO cliente : clientesLista) {
            if (cliente.getNombre().contains(text)) {
                clientesFiltrados.add(cliente);
            }
        }

        // Actualizar la lista original con los clientes filtrados
        clientesLista.clear();
        clientesLista.addAll(clientesFiltrados);

        // Actualizar la tabla para reflejar los cambios
        clientesTabla.refresh();
    }

    public void cancelarAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
