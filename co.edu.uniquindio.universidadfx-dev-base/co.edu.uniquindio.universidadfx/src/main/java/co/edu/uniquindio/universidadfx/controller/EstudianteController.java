package co.edu.uniquindio.universidadfx.controller;

import co.edu.uniquindio.universidadfx.factory.ModelFactory;
import co.edu.uniquindio.universidadfx.model.Estudiante;

import java.util.List;

public class EstudianteController {
    ModelFactory modelFactory;


    public EstudianteController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<Estudiante> obtenerEstudiantes() {
        return modelFactory.obtenerEstudiantes();
    }

    public Estudiante crearEstudiante(String nombre, String apellido, String identificacion, String edad) {
        return modelFactory.crearEstudiante(nombre,apellido,identificacion,edad);
    }
}
