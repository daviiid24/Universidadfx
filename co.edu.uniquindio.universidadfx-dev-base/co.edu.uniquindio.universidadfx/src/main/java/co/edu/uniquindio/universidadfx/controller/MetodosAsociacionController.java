package co.edu.uniquindio.universidadfx.controller;

import co.edu.uniquindio.universidadfx.factory.ModelFactory;

public class MetodosAsociacionController {
    ModelFactory modelFactory;

    public MetodosAsociacionController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public boolean asociarDocenteCurso(String idDocente, String idCurso) {
        return modelFactory.asociarDocenteCurso(idDocente, idCurso);
    }
}
