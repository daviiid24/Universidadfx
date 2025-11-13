package co.edu.uniquindio.universidadfx.viewcontroller;

import co.edu.uniquindio.universidadfx.controller.MetodosAsociacionController;
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
        asociarEstudianteCurso();
    }

    @FXML
    void onActionDesasociarDocente(ActionEvent event) {
        desasociarDocenteCurso();
    }

    @FXML
    void onActionDesasociarEstudiante(ActionEvent event) {
        desasociarEstudianteCurso();
    }

    @FXML
    void initialize() {
        metodosAsociacionController = new MetodosAsociacionController();
    }

    private void asociarDocenteCurso() {
        String idDocente = txtIdDocenteAsociar.getText();
        String idCurso = txtIdCursoAsociarDocente.getText();

        if (idDocente.isEmpty() || idCurso.isEmpty()) {
            mostrarAlerta("Campos incompletos", "Debe ingresar el id del docente y el id del curso");
            return;
        }

        boolean valido = metodosAsociacionController.asociarDocenteCurso(idDocente, idCurso);

        if (valido) {
            mostrarAlerta("Éxito", "Docente asociado al curso correctamente");

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
            mostrarAlerta("Error", "No se encontró docente o curso, o la asociación falló");
        }
    }

    private void desasociarDocenteCurso() {
        String idDocente = txtIdDocenteDesasociar.getText();
        String idCurso = txtIdCursoDesasociarDocente.getText();

        if (idDocente.isEmpty() || idCurso.isEmpty()) {
            mostrarAlerta("Campos incompletos", "Debe ingresar el id del docente y el id del curso");
            return;
        }

        boolean valido = metodosAsociacionController.desasociarDocenteCurso(idDocente, idCurso);

        if (valido) {
            mostrarAlerta("Éxito", "Docente desasociado del curso correctamente");

            try {
                CrudCursoViewController crudCurso = ControllerCommunicator.getCrudCursoViewController();
                CrudDocenteViewController crudDocente = ControllerCommunicator.getCrudDocenteViewController();

                if (crudCurso != null) crudCurso.refrescarTablaCursos();
                if (crudDocente != null) crudDocente.refrescarTablaDocentes();

            } catch (Exception e) {
                System.out.println("No se pudo refrescar la tabla: " + e.getMessage());
            }

            limpiarCamposDesasociarDocente();
        } else {
            mostrarAlerta("Error", "No se encontró docente o curso, o la asociación falló");
        }
    }

    private void asociarEstudianteCurso() {
        String idEstudiante = txtIdEstudianteAsociar.getText();
        String idCurso = txtIdCursoAsociarEstudiante.getText();

        if (idEstudiante.isEmpty() || idCurso.isEmpty()) {
            mostrarAlerta("Campos incompletos", "Debe ingresar el id del estudiante y el id del curso");
            return;
        }

        boolean valido = metodosAsociacionController.asociarEstudianteACurso(idEstudiante, idCurso);

        if (valido) {
            mostrarAlerta("Éxito", "Estudiante asociado al curso correctamente.");

            try {
                CrudCursoViewController crudCurso = ControllerCommunicator.getCrudCursoViewController();
                CrudEstudianteViewController crudEstudiante = ControllerCommunicator.getCrudEstudianteViewController();

                if (crudCurso != null) crudCurso.refrescarTablaCursos();
                if (crudEstudiante != null) crudEstudiante.refrescarTablaEstudiantes();

            } catch (Exception e) {
                System.out.println("No se pudo refrescar la tabla: " + e.getMessage());
            }

            limpiarCamposAsociarEstudiante();
        } else {
            mostrarAlerta("Error", "No se encontró estudiante o curso, o la asociación falló");
        }
    }

    private void desasociarEstudianteCurso() {
        String idEstudiante = txtIdEstudianteDesasociar.getText();
        String idCurso = txtIdCursoDesasociarEstudiante.getText();

        if (idEstudiante.isEmpty() || idCurso.isEmpty()) {
            mostrarAlerta("Campos incompletos", "Debe ingresar el id del estudiante y el id del curso");
            return;
        }

        boolean valido = metodosAsociacionController.desasociarEstudianteACurso(idEstudiante, idCurso);

        if (valido) {
            mostrarAlerta("Éxito", "Estudiante desasociado al curso correctamente.");

            try {
                CrudCursoViewController crudCurso = ControllerCommunicator.getCrudCursoViewController();
                CrudEstudianteViewController crudEstudiante = ControllerCommunicator.getCrudEstudianteViewController();

                if (crudCurso != null) crudCurso.refrescarTablaCursos();
                if (crudEstudiante != null) crudEstudiante.refrescarTablaEstudiantes();

            } catch (Exception e) {
                System.out.println("No se pudo refrescar la tabla: " + e.getMessage());
            }

            limpiarCamposDesasociarEstudiante();
        } else {
            mostrarAlerta("Error", "No se encontró estudiante o curso, o la asociación falló");
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
    private void limpiarCamposDesasociarDocente() {
        txtIdDocenteDesasociar.clear();
        txtIdCursoDesasociarDocente.clear();
    }
    private void limpiarCamposAsociarEstudiante() {
        txtIdEstudianteAsociar.clear();
        txtIdCursoAsociarEstudiante.clear();
    }
    private void limpiarCamposDesasociarEstudiante() {
        txtIdEstudianteDesasociar.clear();
        txtIdCursoDesasociarEstudiante.clear();
    }


}
