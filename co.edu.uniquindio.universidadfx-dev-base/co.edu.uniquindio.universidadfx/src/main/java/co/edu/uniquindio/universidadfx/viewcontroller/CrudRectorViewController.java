package co.edu.uniquindio.universidadfx.viewcontroller;

import co.edu.uniquindio.universidadfx.controller.RectorController;
import co.edu.uniquindio.universidadfx.model.Rector;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CrudRectorViewController {

    RectorController rectorController;
    ObservableList<Rector> rectorUnico = FXCollections.observableArrayList();
    Rector rectorSeleccionado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableView<Rector> tableRector;

    @FXML
    private TableColumn<Rector, String> tcApellido;

    @FXML
    private TableColumn<Rector, String> tcEdad;

    @FXML
    private TableColumn<Rector, String> tcIdentificacion;

    @FXML
    private TableColumn<Rector, String> tcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    void onActionActualizar(ActionEvent event) {
        actualizarRector();
    }

    @FXML
    void onActionAgregar(ActionEvent event) {
        agregarRector();
    }

    @FXML
    void onActionEliminar(ActionEvent event) {
        eliminarRector();
    }

    @FXML
    void initialize() {
        rectorController = new RectorController();
        initView();
    }
    private void agregarRector() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String identificacion = txtIdentificacion.getText();
        String edad = txtEdad.getText();

        boolean datosValidos = validarCampos(nombre,apellido,identificacion,edad);

        if (datosValidos == true){
            Rector rector = rectorController.crearRector(nombre,apellido,identificacion,edad);
            if(rector != null){
                mostrarMensaje("Notificación", "Creación rector", "Rector creado",Alert.AlertType.CONFIRMATION);
                rectorUnico.add(rector);
            }else{
                mostrarMensaje("Notificación", "Creación rector", "Rector no creado",Alert.AlertType.WARNING);
            }
        }else{
            mostrarMensaje("Notificación", "Creación rector", "Campos vacios",Alert.AlertType.INFORMATION);
        }
    }
    private void actualizarRector() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String identificacion = txtIdentificacion.getText();
        String edad = txtEdad.getText();

        boolean datosValidos = validarCampos(nombre,apellido,identificacion,edad);

        if (datosValidos == true){
            Rector rector = rectorController.actualizarRector(nombre,apellido,identificacion,edad);
            if(rector != null){
                mostrarMensaje("Notificación", "Actualización rector", "Rector actualizado",Alert.AlertType.CONFIRMATION);
                tableRector.refresh();
            }else{
                mostrarMensaje("Notificación", "Actualización rector", "Rector no actualizado",Alert.AlertType.WARNING);
            }
        }else{
            mostrarMensaje("Notificación", "Actualización rector", "Campos vacios",Alert.AlertType.INFORMATION);
        }
    }

    private void eliminarRector(){
        String identificacion=txtIdentificacion.getText();
        boolean datosValidos = validarCamposEliminar(identificacion);
        if (!datosValidos) {
            mostrarMensaje("Notificación", "Eliminación rector", "Campos vacíos", Alert.AlertType.INFORMATION);
            return;
        }
        Rector rectorEliminado = rectorController.eliminarRector();
        if (rectorEliminado != null) {
            rectorUnico.removeIf(rector -> rector.getIdentificacion().equalsIgnoreCase(identificacion));
            tableRector.refresh();

            mostrarMensaje("Notificación", "Eliminación rector", "Rector eliminado", Alert.AlertType.CONFIRMATION);
            limpiarCampos();
        } else {
            mostrarMensaje("Notificación", "Eliminación rector", "Rector no encontrado", Alert.AlertType.WARNING);
        }
    }
    private boolean validarCamposEliminar(String identificacion) {
        return !identificacion.isEmpty();
    }


    private boolean validarCampos(String nombre,
                                  String apellido,
                                  String identificacion,
                                  String edad) {
        if(nombre.isEmpty() || apellido.isEmpty() || identificacion.isEmpty() || edad.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    private void initView() {
        initDataBinding();
        obtenerRector();
        tableRector.getItems().clear();
        tableRector.setItems(rectorUnico);
        listenerSelection();
    }
    private void obtenerRector() {
        rectorUnico.addAll(rectorController.obtenerRector());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
    }
    private void listenerSelection() {
        tableRector.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            rectorSeleccionado = newSelection;
            mostrarInformacion(rectorSeleccionado);
        });
    }
    private void mostrarInformacion(Rector rectorSeleccionado) {
        if(rectorSeleccionado != null){
            txtNombre.setText(rectorSeleccionado.getNombre());
            txtApellido.setText(rectorSeleccionado.getApellido());
            txtIdentificacion.setText(rectorSeleccionado.getIdentificacion());
            txtEdad.setText(String.valueOf(rectorSeleccionado.getEdad()));
        }
    }


    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtIdentificacion.clear();
        txtEdad.clear();
        rectorSeleccionado = null;
        tableRector.getSelectionModel().clearSelection();
    }


}
