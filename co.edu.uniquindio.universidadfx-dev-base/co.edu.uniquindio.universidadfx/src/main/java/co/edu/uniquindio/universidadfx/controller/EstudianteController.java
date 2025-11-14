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

    public Estudiante crearEstudiante(String nombre,
                                      String apellido,
                                      String identificacion,
                                      String edad,
                                      String correo,
                                      String semestre,
                                      String nota1,
                                      String nota2,
                                      String nota3,
                                      String nota4,
                                      String nota5) {
        return modelFactory.crearEstudiante(nombre,
                apellido,
                identificacion,
                edad,
                correo,
                semestre,
                nota1,
                nota2,
                nota3, nota4, nota5);
    }
    public Estudiante actualizarEstudiante(String nombre,
                                           String apellido,
                                           String identificacion,
                                           String edad,
                                           String correo,
                                           String semestre,
                                           String nota1,
                                           String nota2,
                                           String nota3,
                                           String nota4,
                                           String nota5){
        return modelFactory.actualizarEstudiante(nombre,
                apellido,
                identificacion,
                edad,
                correo,
                semestre,
                nota1,
                nota2,
                nota3, nota4, nota5);
    }
    public Estudiante eliminarEstudiante(String identificacion) {
        return modelFactory.eliminarEstudiante(identificacion);
    }
}
