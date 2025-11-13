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

    public boolean desasociarDocenteCurso(String idDocente, String idCurso) {
        return modelFactory.desasociarDocenteCurso(idDocente, idCurso);
    }

    public boolean asociarEstudianteACurso(String idEstudiante, String idCurso) {
        return modelFactory.asociarEstudianteACurso(idEstudiante, idCurso);
    }

    public boolean desasociarEstudianteACurso(String idEstudiante, String idCurso) {
        return modelFactory.desasociarEstudianteACurso(idEstudiante, idCurso);
    }
}
