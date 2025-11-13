package co.edu.uniquindio.universidadfx.viewcontroller;

import co.edu.uniquindio.universidadfx.controller.CursoController;
import co.edu.uniquindio.universidadfx.controller.DocenteController;
import co.edu.uniquindio.universidadfx.model.Curso;
import co.edu.uniquindio.universidadfx.model.Docente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CrudCursoViewController {

    CursoController cursoController;
    ObservableList<Curso> listaCursos = FXCollections.observableArrayList();
    Curso cursoSeleccionado;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableView<Curso> tableCurso;

    @FXML
    private TableColumn<Curso, String> tcDocente;

    @FXML
    private TableColumn<Curso, String> tcEstudiantes;

    @FXML
    private TableColumn<Curso, String> tcCreditos;

    @FXML
    private TableColumn<Curso, String> tcGrupo;

    @FXML
    private TableColumn<Curso, String> tcIdentificacion;

    @FXML
    private TableColumn<Curso, String> tcJornada;

    @FXML
    private TableColumn<Curso, String> tcNombre;

    @FXML
    private TableColumn<Curso, String> tcSemestre;

    @FXML
    private TextField txtCreditos;

    @FXML
    private TextField txtGrupo;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtJornada;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtSemestre;

    @FXML
    void onActionActualizar(ActionEvent event) {
        actualizarCurso();
    }

    @FXML
    void onActionAgregar(ActionEvent event) {
        agregarCurso();
    }

    @FXML
    void onActionEliminar(ActionEvent event) {
        eliminarCurso();
    }

    @FXML
    void initialize() {
        cursoController = new CursoController();
        initView();

        ControllerCommunicator.setCrudCursoViewController(this);
    }

    private void agregarCurso() {
        String nombre = txtNombre.getText();
        String semestre = txtSemestre.getText();
        String grupo = txtGrupo.getText();
        String creditos = txtCreditos.getText();
        String jornada = txtJornada.getText();
        String identificacion = txtIdentificacion.getText();
        boolean datosValidos = validarCampos(nombre, semestre, grupo, creditos, jornada, identificacion);

        if (datosValidos) {
            Curso curso = cursoController.crearCurso(nombre, semestre, grupo, creditos, jornada, identificacion);
            if (curso != null) {
                mostrarMensaje("Notificación", "Creación curso", "Curso creado", Alert.AlertType.CONFIRMATION);
                listaCursos.add(curso);
            } else {
                mostrarMensaje("Notificación", "Creación curso", "Curso no creado", Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje("Notificación", "Creación curso", "Campos vacíos", Alert.AlertType.INFORMATION);
        }
    }

    private void actualizarCurso() {
        String nombre = txtNombre.getText();
        String semestre = txtSemestre.getText();
        String grupo = txtGrupo.getText();
        String creditos = txtCreditos.getText();
        String jornada = txtJornada.getText();
        String identificacion = txtIdentificacion.getText();
        boolean datosValidos = validarCampos(nombre, semestre, grupo, creditos, jornada, identificacion);

        if (datosValidos) {
            Curso curso = cursoController.actualizarCurso(nombre, semestre, grupo, creditos, jornada, identificacion);
            if (curso != null) {
                mostrarMensaje("Notificación", "Actualización curso", "Curso actualizado", Alert.AlertType.CONFIRMATION);
                tableCurso.refresh();
            } else {
                mostrarMensaje("Notificación", "Actualización curso", "Curso no actualizado", Alert.AlertType.WARNING);
            }
        } else {
            mostrarMensaje("Notificación", "Actualización curso", "Campos vacíos", Alert.AlertType.INFORMATION);
        }
    }

    private void eliminarCurso() {
        String identificacion = txtIdentificacion.getText();
        boolean datosValidos = validarCamposEliminar(identificacion);

        if (!datosValidos) {
            mostrarMensaje("Notificación", "Eliminación curso", "Campos vacíos", Alert.AlertType.INFORMATION);
            return;
        }

        Curso cursoEliminado = cursoController.eliminarCurso(identificacion);
        if (cursoEliminado != null) {
            listaCursos.removeIf(curso -> curso.getIdentificacion().equalsIgnoreCase(identificacion));
            tableCurso.refresh();

            mostrarMensaje("Notificación", "Eliminación curso", "Curso eliminado", Alert.AlertType.CONFIRMATION);
            limpiarCampos();
        } else {
            mostrarMensaje("Notificación", "Eliminación curso", "Curso no encontrado", Alert.AlertType.WARNING);
        }
    }

    private boolean validarCampos(String nombre, String semestre, String grupo, String creditos, String jornada, String identificacion) {
        if(nombre.isEmpty() || semestre.isEmpty() || grupo.isEmpty() || creditos.isEmpty() || jornada.isEmpty() || identificacion.isEmpty()){
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
        obtenerCursos();
        tableCurso.getItems().clear();
        tableCurso.setItems(listaCursos);
        listenerSelection();
    }

    private void obtenerCursos() {
        listaCursos.addAll(cursoController.obtenerCursos());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcSemestre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSemestre()));
        tcGrupo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGrupo()));
        tcCreditos.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCreditos())));
        tcJornada.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJornada()));
        tcIdentificacion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        tcDocente.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNombreDocenteAsociado())));
        tcEstudiantes.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstudiantesAsociadosTexto()));
    }

    private void listenerSelection() {
        tableCurso.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            cursoSeleccionado = newSelection;
            mostrarInformacion(cursoSeleccionado);
        });
    }

    private void mostrarInformacion(Curso cursoSeleccionado) {
        if (cursoSeleccionado != null) {
            txtNombre.setText(cursoSeleccionado.getNombre());
            txtSemestre.setText(cursoSeleccionado.getSemestre());
            txtGrupo.setText(cursoSeleccionado.getGrupo());
            txtCreditos.setText(String.valueOf(cursoSeleccionado.getCreditos()));
            txtJornada.setText(String.valueOf(cursoSeleccionado.getJornada()));
            txtCreditos.setText(String.valueOf(cursoSeleccionado.getCreditos()));
            txtIdentificacion.setText(cursoSeleccionado.getIdentificacion());
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
        txtSemestre.clear();
        txtGrupo.clear();
        txtCreditos.clear();
        txtJornada.clear();
        txtIdentificacion.clear();
        cursoSeleccionado = null;
        tableCurso.getSelectionModel().clearSelection();
    }
    public void refrescarTablaCursos() {
        tableCurso.refresh();
    }
}
