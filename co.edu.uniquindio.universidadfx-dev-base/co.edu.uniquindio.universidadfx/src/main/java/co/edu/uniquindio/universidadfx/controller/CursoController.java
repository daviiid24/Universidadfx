package co.edu.uniquindio.universidadfx.controller;

import co.edu.uniquindio.universidadfx.factory.ModelFactory;
import co.edu.uniquindio.universidadfx.model.Curso;
import co.edu.uniquindio.universidadfx.model.Docente;

import java.util.List;

public class CursoController {
    ModelFactory modelFactory;


    public CursoController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<Curso> obtenerCursos() {
        return modelFactory.obtenerCursos();
    }

    public Curso crearCurso(String nombre,String semestre, String grupo, String creditos, String jornada, String identificacion) {
        return modelFactory.crearCurso(nombre, semestre, grupo, creditos, jornada, identificacion);
    }
    public Curso actualizarCurso(String nombre,String semestre, String grupo, String creditos, String jornada, String identificacion) {
        return modelFactory.actualizarCurso(nombre, semestre, grupo, creditos, jornada, identificacion);
    }
    public Curso eliminarCurso(String identificacion) {
        return modelFactory.eliminarCurso(identificacion);
    }
}
