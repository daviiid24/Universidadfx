package co.edu.uniquindio.universidadfx.viewcontroller;

import co.edu.uniquindio.universidadfx.controller.ConsultasController;
import co.edu.uniquindio.universidadfx.controller.CursoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConsultasViewController {

    ConsultasController consultasController;


    @FXML
    private Button btnConsultarDocente;

    @FXML
    private Button btnConsultarDocentes;

    @FXML
    private Button btnConsultarNotas;

    @FXML
    private TextField txtIdDocente;

    @FXML
    private TextField txtIdDocenteNotas;

    @FXML
    private TextArea txtResultado;

    @FXML
    void onActionConsultarDocente(ActionEvent event) {
            consultarDocente();
    }

    @FXML
    void onActionConsultarDocentes(ActionEvent event) {
        //consultarDocentes();

    }

    @FXML
    void onActionConsultarNotas(ActionEvent event) {
            consultarDefinitivas();
    }


    @FXML
    void initialize() {
        consultasController = new ConsultasController();
    }

    private void consultarDefinitivas() {
        String idDocente=txtIdDocenteNotas.getText();

        if(!idDocente.isEmpty()){
            String resultado=consultasController.consultarDefinitivas(idDocente);
            txtResultado.setText(resultado);
        }
    }
    private void consultarDocente() {
        String idDocente = txtIdDocente.getText();

        if (!idDocente.isEmpty()) {
            String resultado = consultasController.consultarDocente(idDocente);
            txtResultado.setText(resultado);
        }
    }

    /*private void consultarNotasMayor() {
        String idDocente = txtIdDocenteNotaAlta.getText();

        if (!idDocente.isEmpty()) {
            String resultado = consultasController.consultarNotasMayor(idDocente);
            txtResultado.setText(resultado);
        }
    }*/

}
