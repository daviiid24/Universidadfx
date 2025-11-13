package co.edu.uniquindio.universidadfx.viewcontroller;

import co.edu.uniquindio.universidadfx.controller.MetodosAsociacionController;
import co.edu.uniquindio.universidadfx.viewcontroller.CrudCursoViewController;
import co.edu.uniquindio.universidadfx.viewcontroller.CrudDocenteViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MetodosAsociacionViewController {

    MetodosAsociacionController metodosAsociacionController;

    @FXML
    private Button btnAsociarCursoDocente;

    @FXML
    private Button btnAsociarEstudianteCurso;

    @FXML
    private Button btnDesasociarCursoDocente;

    @FXML
    private Button btnDesasociarEstudianteCurso;

    @FXML
    private TextField txtIdCursoAsociarDocente;

    @FXML
    private TextField txtIdCursoAsociarEstudiante;

    @FXML
    private TextField txtIdCursoDesasociarDocente;

    @FXML
    private TextField txtIdCursoDesasociarEstudiante;

    @FXML
    private TextField txtIdDocenteAsociar;

    @FXML
    private TextField txtIdDocenteDesasociar;

    @FXML
    private TextField txtIdEstudianteAsociar;

    @FXML
    private TextField txtIdEstudianteDesasociar;

    @FXML
    void onActionAsociarDocente(ActionEvent event) {
        asociarDocenteCurso();
    }

    @FXML
    void onActionAsociarEstudiante(ActionEvent event) {
        //asociarEstudianteCurso();
    }

    @FXML
    void onActionDesasociarDocente(ActionEvent event) {
        //desasociarDocenteCurso();
    }

    @FXML
    void onActionDesasociarEstudiante(ActionEvent event) {
        //desasociarEstudianteCurso();
    }
    @FXML
    void initialize() {
        metodosAsociacionController = new MetodosAsociacionController();
    }

    private void asociarDocenteCurso() {
        String idDocente = txtIdDocenteAsociar.getText();
        String idCurso = txtIdCursoAsociarDocente.getText();

        if (idDocente.isEmpty() || idCurso.isEmpty()) {
            mostrarAlerta("Campos incompletos", "Debe ingresar ID docente e ID curso.");
            return;
        }

        boolean valido = metodosAsociacionController.asociarDocenteCurso(idDocente, idCurso);

        if (valido) {
            mostrarAlerta("Éxito", "Curso asociado al docente correctamente.");

            try {
                CrudCursoViewController crudCurso = ControllerCommunicator.getCrudCursoViewController();
                CrudDocenteViewController crudDocente = ControllerCommunicator.getCrudDocenteViewController();

                if (crudCurso != null) crudCurso.refrescarTablaCursos();
                if (crudDocente != null) crudDocente.refrescarTablaDocentes();

            } catch (Exception e) {
                System.out.println("No se pudo refrescar la tabla: " + e.getMessage());
            }

            limpiarCamposAsociarDocente();
        } else {
            mostrarAlerta("Error", "No se encontró docente o curso, o la asociación falló.");
        }
    }


    private void mostrarAlerta(String titulo, String mensaje) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }

    private void limpiarCamposAsociarDocente() {
        txtIdDocenteAsociar.clear();
        txtIdCursoAsociarDocente.clear();
    }

}
