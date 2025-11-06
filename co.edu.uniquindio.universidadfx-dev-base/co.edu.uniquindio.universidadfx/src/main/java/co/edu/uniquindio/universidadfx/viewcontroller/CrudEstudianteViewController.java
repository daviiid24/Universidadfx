package co.edu.uniquindio.universidadfx.viewcontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.universidadfx.controller.EstudianteController;
import co.edu.uniquindio.universidadfx.model.Estudiante;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

public class CrudEstudianteViewController {

    EstudianteController estudianteController;
    ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();
    Estudiante estudianteSeleccionado;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<Estudiante> tableEstudiante;

    @FXML
    private TableColumn<Estudiante, String> tcAopellido;

    @FXML
    private TableColumn<Estudiante, String> tcEdad;

    @FXML
    private TableColumn<Estudiante, String> tcIdentificacion;

    @FXML
    private TableColumn<Estudiante, String> tcNombre;

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

    }

    @FXML
    void onActionAgregar(ActionEvent event) {
        crearEstudiante();
    }

    @FXML
    void onActionNuevo(ActionEvent event) {

    }

    @FXML
    void initialize() {
        estudianteController = new EstudianteController();
        initView();
    }


    private void crearEstudiante() {
        //1. Captura los datos del formulario
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String identificacion = txtIdentificacion.getText();
        String edad = txtEdad.getText();

        //2. Validar datos
        boolean datosValidos = validarCampos(nombre,apellido,identificacion,edad);

        //3. Realizar la solictud de crear el estudiante
        if (datosValidos == true){
            Estudiante estudiante = estudianteController.crearEstudiante(nombre,apellido,identificacion,edad);
            if(estudiante != null){
                mostrarMensaje("Notificación", "Creación estudiante", "Estudiante creado",Alert.AlertType.CONFIRMATION);
                listaEstudiantes.add(estudiante);
            }else{
                mostrarMensaje("Notificación", "Creación estudiante", "Estudiante no creado",Alert.AlertType.WARNING);
            }
        }else{
            mostrarMensaje("Notificación", "Creación estudiante", "Campos vacios",Alert.AlertType.INFORMATION);
        }


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
        obtenerEstudiantes();
        tableEstudiante.getItems().clear();
        tableEstudiante.setItems(listaEstudiantes);
        listenerSelection();
    }

    private void obtenerEstudiantes() {
        listaEstudiantes.addAll(estudianteController.obtenerEstudiantes());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcAopellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
    }

    private void listenerSelection() {
        tableEstudiante.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            estudianteSeleccionado = newSelection;
            mostrarInformacion(estudianteSeleccionado);
        });
    }

    private void mostrarInformacion(Estudiante estudianteSeleccionado) {
        if(estudianteSeleccionado != null){
            txtNombre.setText(estudianteSeleccionado.getNombre());
            txtApellido.setText(estudianteSeleccionado.getApellido());
            txtIdentificacion.setText(estudianteSeleccionado.getIdentificacion());
            txtEdad.setText(String.valueOf(estudianteSeleccionado.getEdad()));
        }
    }


    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

}
