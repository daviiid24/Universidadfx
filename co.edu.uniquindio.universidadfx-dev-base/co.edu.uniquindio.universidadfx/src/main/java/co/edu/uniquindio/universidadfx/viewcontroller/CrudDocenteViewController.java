package co.edu.uniquindio.universidadfx.viewcontroller;

import co.edu.uniquindio.universidadfx.controller.DocenteController;
import co.edu.uniquindio.universidadfx.model.Docente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CrudDocenteViewController {
    DocenteController docenteController;
    ObservableList<Docente> listaDocentes = FXCollections.observableArrayList();
    Docente docenteSeleccionado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableView<Docente> tableDocente;

    @FXML
    private TableColumn<Docente, String> tcApellido;

    @FXML
    private TableColumn<Docente, String> tcCorreo;

    @FXML
    private TableColumn<Docente, String> tcEdad;

    @FXML
    private TableColumn<Docente, String> tcIdentificacion;

    @FXML
    private TableColumn<Docente, String> tcNombre;

    @FXML
    private TableColumn<Docente, String> tcCursos;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtCursos;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    void onActionActualizar(ActionEvent event) {
        actualizarDocente();
    }

    @FXML
    void onActionAgregar(ActionEvent event) {
        crearDocente();
    }

    @FXML
    void onActionEliminar(ActionEvent event) {
        eliminarDocente();
    }

    @FXML
    void initialize() {
        docenteController = new DocenteController();
        initView();

        ControllerCommunicator.setCrudDocenteViewController(this);
    }

    private void crearDocente() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String identificacion = txtIdentificacion.getText();
        String edad = txtEdad.getText();
        String correo = txtCorreo.getText();
        boolean datosValidos = validarCampos(nombre, apellido, identificacion, edad, correo);

        if (datosValidos) {
            Docente docente = docenteController.crearDocente(nombre, apellido, identificacion, edad, correo);
            if (docente != null) {
                mostrarMensaje("Notificación", "Creación docente", "Docente creado", Alert.AlertType.CONFIRMATION);
                listaDocentes.add(docente);
            } else {
                mostrarMensaje("Notificación", "Creación docente", "Docente no creado", Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje("Notificación", "Creación docente", "Campos vacíos", Alert.AlertType.INFORMATION);
        }
    }

    private void actualizarDocente() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String identificacion = txtIdentificacion.getText();
        String edad = txtEdad.getText();
        String correo = txtCorreo.getText();

        boolean datosValidos = validarCampos(nombre, apellido, identificacion, edad, correo);

        if (datosValidos) {
            Docente docente = docenteController.actualizarDocente(nombre, apellido, identificacion, edad, correo);
            if (docente != null) {
                mostrarMensaje("Notificación", "Actualización docente", "Docente actualizado", Alert.AlertType.CONFIRMATION);
                tableDocente.refresh();
            } else {
                mostrarMensaje("Notificación", "Actualización docente", "Docente no actualizado", Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje("Notificación", "Actualización docente", "Campos vacíos", Alert.AlertType.INFORMATION);
        }
    }

    private void eliminarDocente() {
        String identificacion = txtIdentificacion.getText();
        boolean datosValidos = validarCamposEliminar(identificacion);

        if (!datosValidos) {
            mostrarMensaje("Notificación", "Eliminación docente", "Campos vacíos", Alert.AlertType.INFORMATION);
            return;
        }

        Docente docenteEliminado = docenteController.eliminarDocente(identificacion);
        if (docenteEliminado != null) {
            listaDocentes.removeIf(docente -> docente.getIdentificacion().equalsIgnoreCase(identificacion));
            tableDocente.refresh();

            mostrarMensaje("Notificación", "Eliminación docente", "Docente eliminado", Alert.AlertType.CONFIRMATION);
            limpiarCampos();
        } else {
            mostrarMensaje("Notificación", "Eliminación docente", "Docente no encontrado", Alert.AlertType.WARNING);
        }
    }

    private boolean validarCampos(String nombre,
                                  String apellido,
                                  String identificacion,
                                  String edad,
                                  String correo) {
        if(nombre.isEmpty() || apellido.isEmpty() || identificacion.isEmpty() || edad.isEmpty() || correo.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    private boolean validarCamposEliminar(String identificacion) {
        return !identificacion.isEmpty();
    }


    private void initView() {
        initDataBinding();
        obtenerDocentes();
        tableDocente.getItems().clear();
        tableDocente.setItems(listaDocentes);
        listenerSelection();
    }

    private void obtenerDocentes() {
        listaDocentes.addAll(docenteController.obtenerDocentes());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tcCursos.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCursosAsociadosTexto())));
    }

    private void listenerSelection() {
        tableDocente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            docenteSeleccionado = newSelection;
            mostrarInformacion(docenteSeleccionado);
        });
    }

    private void mostrarInformacion(Docente docenteSeleccionado) {
        if (docenteSeleccionado != null) {
            txtNombre.setText(docenteSeleccionado.getNombre());
            txtApellido.setText(docenteSeleccionado.getApellido());
            txtIdentificacion.setText(docenteSeleccionado.getIdentificacion());
            txtEdad.setText(String.valueOf(docenteSeleccionado.getEdad()));
            txtCorreo.setText(String.valueOf(docenteSeleccionado.getCorreo()));
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtIdentificacion.clear();
        txtEdad.clear();
        txtCorreo.clear();
        tableDocente.getSelectionModel().clearSelection();
    }
    public void refrescarTablaDocentes() {
        listaDocentes.clear();
        listaDocentes.addAll(docenteController.obtenerDocentes());
        tableDocente.refresh();
    }


}
