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
    private Button btnEliminar;

    @FXML
    private TableView<Estudiante> tableEstudiante;

    @FXML
    private TableColumn<Estudiante, String> tcApellido;

    @FXML
    private TableColumn<Estudiante, String> tcEdad;

    @FXML
    private TableColumn<Estudiante, String> tcIdentificacion;

    @FXML
    private TableColumn<Estudiante, String> tcNombre;

    @FXML
    private TableColumn<Estudiante, String> tcNota1;

    @FXML
    private TableColumn<Estudiante, String> tcNota2;

    @FXML
    private TableColumn<Estudiante, String> tcNota3;


    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;


    @FXML
    private TextField txtNota1;

    @FXML
    private TextField txtNota2;

    @FXML
    private TextField txtNota3;



    @FXML
    void onActionActualizar(ActionEvent event) {
        actualizarEstudiante();
    }

    @FXML
    void onActionAgregar(ActionEvent event) {
        crearEstudiante();
    }


    @FXML
    void onActionEliminar(ActionEvent event) {
        eliminarEstudiante();
    }

    @FXML
    void initialize() {
        estudianteController = new EstudianteController();
        initView();

        ControllerCommunicator.setCrudEstudianteViewController(this);
    }


    private void crearEstudiante() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String identificacion = txtIdentificacion.getText();
        String edad = txtEdad.getText();
        String nota1 = txtNota1.getText();
        String nota2 = txtNota2.getText();
        String nota3 = txtNota3.getText();

        boolean datosValidos = validarCampos(nombre,apellido,identificacion,edad, nota1, nota2, nota3);

        if (datosValidos == true){
            Estudiante estudiante = estudianteController.crearEstudiante(nombre,apellido,identificacion,edad, nota1, nota2, nota3);
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

    private void actualizarEstudiante() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String identificacion = txtIdentificacion.getText();
        String edad = txtEdad.getText();
        String nota1 = txtNota1.getText();
        String nota2 = txtNota2.getText();
        String nota3 = txtNota3.getText();

        boolean datosValidos = validarCampos(nombre,apellido,identificacion,edad, nota1, nota2, nota3);

        if (datosValidos == true){
            Estudiante estudiante = estudianteController.actualizarEstudiante(nombre,apellido,identificacion,edad, nota1, nota2, nota3);
            if(estudiante != null){
                mostrarMensaje("Notificación", "Actualización estudiante", "Estudiante actualizado",Alert.AlertType.CONFIRMATION);
                tableEstudiante.refresh();
            }else{
                mostrarMensaje("Notificación", "Actualización estudiante", "Estudiante no actualizado",Alert.AlertType.WARNING);
            }
        }else{
            mostrarMensaje("Notificación", "Actualización estudiante", "Campos vacios",Alert.AlertType.INFORMATION);
        }


    }
    private void eliminarEstudiante(){
        String identificacion=txtIdentificacion.getText();
        boolean datosValidos = validarCamposEliminar(identificacion);
        if (!datosValidos) {
            mostrarMensaje("Notificación", "Eliminación estudiante", "Campos vacíos", Alert.AlertType.INFORMATION);
            return;
        }
        Estudiante estudianteEliminado = estudianteController.eliminarEstudiante(identificacion);
        if (estudianteEliminado != null) {
            listaEstudiantes.removeIf(estudiante -> estudiante.getIdentificacion().equalsIgnoreCase(identificacion));
            tableEstudiante.refresh();

            mostrarMensaje("Notificación", "Eliminación estudiante", "Estudiante eliminado", Alert.AlertType.CONFIRMATION);
            limpiarCampos();
        } else {
            mostrarMensaje("Notificación", "Eliminación estudiante", "Estudiante no encontrado", Alert.AlertType.WARNING);
        }
    }

    private boolean validarCamposEliminar(String identificacion) {
        return !identificacion.isEmpty();
    }


    private boolean validarCampos(String nombre,
                                  String apellido,
                                  String identificacion,
                                  String edad,
                                  String nota1,
                                  String nota2,
                                  String nota3) {
        if(nombre.isEmpty() || apellido.isEmpty() || identificacion.isEmpty() || edad.isEmpty() || nota1.isEmpty() || nota2.isEmpty() || nota3.isEmpty()){
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
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcNota1.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNota1())));
        tcNota2.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNota2())));
        tcNota3.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNota3())));
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
            txtNota1.setText(String.valueOf(estudianteSeleccionado.getNota1()));
            txtNota2.setText(String.valueOf(estudianteSeleccionado.getNota2()));
            txtNota3.setText(String.valueOf(estudianteSeleccionado.getNota3()));
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
    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtIdentificacion.clear();
        txtEdad.clear();
        txtNota1.clear();
        txtNota2.clear();
        txtNota3.clear();
        estudianteSeleccionado = null;
        tableEstudiante.getSelectionModel().clearSelection();
    }
    public void refrescarTablaEstudiantes() {
        tableEstudiante.refresh();
    }
}
