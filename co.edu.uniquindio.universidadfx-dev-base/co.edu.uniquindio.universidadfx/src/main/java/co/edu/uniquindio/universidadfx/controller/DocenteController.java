package co.edu.uniquindio.universidadfx.controller;

import co.edu.uniquindio.universidadfx.factory.ModelFactory;
import co.edu.uniquindio.universidadfx.model.Docente;
import co.edu.uniquindio.universidadfx.model.Estudiante;

import java.util.List;

public class DocenteController {
    ModelFactory modelFactory;


    public DocenteController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<Docente> obtenerDocentes() {
        return modelFactory.obtenerDocentes();
    }

    public Docente crearDocente(String nombre,String apellido,String identificacion,String edad,String correo) {
        return modelFactory.crearDocente(nombre, apellido, identificacion, edad, correo);
    }
    public Docente actualizarDocente(String nombre,String apellido,String identificacion,String edad,String correo) {
        return modelFactory.actualizarDocente(nombre, apellido, identificacion, edad, correo);
    }
    public Docente eliminarDocente(String identificacion) {
        return modelFactory.eliminarDocente(identificacion);
    }
}
